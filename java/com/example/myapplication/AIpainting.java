package com.example.myapplication;

import static com.example.myapplication.MainActivity.switchTheme;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.bean.AiImgRoot;
import com.example.myapplication.databinding.ActivityAipaintingBinding;
import com.example.myapplication.utils.Base64Util;
import com.example.myapplication.utils.DialogLoading;
import com.example.myapplication.utils.FileUtil;
import com.example.myapplication.utils.GetFilePathFromUri;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//蓝色的AI绘画页面，代码基本和AIpainting2相同，请看AIpainting2类
public class AIpainting extends AppCompatActivity {

    private ActivityAipaintingBinding binding;

    private File outputImage;
    private boolean isFirst = true;
    private Uri imageUri;

    private ActivityResultLauncher<Intent> takePhotoLauncher, importPhotoLauncher;
    private String token;
    private DialogLoading loading;
    private Uri uriImport;
    public int scale = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAipaintingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ImageButton imageButton1 = findViewById(R.id.imbutton_home);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AIpainting.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        ImageButton imageButton2 = findViewById(R.id.imbutton_seka);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AIpainting.this, SekaBlue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        ImageButton imageButton3 = findViewById(R.id.imbutton_shequ);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                if(switchTheme==1) {
                    intent.setClass(AIpainting.this, society.class);
                }
                else if(switchTheme==0){
                    intent.setClass(AIpainting.this, Society2.class);
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        ImageButton imageButton = findViewById(R.id.back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AIpainting.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        loading = new DialogLoading(this);

        takePhotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        if (imageUri != null) {
                            binding.picture.setImageURI(imageUri);
                            binding.picture.setBackgroundColor(Color.TRANSPARENT);
                            scale = 1;
                        }
                    }
                });
        Button queren = (Button)findViewById(R.id.queren);
        queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scale == 1) {
                    selfieAnime(outputImage, token);
                    scale =0;
                }
                else if(scale == 2){
                    selfieAnime(new File(GetFilePathFromUri.getFileAbsolutePath(AIpainting.this, uriImport)), token);
                    scale =0;
                }
                else if(scale == 0){
                    wordTransferPicture(token);
                }
            }
        });

        Button love = findViewById(R.id.love);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = findViewById(R.id.picture);
                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String imagePath = savePicture(bitmap);
                System.out.println(imagePath);
                if(imagePath!=null) {
                    System.out.println("开始收藏");
                    lovePicture(imagePath);
                }
            }
        });

        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = findViewById(R.id.picture);
                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String savedImagePath = null;
                String imageFileName = "JPEG_" + System.currentTimeMillis() + ".jpg";
                File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Colifer");
                boolean success = true;
                if (!storageDir.exists()) {
                    success = storageDir.mkdirs();
                }
                if (success) {
                    File imageFile = new File(storageDir, imageFileName);
                    savedImagePath = imageFile.getAbsolutePath();
                    try {
                        OutputStream fOut = new FileOutputStream(imageFile);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                        fOut.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // 把文件添加到媒体库
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.DATA, savedImagePath);
                    values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                    getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                    // 发送广播通知媒体扫描器扫描新的文件
                    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    File f = new File(savedImagePath);
                    Uri contentUri = Uri.fromFile(f);
                    mediaScanIntent.setData(contentUri);
                    sendBroadcast(mediaScanIntent);

                    // 显示一个Toast消息
                    Toast.makeText(AIpainting.this, "图片已保存", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonShot2.setOnClickListener(view -> {
            requestPermission();
        });

        importPhotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result != null && result.getData() != null && result.getData().getData() != null) {
                        // 得到图片的全路径
                        uriImport = result.getData().getData();
                        binding.picture.setImageURI(uriImport);
                        binding.picture.setBackgroundColor(Color.TRANSPARENT);
                        scale = 2;
                    }
                }
        );

        binding.buttonImport2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            importPhotoLauncher.launch(intent);
        });

        requestPermission();
        getAccessToken();
    }

    private void lovePicture(String savedImagePath) {
        new Thread(() -> {
            final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();
            // 创建一个RequestBody对象，包含你要发送的数据
            assert savedImagePath != null;
            MediaType mediaType = MediaType.parse("image/jpeg");
            File file = new File(savedImagePath); // 替换为实际的图片路径
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("image", file.getName(), RequestBody.create(mediaType, file))
                    .build();
            Request request = new Request.Builder()
                    .url("http://120.53.102.245:8000/upload_child_image/4/")  // 替换为实际的URL和child_id
                    .method("POST", body)
                    .build();
            System.out.println("http://120.53.102.245:8000/upload_child_image/"+ Login.currentUser.child_id+"/");
            try {
                Response response = HTTP_CLIENT.newCall(request).execute();
                System.out.println("Response code: " + response.code());
                System.out.println("Response message: " + response.message());
                System.out.println(response.isSuccessful());
                if (response.isSuccessful()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AIpainting.this, "收藏成功", Toast.LENGTH_SHORT).show();
                        }
                        });
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

            private void takePhoto() {
        outputImage = new File(getExternalCacheDir(), "output_image_" + new Date().getTime() + ".jpg");
            /*
            创建一个File文件对象，用于存放摄像头拍下的图片，我们把这个图片命名为output_image.jpg
            并把它存放在应用关联缓存目录下，调用getExternalCacheDir()可以得到这个目录，由于android6.0开始，读写sd卡列为了危险权限，使用的时候必须要有权限，
            应用关联目录则可以跳过这一步
             */
        try//判断图片是否存在，存在则删除在创建，不存在则直接创建
        {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断安卓的版本是否高于7.0，高于则调用高于的方法，低于则调用低于的方法
        //把文件转换成Uri对象
        //之所以这样，是因为android7.0以后直接使用本地真实路径是不安全的，会抛出异常。
        //FileProvider是一种特殊的内容提供器，可以对数据进行保护
        if (Build.VERSION.SDK_INT >= 24) {
            imageUri = FileProvider.getUriForFile(AIpainting.this,
                    "com.example.myapplication.fileprovider", outputImage);
                /*
                第一个参数：context对象
                第二个参数：任意唯一的字符串
                第三个参数：文件对象
                 */

        } else {
            imageUri = Uri.fromFile(outputImage);
        }
        //使用隐示的Intent，系统会找到与它对应的活动，即调用摄像头，并把它存储
        //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Intent intent = new Intent("android.media.action.STILL_IMAGE_CAMERA");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        //intentActivityResultLauncher.launch(intent);
        //startActivityForResult(intent,TAKE_PHOTO);
        takePhotoLauncher.launch(intent);


        //调用会返回结果的开启方式，返回成功的话，则把它显示出来
    }

    private void requestPermission() {
        if (!PermissionUtils.checkPermission(this, Manifest.permission.CAMERA)
                || !PermissionUtils.checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            PermissionUtils.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x11);
        } else {
            if (!isFirst)
                takePhoto();
            isFirst = false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (!PermissionUtils.requestPermissionsResult(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, permissions, grantResults)) {
            Toast.makeText(this, "需要相机和读写文件权限才可正常使用", Toast.LENGTH_LONG).show();
        } else {
            if (!isFirst)
                takePhoto();
        }

        isFirst = false;
    }

    /**
     * 初始化okhttp
     */
    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    /**
     * 获取token
     */
    private void getAccessToken() {
        new Thread(() -> {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://aip.baidubce.com/oauth/2.0/token?client_id=aHDKjbRxCoS3dZBZ76fj55Lv&client_secret=k7OX09lzt16901RFpCDGI1u1s0ZS2yzG&grant_type=client_credentials")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build();
            try {
                Response response = HTTP_CLIENT.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());

                token = jsonObject.getString("access_token");
                System.out.println("getAccessToken:" + token);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }).start();
    }


    /*
        static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public static void main(String []args) throws IOException{
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"prompt\":\"动漫\",\"version\":\"v2\",\"width\":1024,\"height\":1024}");
        Request request = new Request.Builder()
            .url("https://aip.baidubce.com/rpc/2.0/ernievilg/v1/txt2imgv2?access_token=")
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());

    }
     */

    /**
     * 动漫化
     *
//     * @param file        图片
//     * @param accessToken
     * @return
     */
    private void wordTransferPicture(String accessToken){
        loading.show();
        EditText prompt = findViewById(R.id.prompt);
        String p = prompt.getText().toString();
        new Thread(() -> {
            final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

                MediaType mediaType = MediaType.parse("application/json");

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("prompt", "卡通简笔画，儿童插画风格，可爱，浅色"+p);
                paramMap.put("version", "v2");
                paramMap.put("width", 1024);
                paramMap.put("height", 1024);

                RequestBody body = RequestBody.create(mediaType, new Gson().toJson(paramMap));
                Request request = new Request.Builder()
                        .url("https://aip.baidubce.com/rpc/2.0/ernievilg/v1/txt2imgv2?access_token=" + accessToken)
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .build();
            Response response = null;
            try {
                response = HTTP_CLIENT.newCall(request).execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response.body().string());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                getAiResult(accessToken, jsonObject.getJSONObject("data").getString("task_id"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }
    private void selfieAnime(File file, String accessToken) {
        loading.show();
        new Thread(() -> {
            // 请求url
            //String url = "https://aip.baidubce.com/rpc/2.0/ernievilg/v1/txt2imgv2";
            final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();
            try {
                byte[] imgData = FileUtil.readFileByBytes(file);
                String imgStr = Base64Util.encode(imgData);
                MediaType mediaType = MediaType.parse("application/json");

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("prompt", "卡通简笔画，儿童插画风格，可爱，浅色");
                paramMap.put("version", "v2");
                paramMap.put("width", 1024);
                paramMap.put("height", 1024);
                paramMap.put("change_degree", 6);
                paramMap.put("image", imgStr);

                RequestBody body = RequestBody.create(mediaType, new Gson().toJson(paramMap));
                Request request = new Request.Builder()
                        .url("https://aip.baidubce.com/rpc/2.0/ernievilg/v1/txt2imgv2?access_token=" + accessToken)
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .build();
                Response response = HTTP_CLIENT.newCall(request).execute();
//                System.out.println(response.body().string());

                JSONObject jsonObject = new JSONObject(response.body().string());
                getAiResult(accessToken, jsonObject.getJSONObject("data").getString("task_id"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void getAiResult(String accessToken, String taskId) {
        loading.show();
        new Thread(() -> {
            final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();
            try {
                MediaType mediaType = MediaType.parse("application/json");

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("task_id", taskId);

                RequestBody body = RequestBody.create(mediaType, new Gson().toJson(paramMap));
                Request request = new Request.Builder()
                        .url("https://aip.baidubce.com/rpc/2.0/ernievilg/v1/getImgv2?access_token=" + accessToken)
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .build();
                Response response = HTTP_CLIENT.newCall(request).execute();
                String resultStr = response.body().string();
                System.out.println("resultStr = " + resultStr);
                AiImgRoot aiImgRoot = new Gson().fromJson(resultStr, AiImgRoot.class);

                if ("RUNNING".equals(aiImgRoot.getData().getTask_status())) {
                    runOnUiThread(() -> {
                        System.out.println("生成中，请稍候~");
                    });
                    Thread.sleep(3000);
                    getAiResult(accessToken, taskId);
                    return;
                }
                if ("SUCCESS".equals(aiImgRoot.getData().getTask_status())) {
                    runOnUiThread(() -> {
                        System.out.println("加载完成");
                        String imgUrl = aiImgRoot.getData().getSub_task_result_list().get(0).getFinal_image_list().get(0).getImg_url();
                        System.out.println("imgUrl = " + imgUrl);
                        Glide.with(this).load(imgUrl).into(binding.picture);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (loading != null && loading.isShowing()) {
                                    loading.dismiss();
                                }
                            }
                        });
                    });
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    public String savePicture(Bitmap bitmap){
        String fileName = "IMG_" + System.currentTimeMillis() + ".jpg"; // 图片文件名
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); // 图片保存的目录
        File imageFile = new File(storageDir, fileName); // 图片文件

        String savedImagePath = null;
        try {
            OutputStream fOut = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
            fOut.close();
            savedImagePath = imageFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 把文件添加到媒体库
        if (savedImagePath != null) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DATA, savedImagePath);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        }

        return savedImagePath;
    }
}
//package baidu.com;
//
//        import okhttp3.*;
//        import org.json.JSONObject;
//
//        import java.io.*;
//
//class Sample {
//
//    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();
//
//    public static void main(String []args) throws IOException{
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"prompt\":\"动漫\",\"version\":\"v2\",\"width\":1024,\"height\":1024}");

//                .url("https://aip.baidubce.com/rpc/2.0/ernievilg/v1/txt2imgv2?access_token=")
//                .method("POST", body)
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Accept", "application/json")
//                .build();
//        Response response = HTTP_CLIENT.newCall(request).execute();
//        System.out.println(response.body().string());
//
//    }
//
//
//}