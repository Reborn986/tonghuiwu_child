package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.bean.Knowledge;
import com.google.gson.Gson;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.iflytek.sparkchain.core.LLM;
import com.iflytek.sparkchain.core.LLMConfig;
import com.iflytek.sparkchain.core.SparkChain;
import com.iflytek.sparkchain.core.SparkChainConfig;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

import org.json.JSONObject;

public class LLMActivity extends AppCompatActivity {
//AI交流页面，见单说就是调用大语言模型，你们应该也用不到，不用管它
    private List<LLMDialog> dialogSource = new ArrayList<>();
    private int theme = 1;
    private CommonAdapter<LLMDialog> adapter;
    private RecyclerView recyclerDialog;
    private static String token;
    static Response response_access;
    public static TextView test_text;
    private String limitString = "你是一名专业的儿童教师，同时你是一名美术领域的专家，我是一名儿童，你现在面对的是一个孩子，请根据以下内容给我与美术相关的回答:";
    //这个prompt是为了让模型输出适宜儿童的回答
    public SimpleDateFormat sdf;
    private ImageButton back_button;
    private String person = null;
    private String llm;
    public static final String API_KEY = "qYlxPQdX6eo7uwTtLwV9I37d";
    public static final String SECRET_KEY = "UoZ6Q00j0KIQWKP2sDCwMWyQd6qt7jtt";
    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS) // 设置整个请求的超时时间为60秒
            .writeTimeout(60, TimeUnit.SECONDS).build();

    public EditText edit_send = null;
    ScrollView scrollView;
    private ConstraintLayout constraintLayout;

    public Button button_send;

    String llm_time;
    private int microFlag = 0;

    public static class AudioUtils {
        private static MainActivity.AudioUtils audioUtils;
        private SpeechSynthesizer mySynthesizer;

        public AudioUtils() {

        }

        public static MainActivity.AudioUtils getInstance() {
            if (audioUtils == null) {
                synchronized (MainActivity.AudioUtils.class) {
                    if (audioUtils == null) {
                        audioUtils = new MainActivity.AudioUtils();
                    }
                }
            }
            return audioUtils;
        }

        private InitListener myInitListener = new InitListener() {
            @Override
            public void onInit(int code) {
            }
        };

        public void init(Context context) {
            mySynthesizer = SpeechSynthesizer.createSynthesizer(context, myInitListener);
            mySynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
            //发音人xiaoyan
            mySynthesizer.setParameter(SpeechConstant.SPEED, "50");
            //语速50
            mySynthesizer.setParameter(SpeechConstant.PITCH, "50");
            //语调50
            mySynthesizer.setParameter(SpeechConstant.VOLUME, "100");
            //音量100
        }

        public void speakText(String content) {
            int code = mySynthesizer.startSpeaking(content, new SynthesizerListener() {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llmactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        /*&&&&&&&&&&&&&&&&&&&获取实例&&&&&&&&&&&*/
        test_text = findViewById(R.id.text_test);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        edit_send = findViewById(R.id.edit_send);
        constraintLayout = findViewById(R.id.main);
        button_send = (Button) findViewById(R.id.button_send);
        scrollView = findViewById(R.id.scrollView2);
        back_button = findViewById(R.id.back_button);

        /*&&&&&&&&&&&&&&&&&&&获取实例&&&&&&&&&&&*/

        /*&&&&&&&&&&&&&&&&&&&判断是否是main活动传来&&&&&&&&&&&*/
        if(MainActivity.txtdisplay != null&&!MainActivity.txtdisplay.getText().toString().isEmpty()){
            edit_send.setText(MainActivity.txtdisplay.getText().toString());
            MainActivity.txtdisplay.setText("按住话筒按钮，识别语音");
            MainActivity.txtdisplay.setTextColor(android.graphics.Color.parseColor("#3E855555"));
        }
        /*&&&&&&&&&&&&&&&&&&&判断是否是main活动传来&&&&&&&&&&&*/

        /*&&&&&&&&&&&&&&&&&&&判断主题&&&&&&&&&&&&&&&&&&&&&&*/
        theme = MainActivity.switchTheme;
        if (theme == 1) {
            constraintLayout.setBackgroundColor(android.graphics.Color.parseColor("#BAA1B3"));
            edit_send.setBackgroundResource(R.drawable.purple_point);
            button_send.setTextColor(android.graphics.Color.parseColor("#73526B"));
        }
        /*&&&&&&&&&&&&&&&&&&&判断主题&&&&&&&&&&&&&&&&&&&&&&*/

        /*&&&&&&&&&&&&&&&&&&&recycleview和adapter配置&&&&&&&&&&&*/
        recyclerDialog = findViewById(R.id.llm_data);
        adapter = new CommonAdapter<LLMDialog>(this, R.layout.llmdialog_item, dialogSource) {
            @Override
            protected void convert(ViewHolder viewHolder, LLMDialog llmDialog, int i) {
                if (dialogSource.get(i).person_text == null) {
                    viewHolder.setVisible(R.id.person_image, false);
                    viewHolder.setVisible(R.id.person_point_image, false);
                    viewHolder.setVisible(R.id.person_text, false);
                    viewHolder.setVisible(R.id.person_time, false);
                }
                viewHolder.setText(R.id.person_text, llmDialog.person_text);
                viewHolder.setText(R.id.llm_text, llmDialog.llm_text);
                viewHolder.setText(R.id.llm_time, llmDialog.time);
                viewHolder.setText(R.id.person_time, llmDialog.time);
                if (theme == 1) {
                    viewHolder.setBackgroundRes(R.id.llm_point_image, R.drawable.pink_point);
                    viewHolder.setBackgroundRes(R.id.llm_text, R.drawable.pink_circular);
                    viewHolder.setBackgroundRes(R.id.person_point_image, R.drawable.purple_point);
                    viewHolder.setBackgroundRes(R.id.person_text, R.drawable.purple_circular);
                    viewHolder.setTextColor(R.id.llm_time, android.graphics.Color.parseColor("#DA9E9E"));
                    viewHolder.setTextColor(R.id.person_time, android.graphics.Color.parseColor("#BAA1B3"));
                }
            }
        };
        recyclerDialog.setAdapter(adapter);
        initData();
        /*&&&&&&&&&&&&&&&&&&&recycleview和adapter配置&&&&&&&&&&&*/

        /*&&&&&&&&&&&&&&&&&&&点击事件&&&&&&&&&&&*/

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!button_send.isEnabled()) {
                    Toast.makeText(LLMActivity.this, "正在加载，请稍候...", Toast.LENGTH_SHORT).show();
                    return;
                }
                person = edit_send.getText().toString();
                if (!person.isEmpty()) {
                    try {
                        APIpost(person);
                    } catch (IOException | JSONException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(LLMActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();//提示
                }
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LLMActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        /*&&&&&&&&&&&&&&&&&&&点击事件&&&&&&&&&&&*/

    }
    /*&&&&&&&&&&&&&&&&&&&&动画&&&&&&&&&&&&&&&&&*/


    /*&&&&&&&&&&&&&&&&&&&&修改头像&&&&&&&&&&&&&&&&&*/
    /*&&&&&&&&&&&&&&&&&&&&修改头像&&&&&&&&&&&&&&&&&*/

    /*&&&&&&&&&&&&&&&&&&&&发送按钮post&&&&&&&&&&&&&&&&&&&*/
    public static void sendPost() {

    }


    /*&&&&&&&&&&&&&&&&&&&&调用千帆大模型API&&&&&&&&&&&&&&&&*/
    public void APIpost(String question) throws IOException, JSONException {
        new Thread(() -> {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    edit_send.setText("加载中......");
                    button_send.setEnabled(false);
                }
            });
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"messages\":[{\"role\":\"user\",\"content\":\"" + limitString + question + "\"}]}");
            Request request = null;
            try {
                request = new Request.Builder()
                        .url("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions?access_token=" + getAccessToken())
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .build();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            Response response = null;
            try {
                response = HTTP_CLIENT.newCall(request).execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                JSONObject jsonObject = new JSONObject(response.body().string());
                llm = jsonObject.getString("result");
//                    测试用：
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        test_text.setText(llm);
                        addRecycle(person, llm);
                        edit_send.setText("");
                        button_send.setEnabled(true);

                    }


                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    /*&&&&&&&&&&&&&&&&&&&&调用千帆大模型API&&&&&&&&&&&&&&&&*/


    /*&&&&&&&&&&&&&&&&&&&&get_access&&&&&&&&&&&&&&&&&*/
    private static String getAccessToken() throws IOException, JSONException {
        Thread thread = new Thread(() -> {
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                    + "&client_secret=" + SECRET_KEY);
            Request request = new Request.Builder()
                    .url("https://aip.baidubce.com/oauth/2.0/token")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            try {
                response_access = HTTP_CLIENT.newCall(request).execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {

                token = new JSONObject(response_access.body().string()).getString("access_token");
                System.out.println(token);
            } catch (IOException | JSONException e) {
                throw new RuntimeException(e);
            }

        });
        thread.start();
        try {
            thread.join(); // 主线程会等待thread线程执行完成后再继续执行
        } catch (InterruptedException e) {
            // 处理中断异常
            e.printStackTrace();
        }
        return token;
    }
    /*&&&&&&&&&&&&&&&&&&&&get_access&&&&&&&&&&&&&&&&&*/


    /*&&&&&&&&&&&&&&&&&&&&初始化llm对话&&&&&&&&&&&&&&&&&*/
    private void initData() {
        try {
            APIpost("你好");
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }
    /*&&&&&&&&&&&&&&&&&&&&初始化llm对话&&&&&&&&&&&&&&&&&*/

    /*&&&&&&&&&&&&&&&&&&&&加入新的dialog&&&&&&&&&&&&&&&&*/
    @SuppressLint("NotifyDataSetChanged")
    private void addRecycle(String person, String llm) {
        llm_time = sdf.format(new Date());
        LLMDialog dialog = new LLMDialog();
        dialog.llm_text = llm;
        dialog.person_text = person;
        dialog.time = llm_time;
        dialogSource.add(dialog);
        adapter.notifyDataSetChanged();
        // 获取新加入item的位置
        int newPosition = adapter.getItemCount() - 1;

// 移动到新的位置
        recyclerDialog.smoothScrollToPosition(newPosition);

// 执行一个向上平移的动画
        RecyclerView.LayoutManager layoutManager = recyclerDialog.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
            int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
            if (newPosition >= firstVisiblePosition && newPosition <= lastVisiblePosition) {
                View view = linearLayoutManager.findViewByPosition(newPosition);
                if (view != null) {
                    int distance = recyclerDialog.getHeight() - view.getTop();
                    view.setTranslationY(distance);
                    view.animate()
                            .translationY(0)
                            .setDuration(500)
                            .start();
                }
            }
        }

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    /*&&&&&&&&&&&&&&&&&&&&加入新的dialog&&&&&&&&&&&&&&&&*/
    public class use {
        /**
         * @TODO 科大讯飞语音听写
         * linowl 2020.09.11
         */
        public void initSpeech(final Context context) {
            //1.创建RecognizerDialog对象
            RecognizerDialog mDialog = new RecognizerDialog(context, null);
            //识别器定义
            final EditText txtdisplay = (EditText) findViewById(R.id.edit_send);
            microFlag = 1;
            //定义局部变量txtdisplay TextView标签 id为textView
            //2.设置accent、language等参数
            mDialog.setParameter(SpeechConstant.DOMAIN, "iat");
            //应用领域  iat：日常用语   medical：医疗
            mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
            //语言 zh_cn：中文 en_us：英文 ja_jp：日语 ko_kr：韩语 ru-ru：俄语 fr_fr：法语 es_es：西班牙语
            mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
            //方言  默认mandarin
            //3.设置回调接口
            mDialog.setListener(new RecognizerDialogListener() {
                @Override
                public void onResult(RecognizerResult recognizerResult, boolean isLast) {
                    if (!isLast) {
                        //解析语音
                        //返回的result为识别后的汉字,直接赋值到TextView上即可
                        String result = parseVoice(recognizerResult.getResultString());
                        // Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
                        txtdisplay.setText(result);
                        //识别成功在textView显示
                    }
                }
                @Override
                public void onError(SpeechError speechError) {

                }
            });
            //4.显示dialog，接收语音输入
            mDialog.show();
        }
    }
    /**
     * 解析语音json
     */
    public String parseVoice(String resultString) {
        Gson gson = new Gson();
        MainActivity.Voice voiceBean = gson.fromJson(resultString, MainActivity.Voice.class);

        StringBuffer sb = new StringBuffer();
        ArrayList<MainActivity.Voice.WSBean> ws = voiceBean.ws;
        for (MainActivity.Voice.WSBean wsBean : ws) {
            String word = wsBean.cw.get(0).w;
            sb.append(word);
        }
        return sb.toString();
    }

    /**
     * 语音实体类
     */
    public class Voice {

        public ArrayList<MainActivity.Voice.WSBean> ws;

        public class WSBean {
            public ArrayList<MainActivity.Voice.CWBean> cw;
        }

        public class CWBean {
            public String w;
        }
    }

    //调用use类的initSpeech函数
    public void Recognition(View view) {
        new use().initSpeech(this);
    }

    public void broadcast(View view) {
        final EditText editext = (EditText) findViewById(R.id.edit_micro);
        MainActivity.AudioUtils.getInstance().init(this); //初始化语音对象
        MainActivity.AudioUtils.getInstance().speakText(editext.getText().toString()); //播放语音
    }


}