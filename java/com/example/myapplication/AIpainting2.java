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
import com.example.myapplication.databinding.ActivityAipainting2Binding;
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
//粉色的AI绘画页面

public class AIpainting2 extends AppCompatActivity {
    private ActivityAipainting2Binding binding;
    Uri uriImport;
    private Uri imageUri;
    public int scale = 0;
    private File outputImage;
    private boolean isFirst = true;


    private ActivityResultLauncher<Intent> takePhotoLauncher, importPhotoLauncher;
    private String token;
    private DialogLoading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAipainting2Binding.inflate(getLayoutInflater());//这个是绑定布局文件的第二种方式
        setContentView(binding.getRoot());
        /*&&&&&&&&&&&&&&&&&&&底边栏三个按钮&&&&&&&&&&&&&&&&&&*/
        //主页按钮
        ImageButton imageButton1 = findViewById(R.id.imbutton_home);
        imageButton1.setOnClickListener(v -> {
            imageButton1.setBackgroundColor(Color.parseColor("#FFD5B2B2"));
            Intent intent = new Intent(AIpainting2.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        //我的色卡按钮
        ImageButton imageButton2 = findViewById(R.id.imbutton_seka);
        imageButton2.setOnClickListener(v -> {
            Intent intent = new Intent(AIpainting2.this, SekaBlue.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        //社区交流按钮
        ImageButton imageButton3 = findViewById(R.id.imbutton_shequ);
        imageButton3.setOnClickListener(v -> {

            Intent intent =new Intent();
            if(switchTheme==1) {
                intent.setClass(AIpainting2.this, society.class);
            }
            else if(switchTheme==0){
                intent.setClass(AIpainting2.this, Society2.class);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        /*&&&&&&&&&&&&&&&&&&&底边栏三个按钮&&&&&&&&&&&&&&&&&&*/

        //左上角返回按钮
        ImageButton imageButton = findViewById(R.id.back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AIpainting2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        //用于上传图片后显示的“加载中...”
        loading = new DialogLoading(this);

        //用于处理从相机拍照获取图片
        takePhotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {// 检查结果是否为 RESULT_OK，表示操作成功
                        if (imageUri != null) {// 检查拍照时是否已经设置了目标图片 URI
                            binding.picture.setImageURI(imageUri);// 拍照得到的图片放到picture组件中
                            binding.picture.setBackgroundColor(Color.TRANSPARENT);
                            scale = 1;
                        }
                    }
                });

        //用于处理从相册导入获取图片
        importPhotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result != null && result.getData() != null && result.getData().getData() != null) {// 确保结果、数据和图片 URI 都不为空
                        uriImport = result.getData().getData();// 获取选择图片的 URI
                        binding.picture.setImageURI(uriImport);
                        binding.picture.setBackgroundColor(Color.TRANSPARENT);
                        scale = 2;
                    }
                }
        );

        /*&&&&&&&&&&&&&&&&&&&以下为页面中的5个按钮&&&&&&&&&&&&&&&&&&&&*/
        //拍照导入按钮
        binding.buttonShot2.setOnClickListener(view -> {
            requestPermission();//请求权限+拍照
        });

        //确认按钮
        Button queren = (Button)findViewById(R.id.queren);
        queren.setOnClickListener(view -> {
            if(scale == 1) {
                selfieAnime(outputImage, token);//scale=1代表是拍照获取的图片，直接调用selfieAnime对该图片进行动漫化
            }
            else if(scale == 2){
                selfieAnime(new File(GetFilePathFromUri.getFileAbsolutePath(AIpainting2.this, uriImport)), token);
                //scale=2代表是相册导入的图片，因为相册导入是获取的uri，因此通过该uri创建文件才能调用selfieAnime
            }
            else if(scale == 0){
                wordTransferPicture(token);//scale=0说明是文生图功能，只需要传token即可
            }
            //这个token你们可以理解为是一个调用AI模型的通行证，getAccessToken()函数获取

        });

        //相册导入按钮
        binding.buttonImport2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            importPhotoLauncher.launch(intent);
        });

        //保存图片按钮
        Button save = findViewById(R.id.save);
        save.setOnClickListener(view -> {
            ImageView imageView = findViewById(R.id.picture);
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            String savedImagePath = null;
            String imageFileName = "JPEG_" + System.currentTimeMillis() + ".jpg";
            File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/YourAppName");
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
                Toast.makeText(AIpainting2.this, "图片已保存", Toast.LENGTH_SHORT).show();
            }
        });

        //收藏图片按钮
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
        /*&&&&&&&&&&&&&&&&&&&以上为页面中的5个按钮&&&&&&&&&&&&&&&&&&&&*/

        requestPermission();
        getAccessToken();
    }

    public String savePicture(Bitmap bitmap){
        //该函数是专门给收藏图片用的保存图片操作，写这个是因为收藏图片需要先保存到bending才能得到path去收藏
        String fileName = "IMG_" + System.currentTimeMillis() + ".jpg"; // 图片文件名
        File storageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "YourAppFolder");
        // 图片保存的目录
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

    private void takePhoto() {
        outputImage = new File(getExternalCacheDir(), "output_image_" + new Date().getTime() + ".jpg");
            /*
            创建一个File文件对象，用于存放摄像头拍下的图片，我们把这个图片命名为output_image.jpg
            并把它存放在应用关联缓存目录下，调用getExternalCacheDir()可以得到这个目录，为什么要
            用关联缓存目录呢？由于android6.0开始，读写sd卡列为了危险权限，使用的时候必须要有权限，
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
            imageUri = FileProvider.getUriForFile(AIpainting2.this,
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
            //如果检查没有获取到权限，会先获取权限
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
        //获取token，这样才能启动AI模型调用的功能
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

    private void lovePicture(String savedImagePath) {
        //收藏图片功能，仍然是发送post请求到后端服务器，说白了就是把图片保存在服务区中，具体以什么方式保存那是后端该操心的事了，我们发送并收到成功响应就行
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
                            Toast.makeText(AIpainting2.this, "收藏成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    /**
     * 动漫化
     *
     //     * @param file        图片
     //     * @param accessToken
     * @return
     */
    private void wordTransferPicture(String accessToken){
        //文生图功能函数，不需要图片只用文字描述，调用AI模型生成图片
        //道理差不多，获取输入框的文字然后发送post请求，并等待响应
        //获取AI模型返回的图片在函数getAiResult中
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
        //请求AI大模型发送图片并返回动漫化的图片，发送post请求然后填写一些必要的参数
        //获取AI模型返回的图片在函数getAiResult中
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
                JSONObject jsonObject = new JSONObject(response.body().string());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            getAiResult(accessToken, jsonObject.getJSONObject("data").getString("task_id"));
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void getAiResult(String accessToken, String taskId) {
        //获取AI模型返回的结果
        //根据上一个响应得到的taskId来拿返回的图片，然后加载到picture组件中
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
}