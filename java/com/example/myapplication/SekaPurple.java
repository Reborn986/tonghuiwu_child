package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialogx.dialogs.BottomMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SekaPurple extends AppCompatActivity {


    public class PurpleColor {
        private int imageId;
        private String colorName;

        public PurpleColor(int ImageId,String ColorName) {
            this.imageId = ImageId;
            this.colorName=ColorName;
        }

        public int getImageId() {
            return imageId;
        }
    }

    private List<PurpleColor> purpleColorList1 = new ArrayList<>();
    private List<PurpleColor> purpleColorList2 = new ArrayList<>();
    private LinearLayout toolbar1;
    private PurpleColor[] PurpleColors= {

            new PurpleColor(R.drawable.purple_shenqianniuzi, "#1c0d1a"),
            new PurpleColor(R.drawable.purple_anlanzi, "#131124"),
            new PurpleColor(R.drawable.purple_anlongdanzi, "#22202e"),
            new PurpleColor(R.drawable.purple_lizi, "#2b1216"),
            new PurpleColor(R.drawable.purple_moshizi, "#382129"),
            new PurpleColor(R.drawable.purple_qiepizi, "#2d0c13"),
            new PurpleColor(R.drawable.purple_luanshizi, "#30161c"),
            new PurpleColor(R.drawable.purple_mozi, "#310f1b"),
            new PurpleColor(R.drawable.purple_huoezi, "#33141e"),
            new PurpleColor(R.drawable.purple_biqizi, "#411c35"),
            new PurpleColor(R.drawable.purple_ganzi, "#461629"),
            new PurpleColor(R.drawable.purple_gutongzi, "#440e25"),
            new PurpleColor(R.drawable.purple_haixiangzi, "#4b1e2f"),
            new PurpleColor(R.drawable.purple_zhuganzi, "#541e24"),
            new PurpleColor(R.drawable.purple_jiangzi, "#4d1018"),
            new PurpleColor(R.drawable.purple_putaozi, "#4c1f24"),
            new PurpleColor(R.drawable.purple_jinyuzi, "#500a16"),
            new PurpleColor(R.drawable.purple_anyuzi, "#5c2223"),
            new PurpleColor(R.drawable.purple_lizi_2, "#5a191b"),
            new PurpleColor(R.drawable.purple_putaojiangzi, "#5a1216"),
            new PurpleColor(R.drawable.purple_diaozi, "#5d3131"),
            new PurpleColor(R.drawable.purple_shizhuzi, "#63071c"),
            new PurpleColor(R.drawable.purple_ganzhezi, "#621624"),
            new PurpleColor(R.drawable.purple_yaoguanzi, "#621d34"),
            new PurpleColor(R.drawable.purple_jingshizi, "#1f2040"),
            new PurpleColor(R.drawable.purple_longkuizi, "#322f3b"),
            new PurpleColor(R.drawable.purple_longqingyuzi, "#4e2a40"),
            new PurpleColor(R.drawable.purple_yeputaozi, "#302f4b"),
            new PurpleColor(R.drawable.purple_jianfengzi, "#3e3841"),
            new PurpleColor(R.drawable.purple_mantianxingzi, "#2e317c"),
            new PurpleColor(R.drawable.purple_qianniuzi, "#681752"),
            new PurpleColor(R.drawable.purple_caitouzi, "#951c48"),
            new PurpleColor(R.drawable.purple_weizi, "#7e1671"),
            new PurpleColor(R.drawable.purple_gejinzi, "#7e2065"),
            new PurpleColor(R.drawable.purple_qinglianzi, "#8b2671"),
            new PurpleColor(R.drawable.purple_xiancaizi, "#9b1e64"),
            new PurpleColor(R.drawable.purple_yejvzi, "#525288"),
            new PurpleColor(R.drawable.purple_jiegengzi, "#813c85"),
            new PurpleColor(R.drawable.purple_jiehuazi, "#983680"),
            new PurpleColor(R.drawable.purple_yangcongzi, "#a8456b"),
            new PurpleColor(R.drawable.purple_shangengzi, "#61649f"),
            new PurpleColor(R.drawable.purple_jinzi, "#806d9e"),
            new PurpleColor(R.drawable.purple_xunzi, "#815c94"),
            new PurpleColor(R.drawable.purple_luodianzi, "#74759b"),
            new PurpleColor(R.drawable.purple_tengluozi, "#8076a3"),
            new PurpleColor(R.drawable.purple_biandouzi, "#a35c8f"),
            new PurpleColor(R.drawable.purple_doukouzi, "#ad6598"),
            new PurpleColor(R.drawable.purple_yingcaozi, "#c06f98"),
            new PurpleColor(R.drawable.purple_qinggekezi, "#bc84a8"),
            new PurpleColor(R.drawable.purple_luolanzi, "#c08eaf"),
            new PurpleColor(R.drawable.purple_danlanzi, "#a7a8bd"),
            new PurpleColor(R.drawable.purple_fengxinzi, "#c8adc4"),
            new PurpleColor(R.drawable.purple_danqianniuzi, "#d1c2d3"),
            new PurpleColor(R.drawable.purple_yuanshanzi, "#ccccd6"),
            new PurpleColor(R.drawable.purple_danqingzi, "#e0c8d1"),
            new PurpleColor(R.drawable.purple_dingxiangdanzi, "#e9d7df"),
            new PurpleColor(R.drawable.purple_mabiancaozi, "#ede3d7"),
            new PurpleColor(R.drawable.purple_dantengluozi, "#f2e7e5"),




    };

    private void initPurpleCard1() {
        purpleColorList1.clear();
        for (int i = 0; i <134; i+=2) {
            purpleColorList1.add(PurpleColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(PurpleColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    private void initBlueCard2() {
        purpleColorList2.clear();
        for (int i = 1; i <134; i+=2) {
            purpleColorList2.add(PurpleColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color =Color.parseColor(PurpleColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    String[] shiju = new String[]{"角声满天秋色里,塞上燕脂凝夜紫","潦水尽而寒潭清,烟光凝而暮山紫","流俗相纠错,纷纷竞齐紫","胡瓶落膊紫薄汗,碎叶城西秋月团","紫兰白色遍山坳,铃铛不语春来报","春晖开紫苑,淑景媚兰场","远山眉黛娇长,清歌细逐霞觞","红色鲜于二月中,分明姹紫胜嫣红","大带委黄葛,紫蒲交狭涘","玉转湿丝牵晓水,熟粉生香琅玕紫","赤地当年布衣起,老妪悲啼白龙死,芒砀生云凝夜紫","宫拜少常休,青緺换鹿裘","独坐空山思五陵,丁香花发又逢春"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_purple);

        toolbar1 = findViewById(R.id.toolbar_photo);

        ImageView imageView=findViewById(R.id.purple_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaPurple.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        LinearLayout view=findViewById(R.id.picture);

        ImageButton imageButton1=findViewById(R.id.button_danqianniuzi);
        ImageButton imageButton2=findViewById(R.id.button_anlanzi);
        ImageButton imageButton3=findViewById(R.id.button_anlongdanzi);
        ImageButton imageButton4=findViewById(R.id.button_lizi);
        ImageButton imageButton5=findViewById(R.id.button_moshizi);
        ImageButton imageButton6=findViewById(R.id.button_qiepizi);
        ImageButton imageButton7=findViewById(R.id.button_luanshizi);
        ImageButton imageButton8=findViewById(R.id.button_mozi);
        ImageButton imageButton9=findViewById(R.id.button_huoezi);
        ImageButton imageButton10=findViewById(R.id.button_biqizi);
        ImageButton imageButton11=findViewById(R.id.button_ganzi);
        ImageButton imageButton12=findViewById(R.id.button_gutongzi);
        ImageButton imageButton13=findViewById(R.id.button_haixiangzi);
        ImageButton imageButton14=findViewById(R.id.button_zhuganzi);
        ImageButton imageButton15=findViewById(R.id.button_jiangzi);
        ImageButton imageButton16=findViewById(R.id.button_putaozi);
        ImageButton imageButton17=findViewById(R.id.button_jinyuzi);
        ImageButton imageButton18=findViewById(R.id.button_anyuzi);
        ImageButton imageButton19=findViewById(R.id.button_lizi_2);
        ImageButton imageButton20=findViewById(R.id.button_putaojiangzi);
        ImageButton imageButton21=findViewById(R.id.button_diaozi);
        ImageButton imageButton22=findViewById(R.id.button_shizhuzi);
        ImageButton imageButton23=findViewById(R.id.button_ganzhezi);
        ImageButton imageButton24=findViewById(R.id.button_yaoguanzi);
        ImageButton imageButton25=findViewById(R.id.button_jingshizi);
        ImageButton imageButton26=findViewById(R.id.button_longkuizi);
        ImageButton imageButton27=findViewById(R.id.button_longqingyuzi);
        ImageButton imageButton28=findViewById(R.id.button_yeputaozi);
        ImageButton imageButton29=findViewById(R.id.button_jianfengzi);
        ImageButton imageButton30=findViewById(R.id.button_mantianxingzi);
        ImageButton imageButton31=findViewById(R.id.button_qianniuzi);
        ImageButton imageButton32=findViewById(R.id.button_caitouzi);
        ImageButton imageButton33=findViewById(R.id.button_weizi);
        ImageButton imageButton34=findViewById(R.id.button_gejinzi);
        ImageButton imageButton35=findViewById(R.id.button_qinglian);
        ImageButton imageButton36=findViewById(R.id.button_xiancaizi);
        ImageButton imageButton37=findViewById(R.id.button_yejvzi);
        ImageButton imageButton38=findViewById(R.id.button_jiegengzi);
        ImageButton imageButton39=findViewById(R.id.button_jihuazi);
        ImageButton imageButton40=findViewById(R.id.button_yangcongzi);
        ImageButton imageButton41=findViewById(R.id.button_shangengzi);
        ImageButton imageButton42=findViewById(R.id.button_jinzi);
        ImageButton imageButton43=findViewById(R.id.button_xunzi);
        ImageButton imageButton44=findViewById(R.id.button_luodianzi);
        ImageButton imageButton45=findViewById(R.id.button_tengluozi);
        ImageButton imageButton46=findViewById(R.id.button_biandouzi);
        ImageButton imageButton47=findViewById(R.id.button_doukouzi);
        ImageButton imageButton48=findViewById(R.id.button_yingcaozi);
        ImageButton imageButton49=findViewById(R.id.button_qinggekezi);
        ImageButton imageButton50=findViewById(R.id.button_luolanzi);
        ImageButton imageButton51=findViewById(R.id.button_danlanzi);
        ImageButton imageButton52=findViewById(R.id.button_fengxinzi);
        ImageButton imageButton53=findViewById(R.id.button_danqianniuzi);
        ImageButton imageButton54=findViewById(R.id.button_yuanshanzi);
        ImageButton imageButton55=findViewById(R.id.button_danqingzi);
        ImageButton imageButton56=findViewById(R.id.button_dingxiangdanzi);
        ImageButton imageButton57=findViewById(R.id.button_mabiancaozi);
        ImageButton imageButton58=findViewById(R.id.button_dantengluozi);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[0].colorName));
                imageView.setImageResource(R.drawable.purple_shenqianniuzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[1].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[1].colorName));
                imageView.setImageResource(R.drawable.purple_anlanzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[2].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[2].colorName));
                imageView.setImageResource(R.drawable.purple_anlongdanzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[3].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[3].colorName));
                imageView.setImageResource(R.drawable.purple_lizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[4].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[4].colorName));
                imageView.setImageResource(R.drawable.purple_moshizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[5].colorName));
                imageView.setImageResource(R.drawable.purple_qiepizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[6].colorName));
                imageView.setImageResource(R.drawable.purple_luanshizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[7].colorName));
                imageView.setImageResource(R.drawable.purple_mozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[8].colorName));
                imageView.setImageResource(R.drawable.purple_huoezi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[9].colorName));
                imageView.setImageResource(R.drawable.purple_biqizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[10].colorName));
                imageView.setImageResource(R.drawable.purple_ganzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[11].colorName));
                imageView.setImageResource(R.drawable.purple_gutongzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[12].colorName));
                imageView.setImageResource(R.drawable.purple_haixiangzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[13].colorName));
                imageView.setImageResource(R.drawable.purple_zhuganzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[14].colorName));
                imageView.setImageResource(R.drawable.purple_jiangzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[15].colorName));
                imageView.setImageResource(R.drawable.purple_putaozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[16].colorName));
                imageView.setImageResource(R.drawable.purple_jinyuzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[17].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[17].colorName));
                imageView.setImageResource(R.drawable.purple_anyuzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[18].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[18].colorName));
                imageView.setImageResource(R.drawable.purple_lizi_2);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[19].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[19].colorName));
                imageView.setImageResource(R.drawable.purple_putaojiangzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[20].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[20].colorName));
                imageView.setImageResource(R.drawable.purple_diaozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[21].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[21].colorName));
                imageView.setImageResource(R.drawable.purple_shizhuzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[22].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[22].colorName));
                imageView.setImageResource(R.drawable.purple_ganzhezi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[23].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[23].colorName));
                imageView.setImageResource(R.drawable.purple_yaoguanzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[24].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[24].colorName));
                imageView.setImageResource(R.drawable.purple_jingshizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[25].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[25].colorName));
                imageView.setImageResource(R.drawable.purple_longkuizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[26].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[26].colorName));
                imageView.setImageResource(R.drawable.purple_longqingyuzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[27].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[27].colorName));
                imageView.setImageResource(R.drawable.purple_yeputaozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[28].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[28].colorName));
                imageView.setImageResource(R.drawable.purple_jianfengzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[29].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[29].colorName));
                imageView.setImageResource(R.drawable.purple_mantianxingzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[30].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[30].colorName));
                imageView.setImageResource(R.drawable.purple_qianniuzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[31].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[31].colorName));
                imageView.setImageResource(R.drawable.purple_caitouzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[32].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[32].colorName));
                imageView.setImageResource(R.drawable.purple_weizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[33].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[33].colorName));
                imageView.setImageResource(R.drawable.purple_gejinzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[34].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[34].colorName));
                imageView.setImageResource(R.drawable.purple_qinglianzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[35].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[35].colorName));
                imageView.setImageResource(R.drawable.purple_xiancaizi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[36].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[36].colorName));
                imageView.setImageResource(R.drawable.purple_yejvzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[37].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[37].colorName));
                imageView.setImageResource(R.drawable.purple_jiegengzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[38].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[38].colorName));
                imageView.setImageResource(R.drawable.purple_jiehuazi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[39].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[39].colorName));
                imageView.setImageResource(R.drawable.purple_yangcongzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[40].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[40].colorName));
                imageView.setImageResource(R.drawable.purple_shangengzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[41].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[41].colorName));
                imageView.setImageResource(R.drawable.purple_jinzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[42].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[42].colorName));
                imageView.setImageResource(R.drawable.purple_xunzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[43].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[43].colorName));
                imageView.setImageResource(R.drawable.purple_luodianzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[44].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[44].colorName));
                imageView.setImageResource(R.drawable.purple_tengluozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[45].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[45].colorName));
                imageView.setImageResource(R.drawable.purple_biandouzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[46].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[46].colorName));
                imageView.setImageResource(R.drawable.purple_doukouzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[47].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[47].colorName));
                imageView.setImageResource(R.drawable.purple_yingcaozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[48].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[48].colorName));
                imageView.setImageResource(R.drawable.purple_qinggekezi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[49].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[49].colorName));
                imageView.setImageResource(R.drawable.purple_luolanzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[50].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[50].colorName));
                imageView.setImageResource(R.drawable.purple_danlanzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[51].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[51].colorName));
                imageView.setImageResource(R.drawable.purple_fengxinzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[52].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[52].colorName));
                imageView.setImageResource(R.drawable.purple_danqianniuzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[53].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[53].colorName));
                imageView.setImageResource(R.drawable.purple_yuanshanzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[54].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[54].colorName));
                imageView.setImageResource(R.drawable.purple_danqingzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[55].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[55].colorName));
                imageView.setImageResource(R.drawable.purple_dingxiangdanzi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[56].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[56].colorName));
                imageView.setImageResource(R.drawable.purple_mabiancaozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(PurpleColors[57].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(PurpleColors[57].colorName));
                imageView.setImageResource(R.drawable.purple_dantengluozi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        findViewById(R.id.ic_more).setOnClickListener(v -> BottomMenu.show(new String[]{"红", "黄","棕", "蓝", "绿", "茶", "水蓝", "紫", "黑白灰"})
                .setMessage("请选择色系")
                .setOnMenuItemClickListener((dialog, text, index) -> {
                    Intent intent = new Intent();
                    if ("红".equals(text)) intent.setClass(this, SekaRed.class);
                    if ("黄".equals(text)) intent.setClass(this, SekaYellow.class);
                    if ("蓝".equals(text)) intent.setClass(this, SekaBlue.class);
                    if ("绿".equals(text)) intent.setClass(this, SekaGreen.class);
                    if ("茶".equals(text)) intent.setClass(this, SekaTea.class);
                    if ("水蓝".equals(text)) intent.setClass(this, SekaAqua.class);
                    if ("紫".equals(text)) intent.setClass(this, SekaPurple.class);
                    if ("黑白灰".equals(text)) intent.setClass(this, SekaBlack.class);
                    if ("棕".equals(text)) intent.setClass(this, SekaZong.class);
                    startActivity(intent);
                    finish();
                    return false;
                }));
    }
}