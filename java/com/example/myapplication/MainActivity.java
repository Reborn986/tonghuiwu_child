package com.example.myapplication;
import static com.app.hubert.guide.util.ScreenUtils.getScreenHeight;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.lang.reflect.Field;
import java.util.Random;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.google.gson.Gson;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.Request;
import okhttp3.Response;

// 新添加
import android.content.SharedPreferences;
import android.content.Context;
import android.graphics.Color;

import android.view.ViewGroup;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.NewbieGuide;

import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import android.util.Log;
import androidx.cardview.widget.CardView;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;


//该页面是登陆后跳转的主页面
//button_micro2和button_micro也就是右上角那个悬浮按钮和右下角的话筒的点击事件，写过了但代码找不到了，你们可以先试试用该文件里现有的函数把它补上
public class MainActivity extends AppCompatActivity {
    /*&&&&&&&&&&&&&&&&&&&&&&&&&&以下是语音识别&&&&&&&&&&&&&&&&&&*/
    private Intent mIntent;
    private int microFlag = 0;

    public String result = "";
    public static EditText txtdisplay;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.INTERNET,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_NETWORK_STATE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA
    };


    public static class AudioUtils {
        private static AudioUtils audioUtils;
        private SpeechSynthesizer mySynthesizer;
        public AudioUtils(){

        }

        public static AudioUtils getInstance() {
            if (audioUtils == null) {
                synchronized (AudioUtils.class) {
                    if (audioUtils == null) {
                        audioUtils = new AudioUtils();
                    }
                }
            }
            return audioUtils;
        }

        private InitListener myInitListener = new InitListener() { @Override public void onInit(int code) {  } };

        public void init(Context context) {
            mySynthesizer = SpeechSynthesizer.createSynthesizer(context, myInitListener);
            mySynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
            //发音人xiaoyan
            mySynthesizer.setParameter(SpeechConstant.SPEED,"50");
            //语速50
            mySynthesizer.setParameter(SpeechConstant.PITCH, "50");
            //语调50
            mySynthesizer.setParameter(SpeechConstant.VOLUME, "100");
            //音量100
        }

        public void speakText(String content){
            int code =mySynthesizer.startSpeaking(content,new SynthesizerListener(){
                @Override
                public void onSpeakBegin() {
                }

                @Override
                public void onBufferProgress(int i, int i1, int i2, String s) {
                }

                @Override
                public void onSpeakPaused() {
                }

                @Override
                public void onSpeakResumed() {
                }

                @Override
                public void onSpeakProgress(int i, int i1, int i2) {
                }

                @Override
                public void onCompleted(SpeechError speechError) {
                }

                @Override
                public void onEvent(int i, int i1, int i2, Bundle bundle) {
                }
            });
        }
    }
    /*&&&&&&&&&&&&&&&&&&以上是语音识别&&&&&&&&&&&&&&&&&&&&&&&*/


    static int switchTheme =1;//这里的主页面有两个主题（粉黄/蓝黄），默认为1粉色

    /*&&&&&&&&&&&&&&&&&&以下为主页展示滚动色卡的RecyclerView创建必要的内容&&&&&&&&&&&&&&&&&&*/
    public class Color{
        private int imageId;
        public Color(int ImageId) {
            this.imageId = ImageId;
        }
        public int getImageId() {
            return imageId;
        }

    }//创建了一个color类为后面创建色卡用，这里复用了Seka activity的ColorAdapter适配器，所以直接起名color了
    private Color[] colors = {
            new Color(R.drawable.seka5),
            new Color(R.drawable.seka6),
            new Color(R.drawable.seka7),
            new Color(R.drawable.seka3)
    };//把四个要展示的色卡加进去，这里是固定色卡，最好你们可以写成从后端获取作品进行展示
    private List<Color> colorList = new ArrayList<>();
    private ColorAdapter adapter;
    private void initColors() {
        colorList.clear();
        for (int i = 0; i < 4; i++) {
            colorList.add(colors[i]);
        }
    }//这些都是为RecyclerView创建的
    /*&&&&&&&&&&&&&&&&&&以上为主页展示滚动色卡的RecyclerView创建必要的内容&&&&&&&&&&&&&&&&&&*/

    private View[] guideViews;
    private String[] guideTexts;
    private Controller guideController;
    private int currentGuideIndex = 0;
    private MediaPlayer mediaPlayerGuide; // 声明 MediaPlayer 变量


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntent = getIntent();
        //和后端的硬件传输相关的
       //新手导引！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！111

        /*&&&&&&&&&&&&&&&&&&以下为页面组件元素的处理、动画&&&&&&&&&&&&&&&&&&*/
        //"你好！"后面姓名的修改，获取Login页面中获取到的currentUser信息中的name，并填入
        TextView username = findViewById(R.id.text_username);
        String str_user = "你好！ "+ Login.currentUser.name;
        username.setText(str_user);
        //出场动画，即上下背景的渐入和滑动
        FrameLayout frameLayout1 = findViewById(R.id.frame1);
        frameLayout1.setAlpha(0f);
        FrameLayout frameLayout2 = findViewById(R.id.frame2);
        frameLayout2.setAlpha(0f);
        FrameLayout frameLayout3 = findViewById(R.id.frame3);
        frameLayout3.setAlpha(0f);
        // 创建一个属性动画对象，设置动画的属性为 "translationY"，即垂直方向的平移
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(frameLayout2, "alpha", 0f, 1f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(frameLayout1, "translationY", -800f, 0f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(frameLayout1, "alpha", 0f, 1f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(frameLayout3, "translationY", 800f, 0f);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(frameLayout3, "alpha", 0f, 1f);
        // 设置动画的持续时间
        animator1.setDuration(1000);
        animator2.setDuration(1000);
        animator3.setDuration(1000);
        animator4.setDuration(1000);
        animator5.setDuration(1000);
        // 启动动画
        animator2.start();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator1, animator3, animator4, animator5);
        animatorSet.start();

        // 设置导航栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int defaultStatusBarColor = getWindow().getStatusBarColor();
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(android.graphics.Color.WHITE);
        }

        //设置色卡展示recyclerView
        initColors();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ColorAdapter(colorList);
        recyclerView.setAdapter(adapter);
        /*&&&&&&&&&&&&&&&&&&以上为页面组件元素的处理、动画&&&&&&&&&&&&&&&&&&*/


        /*&&&&&&&&&&&&&&&&&&&&&&&&&&语音识别权限相关&&&&&&&&&&&&&&&&&&&&&&&&*/
        applypermission();//申请app所需要用到的权限
        // 将"xxxxxx"替换成您申请的APPID，申请地址：http://www.xfyun.cn
        // 请勿在"="与appid之间添加任何空字符或者转义符
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=b8e19d69");
        /*&&&&&&&&&&&&&&&&&&&&&&&&&&语音识别权限相关&&&&&&&&&&&&&&&&&&&&&&&&*/

        // 添加右上角按钮的点击事件，这里消失的button_micro2
        ImageButton buttonMicro2 = findViewById(R.id.button_micro2);
        buttonMicro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用语音识别功能
                new use().initSpeech(MainActivity.this);
            }
        });

        /*&&&&&&&&&&&&&&&&&&&&&&&&&&以下为中央大按钮和九宫格按钮点击事件&&&&&&&&&&&&&&&&&&&&&&&&*/
        //进入我的色卡中央大按钮
        Button love = findViewById(R.id.love_color_card);
        love.setOnClickListener(view -> {
            Intent intent =new Intent();
            intent.setClass(MainActivity.this,myLoveCard.class);
            startActivity(intent);
        });

        //进入系统色卡中央大按钮
        Button button_seka = findViewById(R.id.my_color_card);
        button_seka.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SekaYellow.class);
            startActivity(intent);
        });

        //（1，1）填色游戏跳转
        ImageButton button_tianse =  findViewById(R.id.tianse_button);
        button_tianse.setOnClickListener(v -> {
            SharedPreferences preferences = getSharedPreferences("ColorPrefs", Context.MODE_PRIVATE);
            StringBuilder colorParams = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int color = preferences.getInt("color_" + i, android.graphics.Color.BLACK);
                // 使用URL编码格式，#号在URL中需要编码为%23
                colorParams.append("%23").append(String.format("%06X", (0xFFFFFF & color)));
                if (i < 5) colorParams.append(",");
            }
            // 使用新的URL地址
            String baseUrl = "http://182.92.241.159/tianse_game/填色画游戏/draw.html";
            // 正确格式: ?colors=%23FF0000,%2300FF00,%2300FFFF,%23FFFF00,%23FF00FF
            String url = colorParams.length() > 0 ? baseUrl + "?colors=" + colorParams.toString() : baseUrl;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        //（1，2）拼图游戏跳转
        ImageButton button_pintu = findViewById(R.id.pingtu_button);
        button_pintu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://182.92.241.159/pintu_game/pintu.html"; // 修改为服务器地址
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //（1，3）AI交流跳转
        ImageButton button_mirco =  findViewById(R.id.micro_button);
        button_mirco.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, LLMActivity.class);
            startActivity(intent);
        });

        //改：将opendrawer_image和information进行关联
        ImageView new_gerenxinxi=findViewById(R.id.opendrawer_image);
        new_gerenxinxi.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, PersonInformation.class);
            startActivity(intent);
        });

        //（2，1）ai绘画跳转
        ImageButton button_AI =  findViewById(R.id.AIhuihua_button);
        button_AI.setOnClickListener(v -> {
            if(switchTheme==1){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AIpainting2.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AIpainting.class);
                startActivity(intent);
            }
        });

        //（2，2）拍照取色跳转
        ImageButton paizhao1 = findViewById(R.id.paizhao_button);

        paizhao1.setOnClickListener(v -> {
            Intent intent = new Intent();
            if(switchTheme==1) {
                intent.setClass(MainActivity.this, PhotoProcess.class);
            }
            else if(switchTheme==0){
                intent.setClass(MainActivity.this, PhotoProcess2.class);
            }
            startActivity(intent);
        });

        //（2，3）音乐感色跳转
        ImageButton yinyueganse =findViewById(R.id.yinyueganse_button);
        yinyueganse.setOnClickListener(new View.OnClickListener() {//这里有问题
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MusicColor.class);//改成跳转到音乐感色
                startActivity(intent);
            }

        });

        //（3，1）配色知识跳转
        ImageButton zhishi=findViewById(R.id.zhishi_button);
        zhishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(switchTheme==1) {
                    intent.setClass(MainActivity.this, KnowledgeActivity.class);
                }else if(switchTheme==0){
                    intent.setClass(MainActivity.this, KnowledgeActivity2.class);
                }
                startActivity(intent);
            }
        });

        //（3，2）社区交流跳转
        ImageButton shequ=findViewById(R.id.shequ_button);
        shequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(switchTheme==1) {
                    intent.setClass(MainActivity.this, society.class);
                }else if(switchTheme==0){
                    intent.setClass(MainActivity.this, Society2.class);
                }
                startActivity(intent);
            }
        });

        //（3，3）主题切换按钮
        ImageButton zhutiqiehuan= findViewById(R.id.zhuti_button);
        zhutiqiehuan.setOnClickListener(v -> {
            if(switchTheme ==1) {
                //如果为1则为粉色，按主题切换后变为0则是蓝色
                switchTheme=0;
                //出场动画
                FrameLayout frameLayout11 = findViewById(R.id.frame1);
                frameLayout11.setAlpha(0f);
                FrameLayout frameLayout21 = findViewById(R.id.frame2);
                frameLayout21.setAlpha(0f);
                FrameLayout frameLayout31 = findViewById(R.id.frame3);
                frameLayout31.setAlpha(0f);
                swichTheme1to0();
                ObjectAnimator animator21 = ObjectAnimator.ofFloat(frameLayout21, "alpha", 0f, 1f);
                ObjectAnimator animator11 = ObjectAnimator.ofFloat(frameLayout11, "translationY", -800f, 0f);
                ObjectAnimator animator31 = ObjectAnimator.ofFloat(frameLayout11, "alpha", 0f, 1f);
                ObjectAnimator animator41 = ObjectAnimator.ofFloat(frameLayout31, "translationY", 800f, 0f);
                ObjectAnimator animator51 = ObjectAnimator.ofFloat(frameLayout31, "alpha", 0f, 1f);
                animator11.setDuration(1000);
                animator21.setDuration(1000);
                animator31.setDuration(1000);
                animator41.setDuration(1000);
                animator51.setDuration(1000);
                animator21.start();
                AnimatorSet animatorSet1 = new AnimatorSet();
                animatorSet1.playTogether(animator11, animator31, animator41, animator51);
                animatorSet1.start();
            }
            else {//同理
                switchTheme=1;
                //出场动画
                FrameLayout frameLayout11 = findViewById(R.id.frame1);
                frameLayout11.setAlpha(0f);
                FrameLayout frameLayout21 = findViewById(R.id.frame2);
                frameLayout21.setAlpha(0f);
                FrameLayout frameLayout31 = findViewById(R.id.frame3);
                frameLayout31.setAlpha(0f);
                swichTheme0to1();
                ObjectAnimator animator21 = ObjectAnimator.ofFloat(frameLayout21, "alpha", 0f, 1f);
                ObjectAnimator animator11 = ObjectAnimator.ofFloat(frameLayout11, "translationY", -800f, 0f);
                ObjectAnimator animator31 = ObjectAnimator.ofFloat(frameLayout11, "alpha", 0f, 1f);
                ObjectAnimator animator41 = ObjectAnimator.ofFloat(frameLayout31, "translationY", 800f, 0f);
                ObjectAnimator animator51 = ObjectAnimator.ofFloat(frameLayout31, "alpha", 0f, 1f);
                animator11.setDuration(1000);
                animator21.setDuration(1000);
                animator31.setDuration(1000);
                animator41.setDuration(1000);
                animator51.setDuration(1000);
                animator21.start();
                AnimatorSet animatorSet1 = new AnimatorSet();
                animatorSet1.playTogether(animator11, animator31, animator41, animator51);
                animatorSet1.start();
            }
        });


        // 新手导引
        guideViews = new View[]{
                findViewById(R.id.tianse_button),    // (1,1)
                findViewById(R.id.pingtu_button),    // (1,2)
                findViewById(R.id.micro_button),     // (1,3)
                findViewById(R.id.AIhuihua_button),  // (2,1)
                findViewById(R.id.paizhao_button),   // (2,2)
                findViewById(R.id.yinyueganse_button),// (2,3)
                findViewById(R.id.zhishi_button),    // (3,1)
                findViewById(R.id.shequ_button),     // (3,2)
                findViewById(R.id.zhuti_button)      // (3,3)
        };

        guideTexts = new String[]{
                "在这里，你可以用色卡提取的颜色在空白图案上发挥想象力！",
                "试试这个拼图游戏，通过颜色匹配完成艺术拼图吧！",
                "点击这里可以和AI进行颜色相关的交流讨论哦~",
                "让AI根据你的描述生成专属颜色画作！",
                "拍照取色功能，发现生活中的颜色之美！",
                "这里可以查看和修改你的个人信息",
                "学习颜色搭配知识和色彩原理",
                "在社区分享你的色彩创作和灵感",
                "点击这里可以切换浅色/深色主题模式"
        };

        // 重置所有引导状态
        for (int i = 0; i < guideTexts.length; i++) {
            NewbieGuide.resetLabel(this, "main_guide_page_" + i);
        }

        // 开始引导流程
        currentGuideIndex = 0;
        showNextGuidePage();



        /*&&&&&&&&&&&&&&&&&&&&&&&&&&以上为中央大按钮和九宫格按钮点击事件&&&&&&&&&&&&&&&&&&&&&&&&*/
        //调用新手导引的函数

        /*&&&&&&&&&&&&&&&&&&&&&&&&&&以下为右上角悬浮话筒、右下角话筒点击事件&&&&&&&&&&&&&&&&&&&&&&&&*/
        // 删除重复的代码
        /*&&&&&&&&&&&&&&&&&&&&&&&&&&以上为右上角悬浮话筒、右下角话筒点击事件&&&&&&&&&&&&&&&&&&&&&&&&*/
    }


    private void showNextGuidePage() {
        if (currentGuideIndex >= guideTexts.length) return;

        NewbieGuide.with(this)
                .setLabel("main_guide_page_" + currentGuideIndex) // 使用唯一标签
                .alwaysShow(true)
                .addGuidePage(createGuidePage(
                        currentGuideIndex,
                        currentGuideIndex < 3 ? 200 : currentGuideIndex < 6 ? 290 : 380, // 垂直位置
                        (currentGuideIndex % 3) * 120 // 水平偏移
                ))
                .setOnGuideChangedListener(new OnGuideChangedListener() {
                    @Override
                    public void onShowed(Controller controller) {
                        guideController = controller;
                        Log.d("Guide", "Showing page: " + currentGuideIndex);
                        // 自动播放对应音频
                        playGuideAudio(currentGuideIndex);
                    }

                    @Override
                    public void onRemoved(Controller controller) {
                        Log.d("Guide", "Page removed: " + currentGuideIndex);
                        // 停止当前正在播放的音频
                        if (mediaPlayerGuide != null) {
                            mediaPlayerGuide.stop();
                            mediaPlayerGuide.release();
                            mediaPlayerGuide = null;
                        }
                        currentGuideIndex++;
                        showNextGuidePage(); // 递归调用显示下一页
                    }
                })
                .show();
    }

    // 播放引导音频
    private void playGuideAudio(int index) {
        // 停止并释放当前的 MediaPlayer（如果存在）
        if (mediaPlayerGuide != null) {
            mediaPlayerGuide.stop();
            mediaPlayerGuide.release();
            mediaPlayerGuide = null; // 释放后将 mediaPlayer 设置为 null
        }

        int audioResId = getGuideAudioResourceId(index);
        if (audioResId != 0) {
            mediaPlayerGuide = MediaPlayer.create(this, audioResId);
            mediaPlayerGuide.setOnCompletionListener(mp -> {
                mp.release();
                mediaPlayerGuide = null; // 释放后将 mediaPlayer 设置为 null
            });
            mediaPlayerGuide.start();
        }
    }

    // 获取引导音频资源ID
    private int getGuideAudioResourceId(int index) {
        String[] audioResources = {
                "guide_1_1", "guide_1_2", "guide_1_3",
                "guide_2_1", "guide_2_2", "guide_2_3",
                "guide_3_1", "guide_3_2", "guide_3_3"
        };

        if (index >= 0 && index < audioResources.length) {
            return getResources().getIdentifier(audioResources[index], "raw", getPackageName());
        }
        return 0;
    }

    private int calculateArrowStartMargin(int index) {
        return 50 + (index % 3) * 110;
    }

    private GuidePage createGuidePage(int index, int verticalMargin, int arrowOffset) {
        return GuidePage.newInstance()
                .addHighLight(guideViews[index], HighLight.Shape.RECTANGLE)
                .setEverywhereCancelable(false)
                .setLayoutRes(R.layout.view_guide)
                .setOnLayoutInflatedListener((view, controller) -> {
                    // 禁用整个弹窗的声音效果
                    view.setSoundEffectsEnabled(false);

                    // 遍历所有子视图并禁用声音效果
                    disableSoundEffectsForViewGroup(view);

                    CardView card = view.findViewById(R.id.cv_layout);
                    ViewGroup.MarginLayoutParams cardParams = (ViewGroup.MarginLayoutParams) card.getLayoutParams();
                    cardParams.topMargin = dpToPx(verticalMargin);

                    ImageView arrow = view.findViewById(R.id.iv_dialog_arrow);
                    ViewGroup.MarginLayoutParams arrowParams = (ViewGroup.MarginLayoutParams) arrow.getLayoutParams();
                    arrowParams.setMarginStart(dpToPx(calculateArrowStartMargin(index))); // 水平位置

                    TextView text = view.findViewById(R.id.tv_dialog_title);
                    text.setText(guideTexts[index]);

                    // 设置播放按钮点击事件
                    ImageButton playButton = view.findViewById(R.id.iv_play_audio);
                    playButton.setSoundEffectsEnabled(false);
                    playButton.setOnClickListener(v -> playGuideAudio(index));

                    ImageButton closeButton = view.findViewById(R.id.iv_dialog_dismiss);
                    closeButton.setSoundEffectsEnabled(false);
                    closeButton.setOnClickListener(v -> {
                        controller.remove(); // 这会触发onRemoved回调
                    });
                });
    }

    // 递归禁用视图组中所有子视图的声音效果
    private void disableSoundEffectsForViewGroup(View view) {
        view.setSoundEffectsEnabled(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                disableSoundEffectsForViewGroup(viewGroup.getChildAt(i));
            }
        }
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    // 在MainActivity类中修正
    private void setupCloseButton(Controller controller) {
        try {
            // 修改为使用反射获取布局
            Field field = controller.getClass().getDeclaredField("currentLayout");
            field.setAccessible(true);
            ViewGroup rootView = (ViewGroup) field.get(controller);

            ImageButton closeButton = rootView.findViewById(R.id.iv_dialog_dismiss);
            closeButton.setOnClickListener(v -> controller.remove());
        } catch (Exception e) {
            Log.e("Guide", "Error setting up close button", e);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_icon:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void swichTheme1to0() {
        //最上面一层占位view
        View view1 = findViewById(R.id.background_view);
        view1.setBackgroundColor(android.graphics.Color.parseColor("#A7B4CE"));
        //顶边栏花纹变色
        ImageView imageView1 = findViewById(R.id.background_imageview1);
        imageView1.setImageResource(R.drawable.background1);
        //右上角拍照按钮变色
        ImageButton imageButton1 = findViewById(R.id.button_micro2);
        imageButton1.setImageResource(R.drawable.main_ic_cambutton2);
        //背景颜色切换
        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        linearLayout.setBackground(getResources().getDrawable(R.drawable.main_bg_all2));
        //底边栏花纹变色
        ImageView tableLayout = findViewById(R.id.bottom_im);
        tableLayout.setImageResource(R.drawable.main_im_bottom2);
        //底部话筒变色
        ImageButton button_micro = findViewById(R.id.button_micro);
        button_micro.setImageResource(R.drawable.ic_mic2);
        //按钮组变色
        List<ImageButton> buttonList1 = new ArrayList<>();
        buttonList1.add(findViewById(R.id.tianse_button));
        buttonList1.add(findViewById(R.id.micro_button));
        buttonList1.add(findViewById(R.id.paizhao_button));
        buttonList1.add(findViewById(R.id.zhishi_button));
        buttonList1.add(findViewById(R.id.zhuti_button));
        for (ImageButton button : buttonList1) {
            button.setBackground(getResources().getDrawable(R.drawable.main_bg_button3));
        }
        //按钮组改变图片
        List<ImageButton> buttonList2 = new ArrayList<>();
        buttonList2.add(findViewById(R.id.pingtu_button));
        buttonList2.add(findViewById(R.id.AIhuihua_button));
        buttonList2.add(findViewById(R.id.yinyueganse_button));

        buttonList2.add(findViewById(R.id.shequ_button));
        for (ImageButton button : buttonList2) {
            button.setBackground(getResources().getDrawable(R.drawable.main_bg_button4));
        }

        buttonList1.get(0).setImageResource(R.drawable.main_im_tianse2);
        buttonList1.get(1).setImageResource(R.drawable.main_ic_yuyin2);
        buttonList1.get(2).setImageResource(R.drawable.main_im_paizhao2);
        buttonList1.get(3).setImageResource(R.drawable.main_im_zhishi2);
        buttonList1.get(4).setImageResource(R.drawable.main_im_zhuti2);

        buttonList2.get(0).setImageResource(R.drawable.main_im_pingtu2);
        buttonList2.get(1).setImageResource(R.drawable.main_im_ai2);
        buttonList2.get(2).setImageResource(R.drawable.main_yinyueganse2);
        buttonList2.get(3).setImageResource(R.drawable.main_im_shequ2);
        //中间大按钮字体变色
        AppCompatButton appCompatButton = findViewById(R.id.my_color_card);
        appCompatButton.setTextColor(android.graphics.Color.parseColor("#677695"));
    }


    private void swichTheme0to1() {
        //最上面一层占位view
        View view1 = findViewById(R.id.background_view);
        view1.setBackgroundColor(android.graphics.Color.parseColor("#FFDEDE"));
        //顶边栏花纹变色
        ImageView imageView1 = findViewById(R.id.background_imageview1);
        imageView1.setImageResource(R.drawable.title_im_title);
        //右上角拍照按钮变色
        ImageButton imageButton1 = findViewById(R.id.button_micro2);
        imageButton1.setImageResource(R.drawable.main_ic_cambutton);
        //背景颜色切换
        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        linearLayout.setBackground(getResources().getDrawable(R.drawable.main_bg_all));
        //底边栏花纹变色
        ImageView tableLayout = findViewById(R.id.bottom_im);
        tableLayout.setImageResource(R.drawable.main_im_bottom);
        //底部话筒变色
        ImageButton button_micro = findViewById(R.id.button_micro);
        button_micro.setImageResource(R.drawable.ic_mic);
        //按钮组变色

        List<ImageButton> buttonList1 = new ArrayList<>();
        buttonList1.add(findViewById(R.id.tianse_button));
        buttonList1.add(findViewById(R.id.micro_button));
        buttonList1.add(findViewById(R.id.paizhao_button));
        buttonList1.add(findViewById(R.id.zhishi_button));
        buttonList1.add(findViewById(R.id.zhuti_button));
        for (ImageButton button : buttonList1) {
            button.setBackground(getResources().getDrawable(R.drawable.main_bg_button));
        }
        //按钮组改变图片
        List<ImageButton> buttonList2 = new ArrayList<>();
        buttonList2.add(findViewById(R.id.pingtu_button));
        buttonList2.add(findViewById(R.id.AIhuihua_button));
        buttonList2.add(findViewById(R.id.yinyueganse_button));
        buttonList2.add(findViewById(R.id.shequ_button));
        for (ImageButton button : buttonList2) {
            button.setBackground(getResources().getDrawable(R.drawable.main_bg_button2));
        }

        buttonList1.get(0).setImageResource(R.drawable.main_im_tianse);
        buttonList1.get(1).setImageResource(R.drawable.main_ic_yuyin);
        buttonList1.get(2).setImageResource(R.drawable.main_im_paizhao);
        buttonList1.get(3).setImageResource(R.drawable.main_im_zhishi);
        buttonList1.get(4).setImageResource(R.drawable.main_im_zhuti);

        buttonList2.get(0).setImageResource(R.drawable.main_im_pingtu);
        buttonList2.get(1).setImageResource(R.drawable.main_im_ai);
        buttonList2.get(2).setImageResource(R.drawable.main_yinyueganse);
        buttonList2.get(3).setImageResource(R.drawable.main_im_shequ);
        //中间大按钮字体变色
        AppCompatButton appCompatButton = findViewById(R.id.my_color_card);
        appCompatButton.setTextColor(android.graphics.Color.parseColor("#B57777"));
    }

    //后端传感器相关
    private void updateUI(int r, int g, int b) {
        View colorBlock = findViewById(R.id.color_block1);  // 获取 View 控件
        int color = android.graphics.Color.rgb(r, g, b);  // 转换 RGB 数据为颜色
        colorBlock.setBackgroundColor(color);  // 设置背景颜色
    }


    //定义判断权限申请的函数，在onCreat中调用就行
    public void applypermission(){
        if(Build.VERSION.SDK_INT>=23){
            boolean needapply=false;
            for(int i=0;i<PERMISSIONS_STORAGE.length;i++){
                int chechpermission= ContextCompat.checkSelfPermission(getApplicationContext(),
                        PERMISSIONS_STORAGE[i]);
                if(chechpermission!= PackageManager.PERMISSION_GRANTED){
                    needapply=true;
                }
            }
            if(needapply){
                ActivityCompat.requestPermissions(MainActivity.this,PERMISSIONS_STORAGE,1);
            }
        }
    }
    //重载用户是否同意权限的回调函数，进行相应处理
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int i=0;i<grantResults.length;i++){      //检查权限是否获取
            if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
                //同意后的操作
                Toast.makeText(MainActivity.this, permissions[i]+"已授权",Toast.LENGTH_SHORT).show();//提示
            }
            else {
                //不同意后的操作
                Toast.makeText(MainActivity.this,permissions[i]+"拒绝授权",Toast.LENGTH_SHORT).show();//提示

            }
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 保存新的Intent
        mIntent = intent;
    }
    @Override
    protected void onResume() {
        super.onResume();
        // 检查是否从PersonInformation返回
        boolean fromPersonInformation = mIntent.getBooleanExtra("fromPersonInformation", false);
        if (fromPersonInformation) {
            // 如果是从PersonInformation返回，修改TextView
            TextView username = (TextView) findViewById(R.id.text_username);
            String str_user = "你好！ "+ Login.currentUser.name;
            username.setText(str_user);
        }
    }

    public class use{
        /**
         *@TODO 科大讯飞语音听写
         * linowl 2020.09.11
         */

        //这里修改了
        public void initSpeech(final Context context) {
            // 检查录音权限
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) 
                != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, "请授予录音权限", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                //1.创建RecognizerDialog对象
                RecognizerDialog mDialog = new RecognizerDialog(context, null);
                //识别器定义
                txtdisplay = (EditText) findViewById(R.id.edit_micro);
                if (txtdisplay == null) {
                    Toast.makeText(context, "初始化失败，请检查布局文件", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                microFlag = 1;
                //2.设置accent、language等参数
                mDialog.setParameter(SpeechConstant.DOMAIN,"iat");
                mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
                mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
                
                //3.设置回调接口
                mDialog.setListener(new RecognizerDialogListener() {
                    @Override
                    public void onResult(RecognizerResult recognizerResult, boolean isLast) {
                        if (!isLast) {
                            result = parseVoice(recognizerResult.getResultString());
                            txtdisplay.setText(result);
                            txtdisplay.setTextColor(android.graphics.Color.parseColor("#FF855555"));
                            microTransfer(result);
                        }
                    }

                    @Override
                    public void onError(SpeechError speechError) {
                        Toast.makeText(context, "识别错误：" + speechError.getErrorCode(), 
                            Toast.LENGTH_SHORT).show();
                    }
                });
                
                //4.显示dialog
                mDialog.show();
            } catch (Exception e) {
                Toast.makeText(context, "语音识别初始化失败：" + e.getMessage(), 
                    Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    /**
     * 解析语音json
     */
    public String parseVoice(String resultString) {
        Gson gson = new Gson();
        Voice voiceBean = gson.fromJson(resultString, Voice.class);

        StringBuffer sb = new StringBuffer();
        ArrayList<Voice.WSBean> ws = voiceBean.ws;
        for (Voice.WSBean wsBean : ws) {
            String word = wsBean.cw.get(0).w;
            sb.append(word);
        }
        return sb.toString();
    }
    /**
     * 语音实体类
     */
    public class Voice {

        public ArrayList<WSBean> ws;

        public class WSBean {
            public ArrayList<CWBean> cw;
        }

        public class CWBean {
            public String w;
        }
    }

    //调用use类的initSpeech函数
    public void Recognition(View view){
        new use().initSpeech(this);
    }

    public void broadcast(View view){
        final EditText editext = (EditText) findViewById(R.id.edit_micro);
        AudioUtils.getInstance().init(this); //初始化语音对象
        AudioUtils.getInstance().speakText(editext.getText().toString()); //播放语音
    }


    public static String removeNum(String pinyin) {
            // 去除字符串中的数字
            String pinyinReslut = pinyin.replaceAll("\\d", "");

            return pinyinReslut;
        }


    public void microTransfer(String microText){

        if(microText.contains("打开")){

            String microTextPinyin = getPinyin(microText);
            microTextPinyin = removeNum(microTextPinyin);

            if(microTextPinyin.contains("paizhao")||microTextPinyin.contains("quse")){
                Intent intent = new Intent();
                if(switchTheme == 1)
                    intent.setClass(MainActivity.this, PhotoProcess.class);
                else
                    intent.setClass(MainActivity.this, PhotoProcess2.class);
                startActivity(intent);
            }
            else if(microTextPinyin.contains("seka")||microTextPinyin.contains("yanse")){
                Intent intent = new Intent();
                if(switchTheme == 1)
                    intent.setClass(MainActivity.this, SekaRed.class);
                else
                    intent.setClass(MainActivity.this, SekaBlue.class);
                startActivity(intent);
            }
            else if(microTextPinyin.contains("zhishi")){
                Intent intent = new Intent();
                if(switchTheme == 1)
                    intent.setClass(MainActivity.this, KnowledgeActivity.class);
                else
                    intent.setClass(MainActivity.this, KnowledgeActivity2.class);
                startActivity(intent);
            }
            else if(microTextPinyin.contains("huihua")){
                Intent intent = new Intent();
                if(switchTheme == 1)
                    intent.setClass(MainActivity.this, AIpainting2.class);
                else
                    intent.setClass(MainActivity.this, AIpainting.class);
                startActivity(intent);
            }
            else if(microTextPinyin.contains("yuyin")||microTextPinyin.contains("jiaoliu")){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LLMActivity.class);
                startActivity(intent);
            }
            else if(microTextPinyin.contains("pintu")){
                String url = "http://182.92.241.159/pintu_game/pintu.html"; // 修改为服务器地址
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
            else if(microTextPinyin.contains("tianse")||microTextPinyin.contains("tuse")){
                String url = "http://182.92.241.159/tianse_game/填色画游戏/draw.html"; // 修改为服务器地址
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
            else if(microTextPinyin.contains("youxi")){
                Random random = new Random();
                // 生成随机数，要么是0，要么是1
                int randomNumber = random.nextInt(2);
                if(randomNumber == 0) {
                    String url = "http://182.92.241.159/tianse_game/填色画游戏/draw.html"; // 修改为服务器地址
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);

                }
                else{
                    String url = "http://182.92.241.159/pintu_game/拼图小游戏/index.html"; // 修改为服务器地址
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            }
            else if(microTextPinyin.contains("xinxi")||microTextPinyin.contains("wo")||microTextPinyin.contains("geren")){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PersonInformation.class);
                startActivity(intent);
            }
            else if(microTextPinyin.contains("shequ")||microTextPinyin.contains("fenxiang")){
                Intent intent = new Intent();
                if(switchTheme == 1)
                    intent.setClass(MainActivity.this, society.class);
                else
                    intent.setClass(MainActivity.this, Society2.class);
                startActivity(intent);
            }

        }else{
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,LLMActivity.class);
            startActivity(intent);
        }
    }
    // 将汉字转换为拼音
    public static String getPinyin(String input) {
        StringBuilder pinyin = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
            if (pinyinArray != null && pinyinArray.length > 0) {
                pinyin.append(pinyinArray[0]); // 取第一个拼音
            } else {
                pinyin.append(c); // 如果没有找到对应的拼音，则直接将字符添加到结果中
            }
        }
        return pinyin.toString();
    }
    //进行颜色和音乐捆绑的功能，还没写
    // MainActivity.java
    private MediaPlayer mediaPlayer;
        private void setupColorBlocks() {
            // 红色块 -> 播放音乐_red
            findViewById(R.id.btn_red).setOnClickListener(v -> playMusic(R.raw.red));
            //橙色
            findViewById(R.id.btn_orange).setOnClickListener(v -> playMusic(R.raw.orange));
            // 黄色块 -> 播放音乐_yellow
            findViewById(R.id.btn_yellow).setOnClickListener(v -> playMusic(R.raw.yellow));

            findViewById(R.id.btn_green).setOnClickListener(v -> playMusic(R.raw.green));

            findViewById(R.id.btn_cyan).setOnClickListener(v -> playMusic(R.raw.qing));

            findViewById(R.id.btn_blue).setOnClickListener(v -> playMusic(R.raw.blue));

            findViewById(R.id.btn_purple).setOnClickListener(v -> playMusic(R.raw.purple));

            // 粉色块 -> 播放音乐_pink
            findViewById(R.id.btn_pink).setOnClickListener(v -> playMusic(R.raw.pink));

            findViewById(R.id.btn_brown).setOnClickListener(v -> playMusic(R.raw.brown));

            findViewById(R.id.btn_black).setOnClickListener(v -> playMusic(R.raw.black));

            findViewById(R.id.btn_white).setOnClickListener(v -> playMusic(R.raw.white));

            findViewById(R.id.btn_rainbow).setOnClickListener(v -> playMusic(R.raw.colorful));

        }

        private void playMusic(int musicResId) {
            // 停止之前的播放
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }

            // 播放新音乐
            mediaPlayer = MediaPlayer.create(this, musicResId);
            mediaPlayer.start();

            // 播放完成后释放资源
            mediaPlayer.setOnCompletionListener(mp -> {
                mediaPlayer.release();
                mediaPlayer = null;
            });
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        }
}








