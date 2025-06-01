package com.example.myapplication;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SeekBar;
import android.text.Editable;
import android.text.TextWatcher;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import android.widget.EditText;  // 用于 EditText 控件
import com.google.android.material.textfield.TextInputLayout;  // 用于 TextInputLayout
import com.google.android.material.textfield.TextInputEditText;  // 用于 TextInputEditText
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import androidx.core.view.ViewCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import com.example.myapplication.WebSocketClient;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.gson.Gson;

public class MusicColor extends AppCompatActivity implements WebSocketClient.WebSocketCallback {
    //这是和websocket有关的数据传输代码
    private static final String WS_URL = "ws://182.92.241.159:8000/ws/rgb/";
    private WebSocketClient webSocketClient;
    private View btnPlay;


    private MediaPlayer currentMediaPlayer;
    private Map<String, Integer> colorToMusicMap = new HashMap<>();


    // 控件声明
    private ImageButton btnBack;
    private SeekBar seekBarBrightness;
    private boolean isPlaying = false;
    private TextView tvBrightness;
    private String currentColorCategory = "";
    private List<Button> colorButtons = new ArrayList<>();
    private View colorDisplay;

    private TextInputEditText editTextColor;

    // endregion
    private MusicPlay musicPlay;
    private boolean isActivityVisible = true;
    private int lastReceivedColor = Color.TRANSPARENT; // 初始化为透明色
    // region 生命周期方法
    @Override//创建布局，和xml文件联系在一起
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colormusic);
        
        // 初始化语音识别
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=b8e19d69");
        applyPermission();
        
        initializeWebSocket();//初始化websocket客户端

        musicPlay = new MusicPlay(this);
        initColorMusicMap();//初始化音乐和颜色的关系
        initViews();//初始化界面的视图元素
        setupListeners();//设置事件监听器

        // 初始化音乐播放器
        musicPlay.setOnPlaybackStateChangeListener(isPlaying -> {
            updatePlayButtonIcon();
        });
    }
    //////////////////////////////统一播放器管理
    private synchronized void createMediaPlayer(int resId) {
        releaseMediaPlayer();
        currentMediaPlayer = MediaPlayer.create(this, resId);
        currentMediaPlayer.setOnCompletionListener(mp -> {
            isPlaying = false;
            updatePlayButtonIcon();
        });
    }

    private synchronized void releaseMediaPlayer() {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.release();
            currentMediaPlayer = null;
        }
    }
    ///////////////上面是统一播放管理增加的代码
    /////////////重新写一下palycolormusic的代码
    private void playColorMusic(String input) {
        if (input.isEmpty()) {
            return;
        }

        // 直接匹配映射表（支持中英文全称/简写）
        String normalizedInput = input.trim().toLowerCase();
        if (colorToMusicMap.containsKey(normalizedInput)) {
            musicPlay.playColorMusic(normalizedInput);
            return;
        }

        // 尝试解析为颜色值
        try {
            int color = Color.parseColor(normalizedInput);
            String colorKey = classifyColor(color);

            // 直接使用分类结果查询映射表
            if (colorToMusicMap.containsKey(colorKey)) {
                musicPlay.playColorMusic(colorKey);
            } else {
                showToast("该颜色暂无匹配音频");
            }
        } catch (IllegalArgumentException e) {
            showToast("无效的颜色输入");
        }
    }

    ///////////////WEBSocket//////////////////////////////////////////////////
    //初始化websocket的
    private void initializeWebSocket() {
        webSocketClient = new WebSocketClient(WS_URL, this);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (webSocketClient.isConnected()) {
                Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "连接失败", Toast.LENGTH_SHORT).show();
            }
        }, 1000);

    }
    @Override
    public void onConnected() {
        runOnUiThread(() ->
                Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onConnectionFailure(String error) {
        runOnUiThread(() -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
            btnPlay.setBackgroundColor(Color.GRAY); // 显示错误状态
        });
    }




    @Override
    public void onColorReceived(int color) {
        runOnUiThread(() -> {
            // 更新颜色显示
            if (!isFinishing() && !isDestroyed() && isActivityVisible) {
                Drawable background = btnPlay.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setColor(color);
                } else {
                    GradientDrawable newDrawable = new GradientDrawable();
                    newDrawable.setColor(color);
                    newDrawable.setCornerRadius(10f);
                    btnPlay.setBackground(newDrawable);
                }
            }

            // 分类颜色并准备音乐
            String colorCategory = classifyColor(color);
            if (colorToMusicMap.containsKey(colorCategory)) {
                // 预加载音乐
                musicPlay.playColorMusic(colorCategory);
                // 暂停音乐，等待用户点击播放按钮
                musicPlay.pauseMusic();
                // 更新播放按钮状态为暂停图标
                updatePlayButtonIcon();
            }
        });
    }

    //////////////传感器接收来的颜色进行分类，然后映射相应的颜色
    private String classifyColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);

        float hue = hsv[0]; // 色调 (0-360)
        float saturation = hsv[1]; // 饱和度 (0-1)
        float value = hsv[2]; // 明度 (0-1)

        // 根据您的映射表键名返回对应分类

        // 优先判断黑白灰
        if (value < 0.15f) {       // 极低明度 -> 黑色
            return "black";
        } else if (saturation < 0.1f) { // 低饱和度
            return value > 0.9f ? "white" : "gray"; // 高明度->白色，中等->灰色
        }

        // 棕色特殊处理（本质是低饱和度的橙色）
        if (hue >= 15 && hue < 45) { // 橙色色调范围
            if (saturation < 0.5f || value < 0.5f) { // 低饱和/低明度
                return "brown";
            }
            return "orange";
        }

        // 其他颜色分类
        if (hue < 15 || hue >= 330) {
            return "red";
        } else if (hue < 70) {
            return "yellow";
        } else if (hue < 160) {
            return "green";
        } else if (hue < 195) {
            return "cyan";
        } else if (hue < 255) {
            return "blue";
        } else if (hue < 285) {
            return "purple";
        } else {
            return "pink";
        }
    }

    //////////////
    @Override
    protected void onDestroy() {//释放资源用的
        musicPlay.stopMusic();
        releaseMediaPlayer();
        super.onDestroy();

    }
    // endregion

    //设置文本监听器


    // region 初始化方法
    private void initViews() {
        // 绑定控件
        btnBack = findViewById(R.id.btn_back);
        seekBarBrightness = findViewById(R.id.seekBar_brightness);
        tvBrightness = findViewById(R.id.tv_brightness);
        // 确保布局中有对应View
        editTextColor = findViewById(R.id.editTextColor);
        btnPlay=findViewById(R.id.btn_play);
        // 初始化颜色按钮
        int[] colorButtonIds = {
                R.id.btn_red, R.id.btn_orange, R.id.btn_yellow, R.id.btn_green,
                R.id.btn_cyan, R.id.btn_blue, R.id.btn_purple, R.id.btn_pink,
                R.id.btn_brown, R.id.btn_black, R.id.btn_white, R.id.btn_rainbow
        };

        for (int id : colorButtonIds) {
            Button btn = findViewById(id);
            colorButtons.add(btn);
        }
    }
    //播放状态管理//////////////////
    private void initMusicButton() {
        ImageButton btnPlay = findViewById(R.id.btn_play2);
        btnPlay.setOnClickListener(v -> {
            if (currentMediaPlayer == null) {
                prepareCurrentColorMedia(); // 新增方法
            }
            handleMusicControl();
        });
    }//初始化音乐播放按钮
    private void prepareCurrentColorMedia() {
        if (!currentColorCategory.isEmpty()) {
            Integer resId = colorToMusicMap.get(currentColorCategory);
            if (resId != null) {
                createMediaPlayer(resId);
            }
        }
    }

    /////////////////
    //音乐处理
    private void handleMusicControl() {
        if (isPlaying) {
            pauseMusic();
        } else {
            // 只有当前颜色有效时才允许播放
            if (!currentColorCategory.isEmpty()) {
                startMusic();
            } else {
                showToast("请先选择颜色");
            }
        }
        updatePlayButtonIcon();
        Log.d("MusicControl", "当前状态 - isPlaying:" + isPlaying
                + " colorCategory:" + currentColorCategory);
    }
    //启动播放
    private void startMusic() {
        if (currentMediaPlayer == null) {
            prepareMediaPlayer();
        }

        if (currentMediaPlayer != null && !isPlaying) {
            try {
                AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
                if (am.requestAudioFocus(null, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    currentMediaPlayer.start();
                    isPlaying = true;
                    Log.d("Playback", "shijibofangzhuangtai: " + currentMediaPlayer.isPlaying());
                }
            } catch (IllegalStateException e) {
                showToast("播放器chushihuafail");
                onDestroy();
            }
        }
    }
    private void pauseMusic() {//暂停播放
        if (currentMediaPlayer != null && currentMediaPlayer.isPlaying()) {
            currentMediaPlayer.pause();
            isPlaying = false;
            Log.d("MusicPause", "停止状态: " + !isPlaying);
        }
    }

    private void prepareMediaPlayer() {
        releaseMediaPlayer(); // 释放之前的资源
        if (currentColorCategory == null || currentColorCategory.isEmpty()) {
            Log.w("MusicError", "无效颜色分类");
            return;
        }

        Integer musicResId = colorToMusicMap.get(currentColorCategory);
        if (musicResId == null) {
            showToast("该颜色暂无音频");
            return;
        }

        try {
            currentMediaPlayer = MediaPlayer.create(this, musicResId);
            currentMediaPlayer.setOnCompletionListener(mp -> {
                isPlaying = false;
                updatePlayButtonIcon();
            });
            Log.d("MusicInit", "chenggongjiazai: " + musicResId);
        } catch (Exception e) {
            showToast("音频资源加载失败");
            Log.e("MusicInit", "jiazaishibai", e);
            currentMediaPlayer = null;
        }
    }

    // 在颜色分类完成后调用此方法
    private void onColorClassified(String colorCategory) {
        currentColorCategory = colorCategory.toLowerCase();

        // 颜色变化时自动停止当前播放
        if (isPlaying) {
            pauseMusic();
        }

        // 预加载新颜色的音频资源
        prepareMediaPlayer();

        // 可选：自动开始播放
        // startMusic();
    }



    /////////////和暂停播放按钮更新相关的
    private void toggleMusic() {
        if (isPlaying) {
            pauseMusic();
        } else {
            startMusic();
        }
        isPlaying = !isPlaying; // 切换状态
        // 更新按钮图标
    }
    private void updatePlayButtonIcon() {
        runOnUiThread(() -> {
            ImageButton btnPlay2 = findViewById(R.id.btn_play2);
            // 设置selected状态，这会触发selector_play_pause.xml中的状态切换
            btnPlay2.setSelected(musicPlay.isPlaying());
            // 强制刷新按钮状态
            btnPlay2.jumpDrawablesToCurrentState();
        });
    }
    private void initColorMusicMap() {//颜色名称和颜色的映射关系，不是按钮和颜色的映射关系
        colorToMusicMap.put("red", R.raw.red);
        colorToMusicMap.put("orange", R.raw.orange);
        colorToMusicMap.put("yellow", R.raw.yellow);
        colorToMusicMap.put("green", R.raw.green);
        colorToMusicMap.put("cyan", R.raw.qing);
        colorToMusicMap.put("blue", R.raw.blue);
        colorToMusicMap.put("purple", R.raw.purple);
        colorToMusicMap.put("pink", R.raw.pink);
        colorToMusicMap.put("brown", R.raw.brown);
        colorToMusicMap.put("rainbow", R.raw.colorful);
        colorToMusicMap.put("black", R.raw.black);
        colorToMusicMap.put("white", R.raw.white);

        colorToMusicMap.put("红色", R.raw.red);
        colorToMusicMap.put("蓝色", R.raw.blue);
        colorToMusicMap.put("绿色", R.raw.green);
        colorToMusicMap.put("黄色", R.raw.yellow);
        colorToMusicMap.put("橙色", R.raw.orange);
        colorToMusicMap.put("紫色", R.raw.purple);
        colorToMusicMap.put("粉色", R.raw.pink);
        colorToMusicMap.put("棕色", R.raw.brown);
        colorToMusicMap.put("黑色", R.raw.black);
        colorToMusicMap.put("白色", R.raw.white);
        colorToMusicMap.put("彩色", R.raw.colorful);

        colorToMusicMap.put("红", R.raw.red);
        colorToMusicMap.put("蓝", R.raw.blue);
        colorToMusicMap.put("绿", R.raw.green);
        colorToMusicMap.put("黄", R.raw.yellow);
        colorToMusicMap.put("橙", R.raw.orange);
        colorToMusicMap.put("紫", R.raw.purple);
        colorToMusicMap.put("粉", R.raw.pink);
        colorToMusicMap.put("棕", R.raw.brown);
        colorToMusicMap.put("黑", R.raw.black);
        colorToMusicMap.put("白", R.raw.white);
        colorToMusicMap.put("彩", R.raw.colorful);
    }
    // endregion

    // region 事件处理
    private void setupListeners() {
        // 返回按钮
        btnBack.setOnClickListener(v -> finish());//点击返回按钮会调用finish,返回上衣级

        // 颜色按钮
        for (Button btn : colorButtons) {
            btn.setOnClickListener(v -> handleColorButtonClick(btn));
        }//点击按钮调用handle啥的函数

        // 亮度调节
        seekBarBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvBrightness.setText("亮度: " + progress + "%");//?
                updateButtonsBrightness(progress);
            }//监听用户的滑动操作
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // 空实现
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 空实现
            }
            // 其他空实现方法...
        });

        editTextColor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString().trim();
                if (!input.isEmpty()) {
                    musicPlay.playColorMusic(input);
                }
            }
        });

        editTextColor.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                String input = editTextColor.getText().toString().trim();
                if (!input.isEmpty()) {
                    musicPlay.playColorMusic(input);
                }
                return true;
            }
            return false;
        });

        // 设置播放按钮点击事件
        ImageButton btnPlay2 = findViewById(R.id.btn_play2);
        btnPlay2.setOnClickListener(v -> {
            if (musicPlay.isPlaying()) {
                musicPlay.pauseMusic();
            } else {
                musicPlay.startMusic();
            }
            // 立即更新按钮状态
            updatePlayButtonIcon();
        });

        // 设置语音按钮点击事件
        ImageButton btnVoice = findViewById(R.id.btn_voice);
        btnVoice.setOnClickListener(v -> {
            if (checkPermissions()) {
                initSpeech();
            } else {
                applyPermission();
            }
        });
    }
    private void updateButtonsBrightness(int brightness) {
        // 将亮度值从0-100转换为0.5-1.0的范围，避免颜色太暗
        float minBrightness = 0.5f; // 最低亮度设为50%
        float maxBrightness = 1.0f; // 最高亮度100%
        
        // 使用非线性映射，使低亮度区域的变化更平缓
        float normalizedBrightness = brightness / 100f;
        float adjustedBrightness = minBrightness + (normalizedBrightness * normalizedBrightness) * (maxBrightness - minBrightness);

        for (Button btn : colorButtons) {
            if (btn.getId() == R.id.btn_rainbow) {
                // 单独处理彩虹按钮（调整图片透明度）
                Drawable background = btn.getBackground();
                int alpha = (int) (adjustedBrightness * 255);
                background.setAlpha(alpha);
                btn.setBackground(background);
            } else {
                int color = getButtonColor(btn);
                float[] hsv = new float[3];
                Color.colorToHSV(color, hsv);
                
                // 保持原有的色调和饱和度，只调整明度
                hsv[2] = adjustedBrightness;
                
                // 保持原有的透明度
                int alpha = Color.alpha(color);
                int newColor = Color.HSVToColor(alpha, hsv);
                btn.setBackgroundTintList(ColorStateList.valueOf(newColor));
            }
        }
        
        // 同时更新显示区域的颜色
        if (btnPlay != null) {
            Drawable background = btnPlay.getBackground();
            if (background instanceof GradientDrawable) {
                int color = ((GradientDrawable) background).getColor().getDefaultColor();
                float[] hsv = new float[3];
                Color.colorToHSV(color, hsv);
                hsv[2] = adjustedBrightness;
                int newColor = Color.HSVToColor(Color.alpha(color), hsv);
                ((GradientDrawable) background).setColor(newColor);
            }
        }
    }
    private int getButtonColor(Button btn) {
        // 优先检查 BackgroundTint
        ColorStateList tint = btn.getBackgroundTintList();
        if (tint != null) {
            return tint.getDefaultColor();
        }

        // 如果直接设置 Background 颜色
        Drawable background = btn.getBackground();
        if (background instanceof ColorDrawable) {
            return ((ColorDrawable) background).getColor();
        }

        return Color.BLACK; // 默认颜色
    }

    private void handleColorButtonClick(Button clickedButton) {
        String colorName = getColorNameByButtonId(clickedButton.getId());
        if (colorName != null) {
            // 更新颜色显示
            int color = getColorFromName(colorName);
            updateColorDisplay(color);
            
            // 准备并播放音乐
            musicPlay.playColorMusic(colorName);
            musicPlay.pauseMusic();
        }
    }

    private String getColorNameByButtonId(int buttonId) {
        switch (buttonId) {
            case R.id.btn_red: return "red";
            case R.id.btn_orange: return "orange";
            case R.id.btn_yellow: return "yellow";
            case R.id.btn_green: return "green";
            case R.id.btn_cyan: return "cyan";
            case R.id.btn_blue: return "blue";
            case R.id.btn_purple: return "purple";
            case R.id.btn_pink: return "pink";
            case R.id.btn_brown: return "brown";
            case R.id.btn_black: return "black";
            case R.id.btn_white: return "white";
            case R.id.btn_rainbow: return "rainbow";
            default: return null;
        }
    }

    private void handleVoiceInput(String text) {
        // 处理语音识别结果
        String normalizedText = text.toLowerCase().trim();
        
        // 检查是否是颜色名称
        if (colorToMusicMap.containsKey(normalizedText)) {
            // 更新颜色显示
            int color = getColorFromName(normalizedText);
            updateColorDisplay(color);
            
            // 准备音乐
            musicPlay.playColorMusic(normalizedText);
            musicPlay.pauseMusic();
            
            showToast("已识别颜色: " + text);
        } else {
            showToast("未识别到有效颜色");
        }
    }

    private void updateColorDisplay(int color) {
        runOnUiThread(() -> {
            if (!isFinishing() && !isDestroyed() && isActivityVisible) {
                Drawable background = btnPlay.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setColor(color);
                } else {
                    GradientDrawable newDrawable = new GradientDrawable();
                    newDrawable.setColor(color);
                    newDrawable.setCornerRadius(10f);
                    btnPlay.setBackground(newDrawable);
                }
            }
        });
    }

    private int getColorFromName(String colorName) {
        Button colorButton = null;
        switch (colorName) {
            case "red":
            case "红色":
            case "红":
                colorButton = findViewById(R.id.btn_red);
                break;
            case "green":
            case "绿色":
            case "绿":
                colorButton = findViewById(R.id.btn_green);
                break;
            case "blue":
            case "蓝色":
            case "蓝":
                colorButton = findViewById(R.id.btn_blue);
                break;
            case "yellow":
            case "黄色":
            case "黄":
                colorButton = findViewById(R.id.btn_yellow);
                break;
            case "orange":
            case "橙色":
            case "橙":
                colorButton = findViewById(R.id.btn_orange);
                break;
            case "purple":
            case "紫色":
            case "紫":
                colorButton = findViewById(R.id.btn_purple);
                break;
            case "pink":
            case "粉色":
            case "粉":
                colorButton = findViewById(R.id.btn_pink);
                break;
            case "brown":
            case "棕色":
            case "棕":
                colorButton = findViewById(R.id.btn_brown);
                break;
            case "black":
            case "黑色":
            case "黑":
                colorButton = findViewById(R.id.btn_black);
                break;
            case "white":
            case "白色":
            case "白":
                colorButton = findViewById(R.id.btn_white);
                break;
            case "rainbow":
            case "彩色":
            case "彩":
                colorButton = findViewById(R.id.btn_rainbow);
                break;
        }

        if (colorButton != null) {
            ColorStateList tint = colorButton.getBackgroundTintList();
            if (tint != null) {
                return tint.getDefaultColor();
            }
        }
        return Color.TRANSPARENT;
    }
    // endregion

    // region 颜色音乐功能
    private void setActiveColor(String colorName) {
        releaseMediaPlayer();//之前播放的音频释放
        //点击颜色按钮时，通过颜色名称获取对应的音频资源，用Mediaplayer播放音频
        Integer musicResId = colorToMusicMap.get(colorName.toLowerCase());
        if (musicResId == null) {
            showToast("未找到该颜色的音频");
            return;
        }

        currentMediaPlayer = MediaPlayer.create(this, musicResId);
        currentMediaPlayer.setOnCompletionListener(mp -> releaseMediaPlayer());
        currentMediaPlayer.start();
    }

    // endregion

    // region WebSocket功能


    // endregion

    // region 工具方法
    private void updateBrightness(int progress) {
        float alpha = progress / 255f;
        colorDisplay.setAlpha(alpha);
        tvBrightness.setText(String.format("亮度：%d%%", (int)(alpha * 100)));
    }



    private void showToast(String message) {
        runOnUiThread(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }
    //语音识别功能！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    private static final String[] PERMISSIONS_STORAGE = {
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

    private boolean checkPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            for (String permission : PERMISSIONS_STORAGE) {
                if (ContextCompat.checkSelfPermission(this, permission) 
                    != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void applyPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean needApply = false;
            for (String permission : PERMISSIONS_STORAGE) {
                if (ContextCompat.checkSelfPermission(this, permission) 
                    != PackageManager.PERMISSION_GRANTED) {
                    needApply = true;
                    break;
                }
            }
            if (needApply) {
                // 先请求网络相关权限
                String[] networkPermissions = {
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.CHANGE_NETWORK_STATE
                };
                ActivityCompat.requestPermissions(this, networkPermissions, 1);
            }
        }
    }

    private void initSpeech() {
        try {
            // 检查权限
            if (!checkPermissions()) {
                applyPermission();
                return;
            }

            // 检查讯飞SDK是否初始化成功
            if (SpeechUtility.getUtility() == null) {
                SpeechUtility.createUtility(this, SpeechConstant.APPID + "=b8e19d69");
            }

            RecognizerDialog mDialog = new RecognizerDialog(this, null);
            if (mDialog == null) {
                showToast("语音识别初始化失败");
                return;
            }

            // 设置识别参数
            mDialog.setParameter(SpeechConstant.DOMAIN, "iat");
            mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
            mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
            mDialog.setParameter(SpeechConstant.ASR_PTT, "0"); // 关闭标点符号
            mDialog.setParameter(SpeechConstant.VAD_BOS, "4000"); // 前端点检测
            mDialog.setParameter(SpeechConstant.VAD_EOS, "1000"); // 后端点检测

            mDialog.setListener(new RecognizerDialogListener() {
                @Override
                public void onResult(RecognizerResult result, boolean isLast) {
                    if (!isLast) {
                        String text = parseVoice(result.getResultString());
                        if (text != null && !text.isEmpty()) {
                            handleVoiceInput(text);
                        }
                    }
                }

                @Override
                public void onError(SpeechError error) {
                    showToast("语音识别错误: " + error.getPlainDescription(true));
                }
            });

            mDialog.show();
        } catch (Exception e) {
            Log.e("Speech", "语音识别初始化失败", e);
            showToast("语音识别初始化失败，请检查权限和网络");
        }
    }

    private String parseVoice(String resultString) {
        Gson gson = new Gson();
        Voice voiceBean = gson.fromJson(resultString, Voice.class);

        StringBuilder sb = new StringBuilder();
        ArrayList<Voice.WSBean> ws = voiceBean.ws;
        for (Voice.WSBean wsBean : ws) {
            String word = wsBean.cw.get(0).w;
            sb.append(word);
        }
        return sb.toString();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            boolean allGranted = true;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    showToast(permissions[i] + " 权限被拒绝");
                }
            }
            if (allGranted) {
                // 网络权限已获取，继续请求其他权限
                String[] otherPermissions = {
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CAMERA
                };
                ActivityCompat.requestPermissions(this, otherPermissions, 2);
            }
        } else if (requestCode == 2) {
            boolean allGranted = true;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    showToast(permissions[i] + " 权限被拒绝");
                }
            }
            if (allGranted) {
                initSpeech();
            }
        }
    }

    //websocket

    // 语音识别结果解析类
    private class Voice {
        public ArrayList<WSBean> ws;

        public class WSBean {
            public ArrayList<CWBean> cw;
        }

        public class CWBean {
            public String w;
        }
    }
}

