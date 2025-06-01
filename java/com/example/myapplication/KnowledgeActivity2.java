package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.bean.Knowledge;
import com.example.myapplication.databinding.ActivityKnowledge2Binding;
import com.example.myapplication.databinding.ActivityKnowledgeBinding;
import com.example.myapplication.utils.RoundedCorners2;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeActivity2 extends AppCompatActivity {
    //这个是链接到微信公众号的文章，不用管，用不到
    private ActivityKnowledge2Binding binding;

    private List<Knowledge> dataSource = new ArrayList<>();
    private CommonAdapter<Knowledge> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKnowledge2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();

        adapter = new CommonAdapter<Knowledge>(this, R.layout.konwledge_item2, dataSource) {
            @Override
            protected void convert(ViewHolder holder, Knowledge item, int position) {
                Glide.with(mContext).asBitmap()
                        .load(item.getImgUrl())
                        .apply(new RequestOptions().bitmapTransform(new RoundedCorners2(26, true)))
                        .into((ImageView) holder.getView(R.id.iv_pic));

                holder.setText(R.id.tv_title, item.getTitle());
                holder.setText(R.id.tv_content, item.getSubheading());
                holder.setOnClickListener(R.id.item, view -> {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl())));
                });
            }
        };
        binding.rvData.setAdapter(adapter);
    }

    private void initData() {
        Knowledge knowledge1 = new Knowledge();
        knowledge1.setTitle("传统色科普——朱红");
        knowledge1.setSubheading("配色分享 | 让你惊艳的中国传统色--朱砂");
        knowledge1.setUrl("https://mp.weixin.qq.com/s/bMUJ0b0i8NOcr6zpzTjPXw");
        knowledge1.setImgUrl("https://mmbiz.qpic.cn/mmbiz_png/JYWHEBD4XsOS1KO78hjyQnAwXtJT8A7Gnda97jWOff0B4W3kBqMzUHBMayibwdreSGXa3n1EekvBrPeZOD9DASg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1");
        dataSource.add(knowledge1);

        Knowledge knowledge2 = new Knowledge();
        knowledge2.setTitle("传统色科普——青色");
        knowledge2.setSubheading("《满庭芳•国色》中的青绿山水色 中国传统色");
        knowledge2.setUrl("https://mp.weixin.qq.com/s/lTMehRQoUFopFuO_Mwq97Q");
        knowledge2.setImgUrl("https://mmbiz.qpic.cn/mmbiz_png/JYWHEBD4XsPPUB9icPnqMBibclqaOCUS7Ugar9z2k6o7qUU8nkotFjYicKqDy744b4TRFiaibBUlFfSBnXjxRykJB4w/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1");
        dataSource.add(knowledge2);

        Knowledge knowledge3 = new Knowledge();
        knowledge3.setTitle("传统色科普——紫色");
        knowledge3.setSubheading("配色分享 | 高贵又神秘的传统色调--紫色");
        knowledge3.setUrl("https://mp.weixin.qq.com/s/WLxQYiPEUBiYfVZ3rppvAw");
        knowledge3.setImgUrl("https://mmbiz.qpic.cn/mmbiz_jpg/JYWHEBD4XsPh7s7hibGuB1BNeiahTaw00aEr9icvQ4Bv0TibZqOL5FToYS61SH5XhQY5lrBR7RoZy0UGyaC8VNAPSw/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1");
        dataSource.add(knowledge3);

        Knowledge knowledge4 = new Knowledge();
        knowledge4.setTitle("传统色科普—黄色");
        knowledge4.setSubheading("中国传统色•春夏•黄色");
        knowledge4.setUrl("https://mp.weixin.qq.com/s/2qfHq6KkkDe5oVETsjtXmQ");
        knowledge4.setImgUrl("https://mmbiz.qpic.cn/mmbiz_png/JYWHEBD4XsPPUB9icPnqMBibclqaOCUS7UIGBxYb4VOqsBUJaRA3W6xZoydYTUUnCPFe4jhcLsUv6ZwPgx5qXsmg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1");
        dataSource.add(knowledge4);

        Knowledge knowledge5 = new Knowledge();
        knowledge5.setTitle("传统色科普—蓝-毛月色");
        knowledge5.setSubheading("酬美景 驻清秋 绿橙香嫩酒初浮");
        knowledge5.setUrl("https://mp.weixin.qq.com/s/riBIJkV4aF0aUqnf49S-_w");
        knowledge5.setImgUrl("https://mmbiz.qpic.cn/mmbiz_jpg/JYWHEBD4XsOtOQPXVBoJ547CEr6RhiaqyH8Sy0ETzL3Y4qBSvy0bGW0AomKyKvC6mUibewEna59KPv3cUWHznabA/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1");
        dataSource.add(knowledge5);

        Knowledge knowledge6 = new Knowledge();
        knowledge6.setTitle("传统色科普——蓝-橙色");
        knowledge6.setSubheading("所谓毛月，其实和月亮无关，而是与天空有关");
        knowledge6.setUrl("https://mp.weixin.qq.com/s/t6tpLvqEYOzhV2df1pr5aA");
        knowledge6.setImgUrl("https://mmbiz.qpic.cn/mmbiz_jpg/JYWHEBD4XsOtOQPXVBoJ547CEr6RhiaqyDo6VUF4PWiaJkY4zBeEKnf5CL7AfyOzHiaJpFdBRCUdeLicFCIfk3Ufkw/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1");
        dataSource.add(knowledge6);

        Knowledge knowledge7 = new Knowledge();
        knowledge7.setTitle("传统颜色科普——绿色");
        knowledge7.setSubheading("庐山山北泼蓝青 碧蓝帐裹翡翠屏");
        knowledge7.setUrl("https://mp.weixin.qq.com/s/5APWxhnpKYDSjtZR3UDtQg");
        knowledge7.setImgUrl("https://mmbiz.qpic.cn/mmbiz_jpg/JYWHEBD4XsNzu12NUwevZiapicaQ9JNtyqCib9iaoEKqfujKDApviadWQQ0mknvxOgAkZxhylwfXM9H6AoTPOib2aUWQ/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1");
        dataSource.add(knowledge7);

        ImageButton imageButton1 = findViewById(R.id.imbutton_home);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KnowledgeActivity2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        ImageButton imageButton2 = findViewById(R.id.imbutton_seka);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KnowledgeActivity2.this, SekaBlue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        ImageButton imageButton3 = findViewById(R.id.imbutton_shequ);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KnowledgeActivity2.this, society.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        ImageButton back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KnowledgeActivity2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        AppCompatButton textView1=findViewById(R.id.t1);
        AppCompatButton textView2=findViewById(R.id.t2);
        AppCompatButton textView3=findViewById(R.id.t3);
        AppCompatButton textView4=findViewById(R.id.t4);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.add(knowledge1);
                dataSource.add(knowledge2);
                dataSource.add(knowledge3);dataSource.add(knowledge4);dataSource.add(knowledge5);dataSource.add(knowledge6);
                dataSource.add(knowledge7);
                adapter.notifyDataSetChanged();
                if(MainActivity.switchTheme==1) {
                    textView1.setBackgroundResource(R.drawable.knowledge_bg_button);

                }else if(MainActivity.switchTheme==0){
                    textView1.setBackgroundResource(R.drawable.knowledge_bg_button2);
                }
                textView2.setBackgroundColor(Color.TRANSPARENT);
                textView3.setBackgroundColor(Color.TRANSPARENT);
                textView4.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.clear();
                adapter.notifyDataSetChanged();
                if(MainActivity.switchTheme==1) {
                    textView2.setBackgroundResource(R.drawable.knowledge_bg_button);

                }else if(MainActivity.switchTheme==0){
                    textView2.setBackgroundResource(R.drawable.knowledge_bg_button2);
                }
                textView1.setBackgroundColor(Color.TRANSPARENT);
                textView3.setBackgroundColor(Color.TRANSPARENT);
                textView4.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.clear();
                adapter.notifyDataSetChanged();
                if(MainActivity.switchTheme==1) {
                    textView3.setBackgroundResource(R.drawable.knowledge_bg_button);

                }else if(MainActivity.switchTheme==0){
                    textView3.setBackgroundResource(R.drawable.knowledge_bg_button2);
                }
                textView2.setBackgroundColor(Color.TRANSPARENT);
                textView1.setBackgroundColor(Color.TRANSPARENT);
                textView4.setBackgroundColor(Color.TRANSPARENT);

            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.clear();
                adapter.notifyDataSetChanged();
                if(MainActivity.switchTheme==1) {
                    textView4.setBackgroundResource(R.drawable.knowledge_bg_button);

                }else if(MainActivity.switchTheme==0){
                    textView4.setBackgroundResource(R.drawable.knowledge_bg_button2);
                }
                textView2.setBackgroundColor(Color.TRANSPARENT);
                textView3.setBackgroundColor(Color.TRANSPARENT);
                textView1.setBackgroundColor(Color.TRANSPARENT);

            }
        });
    }
}