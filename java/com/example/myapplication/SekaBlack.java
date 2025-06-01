package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialogx.dialogs.BottomMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SekaBlack extends AppCompatActivity {

    public class BlackColor {
        private int imageId;
        private String colorName;

        public BlackColor(int ImageId,String ColorName) {
            this.imageId = ImageId;
            this.colorName=ColorName;
        }

        public int getImageId() {
            return imageId;
        }
    }
    private List<BlackColor> blackColorList1 = new ArrayList<>();
    private List<BlackColor> blackColorList2 = new ArrayList<>();
    private LinearLayout toolbar1;

    private BlackColor[] blackColors={
            new BlackColor(R.drawable.black_cangyinghui,"#36282b"),
            new BlackColor(R.drawable.black_gudinghui,"#36292f"),
            new BlackColor(R.drawable.black_changshihui,"#363433"),
            new BlackColor(R.drawable.black_hetunhui,"#393733"),
            new BlackColor(R.drawable.black_shuiniuhui,"#2f2f35"),
            new BlackColor(R.drawable.black_niujiaohui,"#2d2e36"),
            new BlackColor(R.drawable.black_dansongyan,"#4d4030"),
            new BlackColor(R.drawable.black_hehui,"#4a4035"),
            new BlackColor(R.drawable.black_haibaohui,"#483332"),
            new BlackColor(R.drawable.black_meiguihui,"#4b2e2b"),
            new BlackColor(R.drawable.black_muyunhui,"#4f383e"),
            new BlackColor(R.drawable.black_songshuhui,"#4f4032"),
            new BlackColor(R.drawable.black_ganlanhui,"#503e2a"),
            new BlackColor(R.drawable.black_dantiehui,"#5b423a"),
            new BlackColor(R.drawable.black_qinghui,"#2b333e"),
            new BlackColor(R.drawable.black_zihui,"#5d3f51"),
            new BlackColor(R.drawable.black_zhumuhui,"#64483d"),
            new BlackColor(R.drawable.black_shibanhui,"#624941"),
            new BlackColor(R.drawable.black_waguanhui,"#47484c"),
            new BlackColor(R.drawable.black_huanghunhui,"#474b4c"),
            new BlackColor(R.drawable.black_xiekehui,"#695e45"),
            new BlackColor(R.drawable.black_yuweihui,"#51616d"),
            new BlackColor(R.drawable.black_zhanjianhui,"#495c69"),
            new BlackColor(R.drawable.black_jingyuhui,"#475164"),
            new BlackColor(R.drawable.black_shubeihui,"#73575c"),
            new BlackColor(R.drawable.black_zhonghonghui,"#8b614d"),
            new BlackColor(R.drawable.black_wahui,"#867e76"),
            new BlackColor(R.drawable.black_luhui,"#856d72"),
            new BlackColor(R.drawable.black_yanyuhui,"#685e48"),
            new BlackColor(R.drawable.black_shenhui,"#81776e"),
            new BlackColor(R.drawable.black_xinhui,"#7a7374"),
            new BlackColor(R.drawable.black_yehui,"#847c74"),
            new BlackColor(R.drawable.black_yanhui,"#80766e"),
            new BlackColor(R.drawable.black_lvhui,"#314a43"),
            new BlackColor(R.drawable.black_xiayunhui,"#617172"),
            new BlackColor(R.drawable.black_ehui,"#737c7b"),
            new BlackColor(R.drawable.black_danlvhui,"#70887d"),
            new BlackColor(R.drawable.black_nenhui,"#74787a"),
            new BlackColor(R.drawable.black_niehui,"#9fa39a"),
            new BlackColor(R.drawable.black_danlanhui,"#5e7987"),
            new BlackColor(R.drawable.black_haiouhui,"#9a8878"),
            new BlackColor(R.drawable.black_yinhui,"#918072"),
            new BlackColor(R.drawable.black_houmaohui,"#97846c"),
            new BlackColor(R.drawable.black_danmeiguihui,"#b89485"),
            new BlackColor(R.drawable.black_zhuwanghui,"#b7a091"),
            new BlackColor(R.drawable.black_danyinhui,"#c1b2a3"),
            new BlackColor(R.drawable.black_zhonghui,"#bbb5ac"),
            new BlackColor(R.drawable.black_chenhui,"#b6a476"),
            new BlackColor(R.drawable.black_yinshuhui,"#b5aa90"),
            new BlackColor(R.drawable.black_bailingniaohui,"#b4a992"),
            new BlackColor(R.drawable.black_yinhonghui,"#b598a1"),
            new BlackColor(R.drawable.black_minghui,"#8a988e"),
            new BlackColor(R.drawable.black_lusuihui,"#bdaead"),
            new BlackColor(R.drawable.black_xiaohui,"#d4c4b7"),
            new BlackColor(R.drawable.black_qianhui,"#dad4cb"),
            new BlackColor(R.drawable.black_qianhui_2,"#bbb5ac"),
            new BlackColor(R.drawable.black_manaohui,"#cfccc9"),
            new BlackColor(R.drawable.black_yuehui,"#b7ae8f"),
            new BlackColor(R.drawable.black_xinghui,"#b2bbbe"),
            new BlackColor(R.drawable.black_yueyingbai,"#c0c4c3"),
            new BlackColor(R.drawable.black_dalishihui,"#c4cbcf"),
            new BlackColor(R.drawable.black_qionghui,"#c4d7d6"),
            new BlackColor(R.drawable.black_yinyubai,"#cdd1d3"),
            new BlackColor(R.drawable.black_shubihong,"#e3b4b8"),
            new BlackColor(R.drawable.black_lianzibai,"#e5d3aa"),
            new BlackColor(R.drawable.black_zhenzhuhui,"#e4dfd7"),
            new BlackColor(R.drawable.black_juleibai,"#e9ddb6"),
            new BlackColor(R.drawable.black_liroubai,"#f2e6ce"),
            new BlackColor(R.drawable.black_hehuabai,"#fbecde"),
            new BlackColor(R.drawable.black_rubai,"#f9f4dc"),
            new BlackColor(R.drawable.black_bangroubai,"#f9f1db"),
            new BlackColor(R.drawable.black_yunfengbai,"#d8e3e7"),
            new BlackColor(R.drawable.black_qianshibai,"#e2e1e4"),
            new BlackColor(R.drawable.black_fenbai,"#fbf2e3"),
            new BlackColor(R.drawable.black_yuebai,"#eef7f2"),
            new BlackColor(R.drawable.black_yinbai,"#f1f0ed"),
            new BlackColor(R.drawable.black_hanbaiyu,"#f8f4ed"),
            new BlackColor(R.drawable.black_yudubai,"#f7f4ed"),



    };


    private void initBlackCard1() {
        blackColorList1.clear();
        for (int i = 0; i <78; i+=2) {
        blackColorList1.add(blackColors[i]);
        CardView cardView = findViewById(R.id.blue_cardview);
        int finalI = i;
        cardView.setOnClickListener(v -> {
            // 处理点击事件的逻辑
            int color = Color.parseColor(blackColors[finalI].colorName);
            toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
        });
    }
}


    private void initBlackCard2() {
        blackColorList2.clear();
        for (int i = 1; i < 78; i += 2) {
            blackColorList2.add(blackColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(blackColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }


    String[] shiju = new String[]{"墨染锦年,物是人非","潜洞黝无底,殊庭忽似梦","我欲折繻留此老,缁衣谁作好贤诗","俄顷风定云墨色,秋天漠漠向昏黑","短檠油尽固自佳,坐守一窗如漆黑","青苍犹可濯,黑色不可移","燎沉香,消溽暑鸟雀呼晴,侵晓窥檐语","才近中秋月已清,鸦青幕挂一团冰","末路益可羞,朱墨手自研","玄天黄露真颜色,金步摇中颤舞娃","长安侠客矜年少,青骊缓步章台道","天地玄黄,宇宙洪荒","妩媚不烦螺子黛,春山画出自精神","玄天共悠久,碧海比灵长","沉香断续玉炉寒,伴我情怀如水","乌帽背斜晖,青骊踏春草","我马玄黄盼日曛,关河不窘故将军","沉香亭北倚阑干,缓歌慢舞凝丝竹",
            "小抹淡随寒露立,半横细入浅云笺","自言其中有至乐,适意无异逍遥游","如醴沾衣白,凝脂夜间红","琼笙每应秋生起,缟羽微连夜色明","更于洗滑凝脂处,尚忆胡儿在锦绷","纱袍颜色米汤娇,褂面洋毡胜紫貂","青鸾不独去,更有携手人","玉条脱下渠凝脂,金叵罗中酌琼液","手如柔夷,肤如凝脂","天球大贝在高阁,贝之使我惭轻薄","云峰吐月白,石壁淡烟红","梨花淡白柳深青,柳絮飞时花满城","春寒赐浴华清池,温泉水滑洗凝脂","黄昏月下惆怅白,清明雨后寥梢红","帘幕阴阴昼漏迟,鹅黄雪白络新丝",
            "满面尘灰烟火色,两鬓苍苍十指黑","花迎月魄若为容,月转东墙花影重","玄云抱石雷雨垂,苍山夹水龙蛇绕","飘缟羽于清霄,拟妙姿于白雪","头安金步摇,耳系明月珰","依然院落溶溶月,怅绝星辰昨夜风","名父平生淹簿领,佳儿他日绍衣冠","雨霜地如雪,松桂青参差","天穹隆而周乎下,地旁薄而向乎上","圣铁含灰古,焦铜带血新","风定葭灰细,阳微灏气清"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_black);

        toolbar1 = findViewById(R.id.toolbar_photo);

        ImageView imageView = findViewById(R.id.black_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaBlack.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout view = findViewById(R.id.picture);
        ImageButton imageButton1 = findViewById(R.id.button_cangyinghui);
        ImageButton imageButton2 = findViewById(R.id.button_gudinghui);
        ImageButton imageButton3 = findViewById(R.id.button_changshihui);
        ImageButton imageButton4 = findViewById(R.id.button_hetunhui);
        ImageButton imageButton5 = findViewById(R.id.button_shuiniuhui);
        ImageButton imageButton6 = findViewById(R.id.button_niujiaohui);
        ImageButton imageButton7 = findViewById(R.id.button_dansongyan);
        ImageButton imageButton8 = findViewById(R.id.button_hehui);
        ImageButton imageButton9 = findViewById(R.id.button_haibaohui);
        ImageButton imageButton10 = findViewById(R.id.button_meiguihui);
        ImageButton imageButton11 = findViewById(R.id.button_muyunhui);
        ImageButton imageButton12 = findViewById(R.id.button_songshuhui);
        ImageButton imageButton13 = findViewById(R.id.button_ganlanhui);
        ImageButton imageButton14 = findViewById(R.id.button_dantiehui);
        ImageButton imageButton15 = findViewById(R.id.button_qinghui);
        ImageButton imageButton16 = findViewById(R.id.button_zihui);
        ImageButton imageButton17 = findViewById(R.id.button_zhumuhui);
        ImageButton imageButton18 = findViewById(R.id.button_shibanhui);
        ImageButton imageButton19 = findViewById(R.id.button_waguanhui);
        ImageButton imageButton20 = findViewById(R.id.button_huanghunhui);
        ImageButton imageButton21 = findViewById(R.id.button_xiekehui);
        ImageButton imageButton22 = findViewById(R.id.button_yuweihui);
        ImageButton imageButton23 = findViewById(R.id.button_zhanjianhui);
        ImageButton imageButton24 = findViewById(R.id.button_jingyuhui);
        ImageButton imageButton25 = findViewById(R.id.button_shubeihui);
        ImageButton imageButton26 = findViewById(R.id.button_zhonghonghui);
        ImageButton imageButton27 = findViewById(R.id.button_wahui);
        ImageButton imageButton28 = findViewById(R.id.button_luhui);
        ImageButton imageButton29 = findViewById(R.id.button_yanyuhui);
        ImageButton imageButton30 = findViewById(R.id.button_shenhui);
        ImageButton imageButton31 = findViewById(R.id.button_xinhui);
        ImageButton imageButton32 = findViewById(R.id.button_yehui);
        ImageButton imageButton33 = findViewById(R.id.button_yanhui);
        ImageButton imageButton34 = findViewById(R.id.button_lvhui);
        ImageButton imageButton35 = findViewById(R.id.button_xiayunhui);
        ImageButton imageButton36 = findViewById(R.id.button_ehui);
        ImageButton imageButton37 = findViewById(R.id.button_danlvhui);
        ImageButton imageButton38 = findViewById(R.id.button_nenhui);
        ImageButton imageButton39 = findViewById(R.id.button_niehui);
        ImageButton imageButton40 = findViewById(R.id.button_danlanhui);
        ImageButton imageButton41 = findViewById(R.id.button_haiouhui);
        ImageButton imageButton42 = findViewById(R.id.button_yinhui);
        ImageButton imageButton43 = findViewById(R.id.button_houmaohui);
        ImageButton imageButton44 = findViewById(R.id.button_danmeiguihui);
        ImageButton imageButton45 = findViewById(R.id.button_zhuwanghui);
        ImageButton imageButton46 = findViewById(R.id.button_danyinhui);
        ImageButton imageButton47 = findViewById(R.id.button_zhonghui);
        ImageButton imageButton48 = findViewById(R.id.button_chenhui);
        ImageButton imageButton49 = findViewById(R.id.button_yinshuihui);
        ImageButton imageButton50 = findViewById(R.id.button_bailingniaohui);
        ImageButton imageButton51 = findViewById(R.id.button_yinhonghui);
        ImageButton imageButton52 = findViewById(R.id.button_minghui);
        ImageButton imageButton53 = findViewById(R.id.button_lusuihui);
        ImageButton imageButton54 = findViewById(R.id.button_xiaohui);
        ImageButton imageButton55 = findViewById(R.id.button_qianhui);
        ImageButton imageButton56 = findViewById(R.id.button_qianhui_2);
        ImageButton imageButton57 = findViewById(R.id.button_manaohui);
        ImageButton imageButton58 = findViewById(R.id.button_yuehui);
        ImageButton imageButton59 = findViewById(R.id.button_xinghui);
        ImageButton imageButton60 = findViewById(R.id.button_yueyingbai);
        ImageButton imageButton61 = findViewById(R.id.button_dalishihui);
        ImageButton imageButton62 = findViewById(R.id.button_qionghui);
        ImageButton imageButton63 = findViewById(R.id.button_yinyubai);
        ImageButton imageButton64 = findViewById(R.id.button_shubihui);
        ImageButton imageButton65 = findViewById(R.id.button_lianzibai);
        ImageButton imageButton66 = findViewById(R.id.button_zhenzhuhui);
        ImageButton imageButton67 = findViewById(R.id.button_juleibai);
        ImageButton imageButton68 = findViewById(R.id.button_liroubai);
        ImageButton imageButton69 = findViewById(R.id.button_hehuabai);
        ImageButton imageButton70 = findViewById(R.id.button_rubai);
        ImageButton imageButton71 = findViewById(R.id.button_bangroubai);
        ImageButton imageButton72 = findViewById(R.id.button_yunfengbai);
        ImageButton imageButton73 = findViewById(R.id.button_qianshibai);
        ImageButton imageButton74 = findViewById(R.id.button_fenbai);
        ImageButton imageButton75 = findViewById(R.id.button_yuebai);
        ImageButton imageButton76 = findViewById(R.id.button_yinbai);
        ImageButton imageButton77 = findViewById(R.id.button_hanbaiyu);
        ImageButton imageButton78 = findViewById(R.id.button_yudubai);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[0].colorName));
                imageView.setImageResource(R.drawable.black_cangyinghui);
                TextView tShiju = findViewById(R.id.t_shiju);

                tShiju.setTextColor(Color.WHITE);
                float textSizeInDp = 20;
                float textSizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, textSizeInDp, getResources().getDisplayMetrics());
                tShiju.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeInPixels);

                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[1].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[1].colorName));
                imageView.setImageResource(R.drawable.black_gudinghui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[2].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[2].colorName));
                imageView.setImageResource(R.drawable.black_changshihui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[3].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[3].colorName));
                imageView.setImageResource(R.drawable.black_hetunhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[4].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[4].colorName));
                imageView.setImageResource(R.drawable.black_shuiniuhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }


        });imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[5].colorName));
                imageView.setImageResource(R.drawable.black_niujiaohui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[6].colorName));
                imageView.setImageResource(R.drawable.black_dansongyan);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[7].colorName));
                imageView.setImageResource(R.drawable.black_hehui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[8].colorName));
                imageView.setImageResource(R.drawable.black_haibaohui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[9].colorName));
                imageView.setImageResource(R.drawable.black_meiguihui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[10].colorName));
                imageView.setImageResource(R.drawable.black_muyunhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[11].colorName));
                imageView.setImageResource(R.drawable.black_songshuhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[12].colorName));
                imageView.setImageResource(R.drawable.black_ganlanhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[13].colorName));
                imageView.setImageResource(R.drawable.black_dantiehui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[14].colorName));
                imageView.setImageResource(R.drawable.black_qinghui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[15].colorName));
                imageView.setImageResource(R.drawable.black_zihui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[16].colorName));
                imageView.setImageResource(R.drawable.black_zhumuhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[17].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[17].colorName));
                imageView.setImageResource(R.drawable.black_shibanhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[18].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[18].colorName));
                imageView.setImageResource(R.drawable.black_waguanhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[19].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[19].colorName));
                imageView.setImageResource(R.drawable.black_huanghunhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[20].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[20].colorName));
                imageView.setImageResource(R.drawable.black_xiekehui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[21].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[21].colorName));
                imageView.setImageResource(R.drawable.black_yuweihui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[22].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[22].colorName));
                imageView.setImageResource(R.drawable.black_zhanjianhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[23].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[23].colorName));
                imageView.setImageResource(R.drawable.black_jingyuhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[24].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[24].colorName));
                imageView.setImageResource(R.drawable.black_shubeihui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[25].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[25].colorName));
                imageView.setImageResource(R.drawable.black_zhonghonghui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[26].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[26].colorName));
                imageView.setImageResource(R.drawable.black_wahui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[27].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[27].colorName));
                imageView.setImageResource(R.drawable.black_luhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[28].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[28].colorName));
                imageView.setImageResource(R.drawable.black_yanyuhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[29].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[29].colorName));
                imageView.setImageResource(R.drawable.black_shenhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[30].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[30].colorName));
                imageView.setImageResource(R.drawable.black_xinhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[31].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[31].colorName));
                imageView.setImageResource(R.drawable.black_yehui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[32].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[32].colorName));
                imageView.setImageResource(R.drawable.black_yanhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[33].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[33].colorName));
                imageView.setImageResource(R.drawable.black_lvhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[34].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[34].colorName));
                imageView.setImageResource(R.drawable.black_xiayunhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[35].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[35].colorName));
                imageView.setImageResource(R.drawable.black_ehui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[36].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[36].colorName));
                imageView.setImageResource(R.drawable.black_danlvhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[37].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[37].colorName));
                imageView.setImageResource(R.drawable.black_nenhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[38].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[38].colorName));
                imageView.setImageResource(R.drawable.black_niehui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[39].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[39].colorName));
                imageView.setImageResource(R.drawable.black_danlanhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[40].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[40].colorName));
                imageView.setImageResource(R.drawable.black_haiouhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[41].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[41].colorName));
                imageView.setImageResource(R.drawable.black_yinhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[42].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[42].colorName));
                imageView.setImageResource(R.drawable.black_houmaohui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[43].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[43].colorName));
                imageView.setImageResource(R.drawable.black_danmeiguihui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[44].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[44].colorName));
                imageView.setImageResource(R.drawable.black_zhuwanghui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[45].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[45].colorName));
                imageView.setImageResource(R.drawable.black_danyinhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[46].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[46].colorName));
                imageView.setImageResource(R.drawable.black_zhonghui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[47].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[47].colorName));
                imageView.setImageResource(R.drawable.black_chenhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[48].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[48].colorName));
                imageView.setImageResource(R.drawable.black_yinshuhui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[49].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[49].colorName));
                imageView.setImageResource(R.drawable.black_bailingniaohui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[50].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[50].colorName));
                imageView.setImageResource(R.drawable.black_yinhonghui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[51].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[51].colorName));
                imageView.setImageResource(R.drawable.black_minghui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[52].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[52].colorName));
                imageView.setImageResource(R.drawable.black_lusuihui);
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
                view.setBackgroundColor(Color.parseColor(blackColors[53].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[53].colorName));
                imageView.setImageResource(R.drawable.black_xiaohui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[54].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[54].colorName));
                imageView.setImageResource(R.drawable.black_qianhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[55].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[55].colorName));
                imageView.setImageResource(R.drawable.black_qianhui_2);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[56].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[56].colorName));
                imageView.setImageResource(R.drawable.black_manaohui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[57].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[57].colorName));
                imageView.setImageResource(R.drawable.black_yuehui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[58].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[58].colorName));
                imageView.setImageResource(R.drawable.black_xinghui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[59].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[59].colorName));
                imageView.setImageResource(R.drawable.black_yueyingbai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[60].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[60].colorName));
                imageView.setImageResource(R.drawable.black_dalishihui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[61].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[61].colorName));
                imageView.setImageResource(R.drawable.black_qionghui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[62].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[62].colorName));
                imageView.setImageResource(R.drawable.black_yinyubai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[63].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[63].colorName));
                imageView.setImageResource(R.drawable.black_shubihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[64].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[64].colorName));
                imageView.setImageResource(R.drawable.black_lianzibai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[65].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[65].colorName));
                imageView.setImageResource(R.drawable.black_zhenzhuhui);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[66].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[66].colorName));
                imageView.setImageResource(R.drawable.black_juleibai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[67].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[67].colorName));
                imageView.setImageResource(R.drawable.black_liroubai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton69.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[68].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[68].colorName));
                imageView.setImageResource(R.drawable.black_hehuabai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[69].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[69].colorName));
                imageView.setImageResource(R.drawable.black_rubai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[70].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[70].colorName));
                imageView.setImageResource(R.drawable.black_bangroubai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[71].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[71].colorName));
                imageView.setImageResource(R.drawable.black_yunfengbai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[72].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[72].colorName));
                imageView.setImageResource(R.drawable.black_qianshibai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[73].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[73].colorName));
                imageView.setImageResource(R.drawable.black_fenbai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[74].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[74].colorName));
                imageView.setImageResource(R.drawable.black_yuebai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[75].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[75].colorName));
                imageView.setImageResource(R.drawable.black_yinbai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[76].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[76].colorName));
                imageView.setImageResource(R.drawable.black_hanbaiyu);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blackColors[77].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blackColors[77].colorName));
                imageView.setImageResource(R.drawable.black_yudubai);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        findViewById(R.id.ic_more).setOnClickListener(v -> BottomMenu.show(new String[]{"红", "黄", "棕","蓝", "绿", "茶", "水蓝", "紫", "黑白灰"})
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