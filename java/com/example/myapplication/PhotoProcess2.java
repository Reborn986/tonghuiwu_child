package com.example.myapplication;

import static com.example.myapplication.MainActivity.switchTheme;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.utils.ImageUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class PhotoProcess2 extends AppCompatActivity {

    public static class FloatingWindowExample {

        public static void showFloatingWindow(Context context, String message) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

//    public static class CursorView extends View {
//        private float cursorX;
//        private float cursorY;
//        private Paint cursorPaint;
//
//        public CursorView(Context context) {
//            super(context);
//            init();
//        }
//
//        public CursorView(Context context, AttributeSet attrs) {
//            super(context, attrs);
//            init();
//        }
//
//        private void init() {
//            cursorPaint = new Paint();
//            cursorPaint.setARGB(255, 43, 111, 110);
//            cursorPaint.setStyle(Paint.Style.FILL);
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            canvas.drawCircle(cursorX, cursorY, 10, cursorPaint);
//        }
//
//        @Override
//        public boolean onTouchEvent(MotionEvent event) {
//            cursorX = event.getX();
//            cursorY = event.getY();
//            cursorPaint.setARGB(255, 43, 111, 110);
//            invalidate(); // 通知 View 重新绘制
//            return true;
//        }
//
//    }


    private SeekBar seekBarR, seekBarG, seekBarB, seekBarBl;
    private TextView textViewR, textViewG, textViewB, textViewBl;
//    int number = 0;


    //public static final int TAKE_PHOTO = 1;

    private ImageView picture;
    private Uri imageUri;
    private SurfaceView surfaceView;
    private Camera camera;
    public static final int TAKE_PHOTO = 1;//声明一个请求码，用于识别返回的结果
    private File outputImage;
    private Button buttonImport;
    private boolean isFirst = true;

    private ActivityResultLauncher<Intent> takePhotoLauncher, importPhotoLauncher;


    //色卡点击显示十六进制和rgb色号
    View blockView1;
    View blockView2;
    View blockView3;
    View blockView4;
    View blockView5;
    View blockView6;

    View controlSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoprocess2);
        FrameLayout frameLayout1 = findViewById(R.id.fr);
        frameLayout1.setAlpha(0f);
        LinearLayout frameLayout3 = findViewById(R.id.li);
        frameLayout3.setAlpha(0f);
        // 创建一个属性动画对象，设置动画的属性为 "translationY"，即垂直方向的平移
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(frameLayout1, "translationY", -800f, 0f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(frameLayout1, "alpha", 0f, 1f);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(frameLayout3, "alpha", 0f, 1f);
        // 设置动画的持续时间
        animator1.setDuration(1000);
        animator3.setDuration(1000);
        animator5.setDuration(1000);
        // 启动动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator1, animator3, animator5);
        animatorSet.start();


        //底边栏处理
        ImageButton imageButton1 = findViewById(R.id.imbutton_home);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhotoProcess2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        ImageButton imageButton2 = findViewById(R.id.imbutton_seka);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhotoProcess2.this, SekaBlue.class);
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
                    intent.setClass(PhotoProcess2.this, society.class);
                }
                else if(switchTheme==0){
                    intent.setClass(PhotoProcess2.this, Society2.class);
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        ImageButton back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhotoProcess2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        blockView1 = findViewById(R.id.color_block1);
        blockView2 = findViewById(R.id.color_block2);
        blockView3 = findViewById(R.id.color_block3);
        blockView4 = findViewById(R.id.color_block4);
        blockView5 = findViewById(R.id.color_block5);
        blockView6 = findViewById(R.id.color_block6);


        //3个seekbar
        textViewR = findViewById(R.id.textView_R);
        textViewG = findViewById(R.id.textView_G);
        textViewB = findViewById(R.id.textView_B);

        seekBarR = findViewById(R.id.seekBar_R);
        seekBarG = findViewById(R.id.seekBar_G);
        seekBarB = findViewById(R.id.seekBar_B);

        seekBarR.setMax(255);
        seekBarG.setMax(255);
        seekBarB.setMax(255);

        seekBarR.setProgress(0);
        seekBarG.setProgress(0);
        seekBarB.setProgress(0);


        ImageButton takephoto = findViewById(R.id.button_shot);
        picture = findViewById(R.id.picture);
        ImageButton buttonImport = findViewById(R.id.button_import);

        takePhotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        if (imageUri != null) {
                            picture.setImageURI(imageUri);
                            setColorCard();
                        }
                    }
                });
        takephoto.setOnClickListener(view -> {
            requestPermission();
        });

        importPhotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result != null && result.getData() != null && result.getData().getData() != null) {
                        // 得到图片的全路径
                        Uri uri = result.getData().getData();
                        imageUri = uri;
                        ContentResolver contentResolver = getContentResolver();
                        Cursor cursor = contentResolver.query(uri, null, null, null, null);

                        // 获取文件路径
                        String filePath = null;
                        if (cursor != null && cursor.moveToFirst()) {
                            int columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                            filePath = cursor.getString(columnIndex);
                        }

                        System.out.println("filePath:" + filePath);

                        // 关闭 Cursor 对象
                        if (cursor != null) {
                            cursor.close();
                        }

                        // 将图片设置给 ImageView 控件
                        ImageView picture = findViewById(R.id.picture);
                        picture.setImageURI(uri);

                        setColorCard();

//                        if (filePath != null) {
//                    }

                    }
                }
        );

        buttonImport.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            importPhotoLauncher.launch(intent);
        });

        requestPermission();


        ImageButton quseqiButton = findViewById(R.id.quseqi);

        quseqiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout liXuanzeyanse = findViewById(R.id.li_xuanzeyanse);
                liXuanzeyanse.setVisibility(View.VISIBLE);
            }
        });
        final int[] value = {0};
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                value[0] = Integer.parseInt(editText.getText().toString());
                if (value[0] < 1 || value[0] > 6) {
                    PhotoProcess.FloatingWindowExample.showFloatingWindow(PhotoProcess2.this, "只能输入1-6的整数");
                }
                LinearLayout liXuanzeyanse = findViewById(R.id.li_xuanzeyanse);
                liXuanzeyanse.setVisibility(View.GONE);
            }
        });


        picture.setOnTouchListener((v, event) -> {
            //判断是否平移裁剪拉伸
            int imageViewWidth = picture.getWidth();
            int imageViewHeight = picture.getHeight();

            Drawable drawable = picture.getDrawable();
            if (drawable == null) return true;

            int imageWidth = drawable.getIntrinsicWidth();
            int imageHeight = drawable.getIntrinsicHeight();

            boolean isScaled = (imageViewWidth != imageWidth) || (imageViewHeight != imageHeight);
            boolean isTranslated = (picture.getTranslationX() != 0) || (picture.getTranslationY() != 0);
            boolean isCropped = (picture.getScaleType() == ImageView.ScaleType.CENTER_CROP) || (picture.getScaleType() == ImageView.ScaleType.CENTER_INSIDE);
            int x, y;

            if (isScaled == false && isTranslated == false && isScaled == false) {
                Rect imageViewRect = new Rect();
                picture.getDrawingRect(imageViewRect);
                int[] imageViewLocation = new int[2];
                picture.getLocationOnScreen(imageViewLocation);

                x = (int) event.getX() - imageViewLocation[0] - imageViewRect.left;
                y = (int) event.getY() - imageViewLocation[1] - imageViewRect.top;
            } else {

                Matrix matrix = picture.getImageMatrix();
                float[] coordinates = {event.getX(), event.getY()};
                matrix.invert(matrix);
                matrix.mapPoints(coordinates);

                x = (int) coordinates[0];
                y = (int) coordinates[1];
            }
            // 处理触摸事件
            int pixel, red, green, blue, alpha;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // 手指按下时的处理逻辑
                    Bitmap bitmap = ((BitmapDrawable) picture.getDrawable()).getBitmap();
                    if (x < 0 || y < 0 || x > bitmap.getWidth() || y > bitmap.getHeight())
                        return true;
                    pixel = bitmap.getPixel(x, y);
                    red = Color.red(pixel);
                    green = Color.green(pixel);
                    blue = Color.blue(pixel);
                    alpha = Color.alpha(pixel);
                    int backgroundColor = Color.rgb(red,green,blue);
                    // 获取控件对象
                    if (value[0] == 1) {
                        View imageView0 = findViewById(R.id.color_block1);
                        // 更改背景颜色
                        imageView0.setBackgroundColor(Color.rgb(red, green, blue));
                        // 创建一个 LayerDrawable 对象，用于添加边框和圆角
                        Drawable[] layers = new Drawable[2];
// 创建一个圆角矩形形状
                        GradientDrawable shape = new GradientDrawable();
                        shape.setShape(GradientDrawable.RECTANGLE);
                        shape.setCornerRadius(10); // 设置圆角半径
                        shape.setColor(backgroundColor); // 设置背景颜色
// 创建一个描边形状
                        GradientDrawable stroke = new GradientDrawable();
                        stroke.setShape(GradientDrawable.RECTANGLE);
                        stroke.setCornerRadius(10); // 设置圆角半径
                        stroke.setStroke(5, Color.WHITE); // 设置描边颜色和宽度

// 将圆角矩形形状和描边形状添加到 LayerDrawable 中
                        layers[0] = shape;
                        layers[1]=stroke;
                        LayerDrawable layerDrawable = new LayerDrawable(layers);
// 将 LayerDrawable 设置为 View 的背景
                        imageView0.setBackground(layerDrawable);


                    } else if (value[0] == 2) {
                        View imageView0 = findViewById(R.id.color_block2);
                        // 更改背景颜色
                        imageView0.setBackgroundColor(Color.rgb(red, green, blue));
                        Drawable[] layers = new Drawable[2];
// 创建一个圆角矩形形状
                        GradientDrawable shape = new GradientDrawable();
                        shape.setShape(GradientDrawable.RECTANGLE);
                        shape.setCornerRadius(10); // 设置圆角半径
                        shape.setColor(backgroundColor); // 设置背景颜色
// 创建一个描边形状
                        GradientDrawable stroke = new GradientDrawable();
                        stroke.setShape(GradientDrawable.RECTANGLE);
                        stroke.setCornerRadius(10); // 设置圆角半径
                        stroke.setStroke(5, Color.WHITE); // 设置描边颜色和宽度

// 将圆角矩形形状和描边形状添加到 LayerDrawable 中
                        layers[0] = shape;
                        layers[1]=stroke;
                        LayerDrawable layerDrawable = new LayerDrawable(layers);
// 将 LayerDrawable 设置为 View 的背景
                        imageView0.setBackground(layerDrawable);

                    } else if (value[0] == 3) {
                        View imageView0 = findViewById(R.id.color_block3);
                        // 更改背景颜色
                        imageView0.setBackgroundColor(Color.rgb(red, green, blue));
                        Drawable[] layers = new Drawable[2];
// 创建一个圆角矩形形状
                        GradientDrawable shape = new GradientDrawable();
                        shape.setShape(GradientDrawable.RECTANGLE);
                        shape.setCornerRadius(10); // 设置圆角半径
                        shape.setColor(backgroundColor); // 设置背景颜色
// 创建一个描边形状
                        GradientDrawable stroke = new GradientDrawable();
                        stroke.setShape(GradientDrawable.RECTANGLE);
                        stroke.setCornerRadius(10); // 设置圆角半径
                        stroke.setStroke(5, Color.WHITE); // 设置描边颜色和宽度

// 将圆角矩形形状和描边形状添加到 LayerDrawable 中
                        layers[0] = shape;
                        layers[1]=stroke;
                        LayerDrawable layerDrawable = new LayerDrawable(layers);
// 将 LayerDrawable 设置为 View 的背景
                        imageView0.setBackground(layerDrawable);

                    } else if (value[0] == 4) {
                        View imageView0 = findViewById(R.id.color_block4);
                        // 更改背景颜色
                        imageView0.setBackgroundColor(Color.rgb(red, green, blue));
                        Drawable[] layers = new Drawable[2];
// 创建一个圆角矩形形状
                        GradientDrawable shape = new GradientDrawable();
                        shape.setShape(GradientDrawable.RECTANGLE);
                        shape.setCornerRadius(10); // 设置圆角半径
                        shape.setColor(backgroundColor); // 设置背景颜色
// 创建一个描边形状
                        GradientDrawable stroke = new GradientDrawable();
                        stroke.setShape(GradientDrawable.RECTANGLE);
                        stroke.setCornerRadius(10); // 设置圆角半径
                        stroke.setStroke(5, Color.WHITE); // 设置描边颜色和宽度

// 将圆角矩形形状和描边形状添加到 LayerDrawable 中
                        layers[0] = shape;
                        layers[1]=stroke;
                        LayerDrawable layerDrawable = new LayerDrawable(layers);
// 将 LayerDrawable 设置为 View 的背景
                        imageView0.setBackground(layerDrawable);

                    } else if (value[0] == 5) {
                        View imageView0 = findViewById(R.id.color_block5);
                        // 更改背景颜色
                        imageView0.setBackgroundColor(Color.rgb(red, green, blue));
                        Drawable[] layers = new Drawable[2];
// 创建一个圆角矩形形状
                        GradientDrawable shape = new GradientDrawable();
                        shape.setShape(GradientDrawable.RECTANGLE);
                        shape.setCornerRadius(10); // 设置圆角半径
                        shape.setColor(backgroundColor); // 设置背景颜色
// 创建一个描边形状
                        GradientDrawable stroke = new GradientDrawable();
                        stroke.setShape(GradientDrawable.RECTANGLE);
                        stroke.setCornerRadius(10); // 设置圆角半径
                        stroke.setStroke(5, Color.WHITE); // 设置描边颜色和宽度

// 将圆角矩形形状和描边形状添加到 LayerDrawable 中
                        layers[0] = shape;
                        layers[1]=stroke;
                        LayerDrawable layerDrawable = new LayerDrawable(layers);
// 将 LayerDrawable 设置为 View 的背景
                        imageView0.setBackground(layerDrawable);

                    } else if (value[0] == 6) {
                        View imageView0 = findViewById(R.id.color_block6);
                        // 更改背景颜色
                        imageView0.setBackgroundColor(Color.rgb(red, green, blue));
                        Drawable[] layers = new Drawable[2];
// 创建一个圆角矩形形状
                        GradientDrawable shape = new GradientDrawable();
                        shape.setShape(GradientDrawable.RECTANGLE);
                        shape.setCornerRadius(10); // 设置圆角半径
                        shape.setColor(backgroundColor); // 设置背景颜色
// 创建一个描边形状
                        GradientDrawable stroke = new GradientDrawable();
                        stroke.setShape(GradientDrawable.RECTANGLE);
                        stroke.setCornerRadius(10); // 设置圆角半径
                        stroke.setStroke(5, Color.WHITE); // 设置描边颜色和宽度

// 将圆角矩形形状和描边形状添加到 LayerDrawable 中
                        layers[0] = shape;
                        layers[1]=stroke;
                        LayerDrawable layerDrawable = new LayerDrawable(layers);
// 将 LayerDrawable 设置为 View 的背景
                        imageView0.setBackground(layerDrawable);
                    }

                    break;
                case MotionEvent.ACTION_MOVE:
                    // 手指移动时的处理逻辑
                    break;
                case MotionEvent.ACTION_UP:
                    // 手指抬起时的处理逻辑
                    break;
            }

            return true;
        });


        blockView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColorCardInfo(v);
            }
        });
        blockView2.setOnClickListener(v -> setColorCardInfo(v));
        blockView3.setOnClickListener(v -> setColorCardInfo(v));
        blockView4.setOnClickListener(v -> setColorCardInfo(v));
        blockView5.setOnClickListener(v -> setColorCardInfo(v));
        blockView6.setOnClickListener(v -> setColorCardInfo(v));

        //根据seekbar更改颜色
        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewR.setText(progress + "");
                changeViewColor("r", progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewG.setText(progress + "");
                changeViewColor("g", progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewB.setText(progress + "");
                changeViewColor("b", progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //复制色号
        TextView shiliu = findViewById(R.id.shiliujinzhigeshi);
        registerForContextMenu(shiliu);

        shiliu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return true;
            }
        });

        //保存色卡////////////////////////////////////////////////////////////////////////
        ImageButton saveButton = findViewById(R.id.b_baocun);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout liSave = findViewById(R.id.li_baocundseka);
                liSave.setVisibility(View.VISIBLE);
                ImageView imSave = findViewById(R.id.im_baocuntupian);
                View viewSave1 = findViewById(R.id.v_baocunyanse1);
                View viewSave2 = findViewById(R.id.v_baocunyanse2);
                View viewSave3 = findViewById(R.id.v_baocunyanse3);
                View viewSave4 = findViewById(R.id.v_baocunyanse4);
                View viewSave5 = findViewById(R.id.v_baocunyanse5);
                View viewSave6 = findViewById(R.id.v_baocunyanse6);

                Glide.with(v).load(imageUri).into(imSave);

                Drawable drawable1=blockView1.getBackground();
                if(drawable1 instanceof LayerDrawable){
                    LayerDrawable layerDrawable1 = (LayerDrawable) drawable1;
                    Drawable background = layerDrawable1.getDrawable(0); // 获取第一个图层的Drawable
                    if(background instanceof GradientDrawable){
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        int backgroundColor = gradientDrawable.getColor().getDefaultColor();
                        // 创建一个GradientDrawable对象
                        GradientDrawable yuanjiao = new GradientDrawable();
                        yuanjiao.setShape(GradientDrawable.RECTANGLE);
// 设置圆角半径，单位为像素
                        int cornerRadius = 10;
                        yuanjiao.setCornerRadius(cornerRadius);
// 设置背景颜色
                        yuanjiao.setColor(backgroundColor);
// 将GradientDrawable对象设置为View的背景
                        viewSave1.setBackground(gradientDrawable);
                    }
                }
                Drawable drawable2=blockView2.getBackground();
                if(drawable2 instanceof LayerDrawable){
                    LayerDrawable layerDrawable1 = (LayerDrawable) drawable2;
                    Drawable background = layerDrawable1.getDrawable(0); // 获取第一个图层的Drawable
                    if(background instanceof GradientDrawable){
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        int backgroundColor = gradientDrawable.getColor().getDefaultColor();
                        GradientDrawable yuanjiao = new GradientDrawable();
                        yuanjiao.setShape(GradientDrawable.RECTANGLE);
// 设置圆角半径，单位为像素
                        int cornerRadius = 10;
                        yuanjiao.setCornerRadius(cornerRadius);
// 设置背景颜色
                        yuanjiao.setColor(backgroundColor);
// 将GradientDrawable对象设置为View的背景
                        viewSave2.setBackground(gradientDrawable);

                    }
                }
                Drawable drawable3=blockView3.getBackground();
                if(drawable3 instanceof LayerDrawable){
                    LayerDrawable layerDrawable1 = (LayerDrawable) drawable3;
                    Drawable background = layerDrawable1.getDrawable(0); // 获取第一个图层的Drawable
                    if(background instanceof GradientDrawable){
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        int backgroundColor = gradientDrawable.getColor().getDefaultColor();
                        GradientDrawable yuanjiao = new GradientDrawable();
                        yuanjiao.setShape(GradientDrawable.RECTANGLE);
// 设置圆角半径，单位为像素
                        int cornerRadius = 10;
                        yuanjiao.setCornerRadius(cornerRadius);
// 设置背景颜色
                        yuanjiao.setColor(backgroundColor);
// 将GradientDrawable对象设置为View的背景
                        viewSave3.setBackground(gradientDrawable);

                    }
                }
                Drawable drawable4=blockView4.getBackground();
                if(drawable4 instanceof LayerDrawable){
                    LayerDrawable layerDrawable1 = (LayerDrawable) drawable4;
                    Drawable background = layerDrawable1.getDrawable(0); // 获取第一个图层的Drawable
                    if(background instanceof GradientDrawable){
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        int backgroundColor = gradientDrawable.getColor().getDefaultColor();
                        GradientDrawable yuanjiao = new GradientDrawable();
                        yuanjiao.setShape(GradientDrawable.RECTANGLE);
// 设置圆角半径，单位为像素
                        int cornerRadius = 10;
                        yuanjiao.setCornerRadius(cornerRadius);
// 设置背景颜色
                        yuanjiao.setColor(backgroundColor);
// 将GradientDrawable对象设置为View的背景
                        viewSave4.setBackground(gradientDrawable);

                    }
                }
                Drawable drawable5=blockView5.getBackground();
                if(drawable5 instanceof LayerDrawable){
                    LayerDrawable layerDrawable1 = (LayerDrawable) drawable5;
                    Drawable background = layerDrawable1.getDrawable(0); // 获取第一个图层的Drawable
                    if(background instanceof GradientDrawable){
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        int backgroundColor = gradientDrawable.getColor().getDefaultColor();
                        GradientDrawable yuanjiao = new GradientDrawable();
                        yuanjiao.setShape(GradientDrawable.RECTANGLE);
// 设置圆角半径，单位为像素
                        int cornerRadius = 10;
                        yuanjiao.setCornerRadius(cornerRadius);
// 设置背景颜色
                        yuanjiao.setColor(backgroundColor);
// 将GradientDrawable对象设置为View的背景
                        viewSave5.setBackground(gradientDrawable);
                    }
                }
                Drawable drawable6=blockView6.getBackground();
                if(drawable6 instanceof LayerDrawable){
                    LayerDrawable layerDrawable1 = (LayerDrawable) drawable6;
                    Drawable background = layerDrawable1.getDrawable(0); // 获取第一个图层的Drawable
                    if(background instanceof GradientDrawable){
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        int backgroundColor = gradientDrawable.getColor().getDefaultColor();
                        GradientDrawable yuanjiao = new GradientDrawable();
                        yuanjiao.setShape(GradientDrawable.RECTANGLE);
// 设置圆角半径，单位为像素
                        int cornerRadius = 10;
                        yuanjiao.setCornerRadius(cornerRadius);
// 设置背景颜色
                        yuanjiao.setColor(backgroundColor);
// 将GradientDrawable对象设置为View的背景
                        viewSave6.setBackground(gradientDrawable);
                    }
                }
//                viewSave1.setBackgroundColor(((ColorDrawable)blockView1.getBackground()).getColor());
//                viewSave2.setBackgroundColor(((ColorDrawable)blockView2.getBackground()).getColor());
//                viewSave3.setBackgroundColor(((ColorDrawable)blockView3.getBackground()).getColor());
//                viewSave4.setBackgroundColor(((ColorDrawable)blockView4.getBackground()).getColor());
//                viewSave5.setBackgroundColor(((ColorDrawable)blockView5.getBackground()).getColor());
//                viewSave6.setBackgroundColor(((ColorDrawable)blockView6.getBackground()).getColor());

            }
        });
        AppCompatButton backButton =findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout liSave = findViewById(R.id.li_baocundseka);
                liSave.setVisibility(View.GONE);
            }
        });
        AppCompatButton saveButton2 =findViewById(R.id.baocunButton);
        saveButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout liSaveSeka=findViewById(R.id.li_baocunseka2);
                saveLinearLayoutAsJPG(liSaveSeka);

            }
        });


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "复制");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle().equals("复制")) {
            TextView textView = findViewById(item.getItemId());
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("text", textView.getText());
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(this, "已复制到剪贴板", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
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
        if (Build.VERSION.SDK_INT >= 24)
            //判断安卓的版本是否高于7.0，高于则调用高于的方法，低于则调用低于的方法
            //把文件转换成Uri对象
                /*之所以这样，是因为android7.0以后直接使用本地真实路径是不安全的，会抛出异常。
                FileProvider是一种特殊的内容提供器，可以对数据进行保护*/ {
            imageUri = FileProvider.getUriForFile(PhotoProcess2.this,
                    "com.example.myapplication.fileprovider", outputImage);
                /*第一个参数：context对象
                第二个参数：任意唯一的字符串
                第三个参数：文件对象*/
        } else {
            imageUri = Uri.fromFile(outputImage);
        }
        //使用隐示的Intent，系统会找到与它对应的活动，即调用摄像头，并把它存储
        Intent intent = new Intent("android.media.action.STILL_IMAGE_CAMERA");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
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


    private void setColorCard() {
        View[] view = new View[6];
        view[0] = findViewById(R.id.color_block1);
        view[1] = findViewById(R.id.color_block2);
        view[2] = findViewById(R.id.color_block3);
        view[3] = findViewById(R.id.color_block4);
        view[4] = findViewById(R.id.color_block5);
        view[5] = findViewById(R.id.color_block6);
        ImageView imageView = findViewById(R.id.picture);
        imageView.setBackgroundColor(Color.TRANSPARENT);

        List<Integer> dominantColors = ImageUtils.getDominantColors(((BitmapDrawable) picture.getDrawable()).getBitmap(), 6);
        for (int color : dominantColors) {
            int red = Color.red(color);
            int green = Color.green(color);
            int blue = Color.blue(color);
            // 使用 red、green 和 blue 变量来表示提取的颜色的 RGB 值
            System.out.println("rgb " + Color.rgb(red, green, blue));
            // 获取原始的背景颜色
            int backgroundColor = Color.rgb(red,green,blue);
            view[dominantColors.indexOf(color)].setBackgroundColor(backgroundColor);
// 创建一个 LayerDrawable 对象，用于添加边框和圆角
            Drawable[] layers = new Drawable[2];

// 创建一个圆角矩形形状
            GradientDrawable shape = new GradientDrawable();
            shape.setShape(GradientDrawable.RECTANGLE);
            shape.setCornerRadius(10); // 设置圆角半径
            shape.setColor(backgroundColor); // 设置背景颜色


            GradientDrawable stroke = new GradientDrawable();
            stroke.setShape(GradientDrawable.RECTANGLE);
            stroke.setCornerRadius(10); // 设置圆角半径
            stroke.setStroke(5, Color.WHITE); // 设置描边颜色和宽度

// 将圆角矩形形状和描边形状添加到 LayerDrawable 中
            layers[0] = shape;
            layers[1]=stroke;
            LayerDrawable layerDrawable = new LayerDrawable(layers);

// 将 LayerDrawable 设置为 View 的背景
            view[dominantColors.indexOf(color)].setBackground(layerDrawable);



//                                float[] hsv = new float[3];
//                                Color.colorToHSV(color, hsv);
//                                int rgbColor = Color.HSVToColor(hsv);
//                                view[dominantColors.indexOf(color)].setBackgroundColor(rgbColor);
        }
//                        }


        // 提取图片的主要颜色
//                        if (filePath != null) {
//                            List<Scalar> colors = extractDominantColors(filePath);
//                            System.out.println("colors size = " + colors.size());
//                            // 应用颜色到颜色视图
//                            View[] view = new View[6];
//                            view[0] = findViewById(R.id.color_block1);
//                            view[1] = findViewById(R.id.color_block2);
//                            view[2] = findViewById(R.id.color_block3);
//                            view[3] = findViewById(R.id.color_block4);
//                            view[4] = findViewById(R.id.color_block5);
//                            view[5] = findViewById(R.id.color_block6);
//
//                            for (int i = 0; i < 6; i++) {
//                                System.out.println("Scalar str " + colors.get(i));
//                                int blue = (int) Math.round(colors.get(i).val[0]);
//                                int green = (int) Math.round(colors.get(i).val[1]);
//                                int red = (int) Math.round(colors.get(i).val[2]);
////                                int color = (red << 16) | (green << 8) | blue;
////                                view[i].setBackgroundColor(color);
//
//                                view[i].setBackgroundColor(Color.rgb(red, green, blue));
//
//                            }
    }

    /**
     * 色块点击事件
     */
    private void setColorCardInfo(View view) {
        controlSeekbar = view;
        LinearLayout liSehao = findViewById(R.id.sehao);
        liSehao.setVisibility(View.VISIBLE);

        int backgroundColor = 0;

        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable) {
            System.out.println(1);
            ColorDrawable colorDrawable = (ColorDrawable) background;
            backgroundColor = colorDrawable.getColor();
        }
        else if(background instanceof GradientDrawable) {
            System.out.println(2);
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            backgroundColor = gradientDrawable.getColor().getDefaultColor();
            // 使用背景颜色进行操作
        }
        else if (background instanceof StateListDrawable) {
            System.out.println(3);
            StateListDrawable stateListDrawable = (StateListDrawable) background;
            Drawable currentDrawable = stateListDrawable.getCurrent();
            if (currentDrawable instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) currentDrawable;
                backgroundColor = colorDrawable.getColor();
                // 使用背景颜色进行操作
            }
        }
        else if (background instanceof BitmapDrawable) {
            System.out.println(4);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            backgroundColor = getDominantColor(bitmap);
            // 使用背景颜色进行操作
        }
        else if (background instanceof ShapeDrawable) {
            System.out.println(5);
            ShapeDrawable shapeDrawable = (ShapeDrawable) background;
            backgroundColor = shapeDrawable.getPaint().getColor();
            // 使用背景颜色进行操作
        }
        else if (background instanceof LayerDrawable) {
            System.out.println(8);
            LayerDrawable layerDrawable = (LayerDrawable) background;
            Drawable drawable = layerDrawable.getDrawable(0); // 获取第一个图层的Drawable
            if (drawable instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) drawable;
                backgroundColor = colorDrawable.getColor();
                // 使用背景颜色进行操作
            }
            else if (drawable instanceof LayerDrawable){
                System.out.println(1);
                LayerDrawable layerDrawable1 = (LayerDrawable) drawable;
                Drawable drawable1 = layerDrawable1.getDrawable(0); // 获取第一个图层的Drawable
                if (drawable1 instanceof ColorDrawable) {
                    ColorDrawable colorDrawable = (ColorDrawable) drawable1;
                    backgroundColor = colorDrawable.getColor();
                    System.out.println(11);
                    // 使用背景颜色进行操作
                }
                else if (drawable1 instanceof ShapeDrawable){
                    ShapeDrawable shapeDrawable = (ShapeDrawable) drawable1;
                    backgroundColor = shapeDrawable.getPaint().getColor();
                    System.out.println(12);
                }
                else if(drawable1 instanceof GradientDrawable){
                    GradientDrawable gradientDrawable = (GradientDrawable) drawable1;
                    backgroundColor = gradientDrawable.getColor().getDefaultColor();
                    System.out.println(13);//
                }

            }
            else if (drawable instanceof ShapeDrawable){
                System.out.println(2);
            }
            else if (drawable instanceof BitmapDrawable){
                System.out.println(3);
            }
            else if (drawable instanceof GradientDrawable){
                System.out.println(4);
                GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                backgroundColor = gradientDrawable.getColor().getDefaultColor();
            }
        }else if (background instanceof NinePatchDrawable) {
            System.out.println(6);
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) background;
            backgroundColor = ninePatchDrawable.getPaint().getColor();
            System.out.println(backgroundColor);
            // 使用背景颜色进行操作
        }else{
            System.out.println(7);
        }


        String hexColor = String.format("#%06X", (0xFFFFFF & backgroundColor));
        int red = Color.red(backgroundColor);
        int green = Color.green(backgroundColor);
        int blue = Color.blue(backgroundColor);
        TextView shiliu = findViewById(R.id.shiliujinzhigeshi);
        shiliu.setText(hexColor);
        TextView rgb = findViewById(R.id.rgbgeshi);
        rgb.setText("rgb(" + red + "," + green + "," + blue + ")");
        shiliu.setTextColor(Color.rgb(red, green, blue));
        rgb.setTextColor(Color.rgb(red, green, blue));
        seekBarR.setProgress(red);
        seekBarG.setProgress(green);
        seekBarB.setProgress(blue);
    }


    private int getDominantColor(Bitmap bitmap) {
        // 将Bitmap缩小到1x1像素，以获取主要颜色
        Bitmap smallBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);

        // 获取像素颜色值
        int pixel = smallBitmap.getPixel(0, 0);

        // 提取RGB颜色值
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue = Color.blue(pixel);

        // 合并RGB颜色值并返回
        return Color.rgb(red, green, blue);
    }

    /**
     * seekbar点击事件
     *
     * @param channel
     * @param progress
     */
    private void changeViewColor(String channel, int progress) {
        if (controlSeekbar == null) return;
        Drawable background = controlSeekbar.getBackground();
        String drawableType = background.getClass().getSimpleName();
        System.out.println("Drawable类型：" + drawableType);

        if (background instanceof LayerDrawable) {
            LayerDrawable colorDrawable = (LayerDrawable) background;
            Drawable drawable = colorDrawable.getDrawable(0);
            if(drawable instanceof GradientDrawable){
                GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                int color = gradientDrawable.getColor().getDefaultColor();
                int alpha = Color.alpha(color);
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);
                if ("r".equals(channel))
                    red = progress; // 修改为你想要的R通道的值
                if ("g".equals(channel))
                    green = progress;
                if ("b".equals(channel))
                    blue = progress;

                int modifiedColor = Color.argb(alpha, red, green, blue);
                ((GradientDrawable) drawable).setColor(modifiedColor);
                TextView rgb = findViewById(R.id.rgbgeshi);
                TextView shiliu = findViewById(R.id.shiliujinzhigeshi);
                rgb.setText("rgb(" + red + "," + green + "," + blue + ")");
                shiliu.setText(String.format("#%06X", (0xFFFFFF & modifiedColor)));
                shiliu.setTextColor(modifiedColor);
                rgb.setTextColor(modifiedColor);
            }
//            int color = colorDrawable.getColor().getDefaultColor();
//            // 在这里处理颜色值
//            int alpha = Color.alpha(color);
//            int red = Color.red(color);
//            int green = Color.green(color);
//            int blue = Color.blue(color);
//            if ("r".equals(channel))
//                red = progress; // 修改为你想要的R通道的值
//            if ("g".equals(channel))
//                green = progress;
//            if ("b".equals(channel))
//                blue = progress;
//
//            int modifiedColor = Color.argb(alpha, red, green, blue);
//            ((GradientDrawable) background).setColor(modifiedColor);
//            TextView rgb = findViewById(R.id.rgbgeshi);
//            TextView shiliu = findViewById(R.id.shiliujinzhigeshi);
//            rgb.setText("rgb(" + red + "," + green + "," + blue + ")");
//            shiliu.setText(String.format("#%06X", (0xFFFFFF & modifiedColor)));
//            shiliu.setTextColor(modifiedColor);
//            rgb.setTextColor(modifiedColor);
        }
    }

    private void saveLinearLayoutAsJPG(LinearLayout linearLayout) {
        // 创建一个与 LinearLayout 相同大小的 Bitmap
        Bitmap bitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Bitmap.Config.ARGB_8888);
        // 创建一个 Canvas 对象，并将其绘制到 Bitmap 上
        Canvas canvas = new Canvas(bitmap);
        linearLayout.draw(canvas);
        // 保存 Bitmap 为 JPG 图片
        String fileName = "linear_layout_" + System.currentTimeMillis() + ".jpg";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            if (file.exists()) {
                // 将图片添加到媒体库
                MediaScannerConnection.scanFile(this, new String[] { file.getAbsolutePath() }, null, null);
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}