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

public class SekaYellow extends AppCompatActivity {

    public class YellowColor {
        private int imageId;
        private String colorName;

        public YellowColor(int ImageId,String ColorName) {
            this.imageId = ImageId;
            this.colorName=ColorName;
        }

        public int getImageId() {
            return imageId;
        }
    }
    private List<YellowColor> yellowColorList1 = new ArrayList<>();
    private List<YellowColor> yellowColorList2 = new ArrayList<>();
    private LinearLayout toolbar1;

    private YellowColor[] yellowColors= {
            new YellowColor(R.drawable.yellow_dantuhuang, "#8c4b31"),
            new YellowColor(R.drawable.yellow_laiyanglihuang, "#815f25"),
            new YellowColor(R.drawable.yellow_canghuang, "#806332"),
            new YellowColor(R.drawable.yellow_guibeihuang, "#826b48"),
            new YellowColor(R.drawable.yellow_tiezong, "#d85916"),
            new YellowColor(R.drawable.yellow_jintuo, "#e46828"),
            new YellowColor(R.drawable.yellow_jinhuang, "#f26b1f"),
            new YellowColor(R.drawable.yellow_jinlianhuacheng, "#f86b1d"),
            new YellowColor(R.drawable.yellow_shanjihuang, "#b78b26"),
            new YellowColor(R.drawable.yellow_jvcheng, "#f97d1c"),
            new YellowColor(R.drawable.yellow_meirenjiaocheng, "#fa7e23"),
            new YellowColor(R.drawable.yellow_wanshoujiuhuang, "#fb8b05"),
            new YellowColor(R.drawable.yellow_beiguahuang, "#fc8c23"),
            new YellowColor(R.drawable.yellow_zuiguarou, "#db8540"),
            new YellowColor(R.drawable.yellow_fengfanhuang, "#dc9123"),
            new YellowColor(R.drawable.yellow_xinghuang, "#f28e16"),
            new YellowColor(R.drawable.yellow_xionghuang, "#ff9900"),
            new YellowColor(R.drawable.yellow_tuhuang, "#d6a01d"),
            new YellowColor(R.drawable.yellow_jiehuang, "#d9a40e"),
            new YellowColor(R.drawable.yellow_shashihuang, "#e5b751"),
            new YellowColor(R.drawable.yellow_ruanmuhuang, "#de9e44"),
            new YellowColor(R.drawable.yellow_daimaohuang, "#daa45a"),
            new YellowColor(R.drawable.yellow_chengpihuang, "#fca104"),
            new YellowColor(R.drawable.yellow_pipahuang, "#fca106"),
            new YellowColor(R.drawable.yellow_danjvcheng, "#fba414"),
            new YellowColor(R.drawable.yellow_jinyinghuang, "#f4a83a"),
            new YellowColor(R.drawable.yellow_jinyehuang, "#ffa60f"),
            new YellowColor(R.drawable.yellow_hailuocheng, "#f0945d"),
            new YellowColor(R.drawable.yellow_liuehuang, "#f9a633"),
            new YellowColor(R.drawable.yellow_caohuang, "#d2b42c"),
            new YellowColor(R.drawable.yellow_zhizihuang, "#ebb10d"),
            new YellowColor(R.drawable.yellow_guhuang, "#e8b004"),
            new YellowColor(R.drawable.yellow_hupihuang, "#eaad1a"),
            new YellowColor(R.drawable.yellow_jianghuang, "#e2c027"),
            new YellowColor(R.drawable.yellow_xiangjiaohuang, "#e4bf11"),
            new YellowColor(R.drawable.yellow_youhuang_2, "#fcb70a"),
            new YellowColor(R.drawable.yellow_haohuang, "#dfc243"),
            new YellowColor(R.drawable.yellow_hupohuang, "#feba07"),
            new YellowColor(R.drawable.yellow_ezhanghuang, "#fbb929"),
            new YellowColor(R.drawable.yellow_jidanhuang, "#fbb612"),
            new YellowColor(R.drawable.yellow_chushuxinghuang, "#f8bc31"),
            new YellowColor(R.drawable.yellow_muguahuang, "#f9c116"),
            new YellowColor(R.drawable.yellow_qianlaohuang, "#f9bd10"),
            new YellowColor(R.drawable.yellow_jinzhanhuang, "#fcc307"),
            new YellowColor(R.drawable.yellow_youhuang, "#f1ca17"),
            new YellowColor(R.drawable.yellow_ruyahuang, "#ffc90c"),
            new YellowColor(R.drawable.yellow_xiangrikuihuang, "#fecc11"),
            new YellowColor(R.drawable.yellow_yingwuguanhuang, "#f6c430"),
            new YellowColor(R.drawable.yellow_gancaohuang, "#f3bf4c"),
            new YellowColor(R.drawable.yellow_huanglianhuang, "#fcc515"),
            new YellowColor(R.drawable.yellow_mihuang, "#fbb957"),
            new YellowColor(R.drawable.yellow_yalihuang, "#fbc82f"),
            new YellowColor(R.drawable.yellow_suxinhuang, "#fccb16"),
            new YellowColor(R.drawable.yellow_liuhuahuang, "#f2ce2b"),
            new YellowColor(R.drawable.yellow_tenghuang, "#ffd111"),
            new YellowColor(R.drawable.yellow_jinguahuang, "#fcd217"),
            new YellowColor(R.drawable.yellow_qiukuihuang, "#eed045"),
            new YellowColor(R.drawable.yellow_dadouhuang, "#fbcd31"),
            new YellowColor(R.drawable.yellow_ningmenghuang, "#fcd337"),
            new YellowColor(R.drawable.yellow_mangguohuang, "#ddc871"),
            new YellowColor(R.drawable.yellow_foshouhuang, "#fed71a"),
            new YellowColor(R.drawable.yellow_diehuang, "#e2d849"),
            new YellowColor(R.drawable.yellow_meiguifen, "#f8b37f"),
            new YellowColor(R.drawable.yellow_youcaihuahuang, "#fbda41"),
            new YellowColor(R.drawable.yellow_rouse, "#f7c173"),
            new YellowColor(R.drawable.yellow_dankehuang, "#f8c387"),
            new YellowColor(R.drawable.yellow_chaomihuang, "#f4ce69"),
            new YellowColor(R.drawable.yellow_kuishanhuang, "#f8d86a"),
            new YellowColor(R.drawable.yellow_maiyatanghuang, "#f9d27d"),
            new YellowColor(R.drawable.yellow_danmihuang, "#f9d367"),
            new YellowColor(R.drawable.yellow_danjianhuang, "#f9d770"),
            new YellowColor(R.drawable.yellow_maiganhuang, "#f8df70"),
            new YellowColor(R.drawable.yellow_molihuang, "#f8df72"),
            new YellowColor(R.drawable.yellow_yaohuang, "#d0deaa"),
            new YellowColor(R.drawable.yellow_xiangyahuang, "#f0d695"),
            new YellowColor(R.drawable.yellow_xiangshuimeigui, "#f7da94"),
            new YellowColor(R.drawable.yellow_miehuang, "#f7de98"),
            new YellowColor(R.drawable.yellow_laohuang, "#f6dead"),
            new YellowColor(R.drawable.yellow_danrouse, "#f8e0b0"),
            new YellowColor(R.drawable.yellow_xingrenhuang, "#f7e8aa"),
            new YellowColor(R.drawable.yellow_mise, "#f9e9cd"),
            new YellowColor(R.drawable.yellow_douzhihuang, "#f8e8c1"),



    };


    private void initYellowCard1() {
        yellowColorList1.clear();
        for (int i = 0; i <77; i+=2) {
            yellowColorList1.add(yellowColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(yellowColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }


    private void initBlackCard2() {
        yellowColorList2.clear();
        for (int i = 1; i < 77; i += 2) {
            yellowColorList2.add(yellowColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(yellowColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    String[] shiju = new String[]{"兰陵美酒郁金香,玉碗盛来琥珀光","梅子金黄杏子肥,麦花雪白菜花稀","爱著鹅黄金缕衣,啼妆更为谁","为我取黄封,亲拆管泥赤","携来当昼不得卧,一府传看黄琉璃","轻如松花落金粉,浓似苔锦含碧滋","黄疸隙地欠栽接,蕉荔杂黄丹","画栏桂树悬秋香,三十六宫土花碧","缃叶隐朱实,累累楚江澨","染上鞠衣宫样浅,练裙缟帨觉无华","雄黄出穴百虫伏,牡丹压阑群卉惭","郁金半见湘白,缥缤绿纨皂紫珽","琮玉温姿轻拂拂,鞠衣嘉色宛飘飘","离亭月影斜,东方亮也","指嶓冢之西隈兮,与纁黄以为期","撮茎草作翳睛药,锻黄丹成绕指金","半见离宫出,才分远水明","菖蒲叶绿艾叶肥,雄黄醉酒城乡市","牛蹄走脱东方亮,赤日柴门高一丈","自看和酿一依方,缘看松花色较黄"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_yellow);


        toolbar1 = findViewById(R.id.toolbar_photo);


        ImageView imageView=findViewById(R.id.yellow_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaYellow.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout view =findViewById(R.id.picture);

        ImageButton imageButton1=findViewById(R.id.button_dantuhuang);
        ImageButton imageButton2=findViewById(R.id.button_laiyanglihuang);
        ImageButton imageButton3=findViewById(R.id.button_canghuang);
        ImageButton imageButton4=findViewById(R.id.button_guibeihuang);
        ImageButton imageButton6=findViewById(R.id.button_jintuo);
        ImageButton imageButton7=findViewById(R.id.button_jinhuang);
        ImageButton imageButton8=findViewById(R.id.button_jinlianhuacheng);
        ImageButton imageButton9=findViewById(R.id.button_shanjihuang);
        ImageButton imageButton10=findViewById(R.id.button_jucheng);
        ImageButton imageButton11=findViewById(R.id.button_meirenjiaocheng);
        ImageButton imageButton12=findViewById(R.id.button_wanshoujuhuang);
        ImageButton imageButton13=findViewById(R.id.button_beiguahuang);
        ImageButton imageButton14=findViewById(R.id.button_zuiguarou);
        ImageButton imageButton15=findViewById(R.id.button_fengfanhuang);
        ImageButton imageButton16=findViewById(R.id.button_xinghuang);
        ImageButton imageButton17=findViewById(R.id.button_xionghuang);
        ImageButton imageButton18=findViewById(R.id.button_tuhuang);
        ImageButton imageButton19=findViewById(R.id.button_jiehuang);
        ImageButton imageButton20=findViewById(R.id.button_shashihuang);
        ImageButton imageButton21=findViewById(R.id.button_ruanmuhuang);
        ImageButton imageButton22=findViewById(R.id.button_daimaohuang);
        ImageButton imageButton23=findViewById(R.id.button_chengpihuang);
        ImageButton imageButton24=findViewById(R.id.button_pipahuang);
        ImageButton imageButton25=findViewById(R.id.button_danjucheng);
        ImageButton imageButton26=findViewById(R.id.button_jinyinghuang);
        ImageButton imageButton27=findViewById(R.id.button_jinyehuang);
        ImageButton imageButton28=findViewById(R.id.button_hailuocheng);
        ImageButton imageButton29=findViewById(R.id.button_liuehuang);
        ImageButton imageButton30=findViewById(R.id.button_caohuang);
        ImageButton imageButton31=findViewById(R.id.button_zhizihuang);
        ImageButton imageButton32=findViewById(R.id.button_guhuang);
        ImageButton imageButton33=findViewById(R.id.button_hupihuang);
        ImageButton imageButton34=findViewById(R.id.button_jianghuang);
        ImageButton imageButton35=findViewById(R.id.button_xiangjiaohuang);
        ImageButton imageButton36=findViewById(R.id.button_youhuang_2);
        ImageButton imageButton37=findViewById(R.id.button_haohuang);
        ImageButton imageButton38=findViewById(R.id.button_hupohuang);
        ImageButton imageButton39=findViewById(R.id.button_ezhanghuang);
        ImageButton imageButton40=findViewById(R.id.button_jidanhuang);
        ImageButton imageButton41=findViewById(R.id.button_chushuxinghuang);
        ImageButton imageButton42=findViewById(R.id.button_muguahuang);
        ImageButton imageButton43=findViewById(R.id.button_qianlaohuang);
        ImageButton imageButton44=findViewById(R.id.button_jinzhanhuang);
        ImageButton imageButton45=findViewById(R.id.button_youhuang);
        ImageButton imageButton46=findViewById(R.id.button_ruyahuang);
        ImageButton imageButton47=findViewById(R.id.button_xiangrikuihuang);
        ImageButton imageButton48=findViewById(R.id.button_yingwuhuang);
        ImageButton imageButton49=findViewById(R.id.button_gancaohuang);
        ImageButton imageButton50=findViewById(R.id.button_huanglianhuang);
        ImageButton imageButton51=findViewById(R.id.button_mihuang);
        ImageButton imageButton52=findViewById(R.id.button_yalihuang);
        ImageButton imageButton53=findViewById(R.id.button_suxinhuang);
        ImageButton imageButton54=findViewById(R.id.button_liuhuahuang);
        ImageButton imageButton55=findViewById(R.id.button_tenghuang);
        ImageButton imageButton56=findViewById(R.id.button_jinguahuang);
        ImageButton imageButton57=findViewById(R.id.button_qiukuihuang);
        ImageButton imageButton58=findViewById(R.id.button_dadouhuang);
        ImageButton imageButton59=findViewById(R.id.button_ningmenghuang);
        ImageButton imageButton60=findViewById(R.id.button_mangguohuang);
        ImageButton imageButton61=findViewById(R.id.button_foshouhuang);
        ImageButton imageButton62=findViewById(R.id.button_diehuang);
        ImageButton imageButton63=findViewById(R.id.button_meiguifen);
        ImageButton imageButton64=findViewById(R.id.button_youcaihuahuang);
        ImageButton imageButton65=findViewById(R.id.button_rouse);
        ImageButton imageButton66=findViewById(R.id.button_dankehuang);
        ImageButton imageButton67=findViewById(R.id.button_chaomihuang);
        ImageButton imageButton68=findViewById(R.id.button_kuishanhuang);
        ImageButton imageButton69=findViewById(R.id.button_maiyatanghuang);
        ImageButton imageButton70=findViewById(R.id.button_danmihuang);
        ImageButton imageButton71=findViewById(R.id.button_danjianhuang);
        ImageButton imageButton72=findViewById(R.id.button_maiganhuang);
        ImageButton imageButton73=findViewById(R.id.button_molihuang);
        ImageButton imageButton74=findViewById(R.id.button_yaohuang);
        ImageButton imageButton75=findViewById(R.id.button_xiangyahuang);
        ImageButton imageButton76=findViewById(R.id.button_xiangshuimeigui);
        ImageButton imageButton77=findViewById(R.id.button_miehuang);
        ImageButton imageButton78=findViewById(R.id.button_laohuang);
        ImageButton imageButton79=findViewById(R.id.button_danrouse);
        ImageButton imageButton80=findViewById(R.id.button_xingrenhuang);
        ImageButton imageButton81=findViewById(R.id.button_mise);
        ImageButton imageButton82=findViewById(R.id.button_douzhihuang);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[0].colorName));
                imageView.setImageResource(R.drawable.yellow_dantuhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[1].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[1].colorName));
                imageView.setImageResource(R.drawable.yellow_laiyanglihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[2].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[2].colorName));
                imageView.setImageResource(R.drawable.yellow_canghuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[3].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[3].colorName));
                imageView.setImageResource(R.drawable.yellow_guibeihuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });



        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[5].colorName));
                imageView.setImageResource(R.drawable.yellow_jintuo);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[6].colorName));
                imageView.setImageResource(R.drawable.yellow_jinhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[7].colorName));
                imageView.setImageResource(R.drawable.yellow_jinlianhuacheng);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[8].colorName));
                imageView.setImageResource(R.drawable.yellow_shanjihuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[9].colorName));
                imageView.setImageResource(R.drawable.yellow_jvcheng);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[10].colorName));
                imageView.setImageResource(R.drawable.yellow_meirenjiaocheng);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[11].colorName));
                imageView.setImageResource(R.drawable.yellow_wanshoujiuhuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[12].colorName));
                imageView.setImageResource(R.drawable.yellow_beiguahuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[13].colorName));
                imageView.setImageResource(R.drawable.yellow_zuiguarou);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[14].colorName));
                imageView.setImageResource(R.drawable.yellow_fengfanhuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[15].colorName));
                imageView.setImageResource(R.drawable.yellow_xinghuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[16].colorName));
                imageView.setImageResource(R.drawable.yellow_xionghuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[17].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[17].colorName));
                imageView.setImageResource(R.drawable.yellow_tuhuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[18].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[18].colorName));
                imageView.setImageResource(R.drawable.yellow_jiehuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[19].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[19].colorName));
                imageView.setImageResource(R.drawable.yellow_shashihuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[20].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[20].colorName));
                imageView.setImageResource(R.drawable.yellow_ruanmuhuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[21].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[21].colorName));
                imageView.setImageResource(R.drawable.yellow_daimaohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });


        imageButton23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[22].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[22].colorName));
                imageView.setImageResource(R.drawable.yellow_chengpihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[23].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[23].colorName));
                imageView.setImageResource(R.drawable.yellow_pipahuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  24  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  24   ].colorName));
                imageView.setImageResource(R.drawable.yellow_danjvcheng);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  25  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  25   ].colorName));
                imageView.setImageResource(R.drawable.yellow_jinyinghuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  26  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  26   ].colorName));
                imageView.setImageResource(R.drawable.yellow_jinyehuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  27  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  27   ].colorName));
                imageView.setImageResource(R.drawable.yellow_hailuocheng);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  28  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  28   ].colorName));
                imageView.setImageResource(R.drawable.yellow_liuehuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  29  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  29   ].colorName));
                imageView.setImageResource(R.drawable.yellow_caohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  30  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  30   ].colorName));
                imageView.setImageResource(R.drawable.yellow_zhizihuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  31  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  31   ].colorName));
                imageView.setImageResource(R.drawable.yellow_guhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  32  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  32   ].colorName));
                imageView.setImageResource(R.drawable.yellow_hupihuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  33  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  33   ].colorName));
                imageView.setImageResource(R.drawable.yellow_jianghuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  34  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  34   ].colorName));
                imageView.setImageResource(R.drawable.yellow_xiangjiaohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  35  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  35   ].colorName));
                imageView.setImageResource(R.drawable.yellow_youhuang_2);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  36  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  36   ].colorName));
                imageView.setImageResource(R.drawable.yellow_haohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  37  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  37   ].colorName));
                imageView.setImageResource(R.drawable.yellow_hupohuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  38  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  38   ].colorName));
                imageView.setImageResource(R.drawable.yellow_ezhanghuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  39  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  39   ].colorName));
                imageView.setImageResource(R.drawable.yellow_jidanhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  40  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  40   ].colorName));
                imageView.setImageResource(R.drawable.yellow_chushuxinghuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  41  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  41   ].colorName));
                imageView.setImageResource(R.drawable.yellow_muguahuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  42  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  42   ].colorName));
                imageView.setImageResource(R.drawable.yellow_qianlaohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  43  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  43   ].colorName));
                imageView.setImageResource(R.drawable.yellow_jinzhanhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  44  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  44   ].colorName));
                imageView.setImageResource(R.drawable.yellow_youhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  45  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  45   ].colorName));
                imageView.setImageResource(R.drawable.yellow_ruyahuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  46  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  46   ].colorName));
                imageView.setImageResource(R.drawable.yellow_xiangrikuihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  47  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  47   ].colorName));
                imageView.setImageResource(R.drawable.yellow_yingwuguanhuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  48  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  48   ].colorName));
                imageView.setImageResource(R.drawable.yellow_gancaohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  49  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  49   ].colorName));
                imageView.setImageResource(R.drawable.yellow_huanglianhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  50  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  50   ].colorName));
                imageView.setImageResource(R.drawable.yellow_mihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  51  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  51   ].colorName));
                imageView.setImageResource(R.drawable.yellow_yalihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  52  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  52   ].colorName));
                imageView.setImageResource(R.drawable.yellow_suxinhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  53  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  53   ].colorName));
                imageView.setImageResource(R.drawable.yellow_liuhuahuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  54  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  54   ].colorName));
                imageView.setImageResource(R.drawable.yellow_tenghuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  55  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  55   ].colorName));
                imageView.setImageResource(R.drawable.yellow_jinguahuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  56  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  56   ].colorName));
                imageView.setImageResource(R.drawable.yellow_qiukuihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  57  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  57   ].colorName));
                imageView.setImageResource(R.drawable.yellow_dadouhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  58  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  58   ].colorName));
                imageView.setImageResource(R.drawable.yellow_ningmenghuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  59  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  59   ].colorName));
                imageView.setImageResource(R.drawable.yellow_mangguohuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  60  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  60   ].colorName));
                imageView.setImageResource(R.drawable.yellow_foshouhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  61  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  61   ].colorName));
                imageView.setImageResource(R.drawable.yellow_diehuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  62  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  62   ].colorName));
                imageView.setImageResource(R.drawable.yellow_meiguifen);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  63  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  63   ].colorName));
                imageView.setImageResource(R.drawable.yellow_youcaihuahuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  64  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  64   ].colorName));
                imageView.setImageResource(R.drawable.yellow_rouse);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  65  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[ 65   ].colorName));
                imageView.setImageResource(R.drawable.yellow_dankehuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  66  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  66   ].colorName));
                imageView.setImageResource(R.drawable.yellow_chaomihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  67  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  67   ].colorName));
                imageView.setImageResource(R.drawable.yellow_kuishanhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  68  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  68   ].colorName));
                imageView.setImageResource(R.drawable.yellow_maiyatanghuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  69  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  69   ].colorName));
                imageView.setImageResource(R.drawable.yellow_danmihuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  70  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  70   ].colorName));
                imageView.setImageResource(R.drawable.yellow_danjianhuang);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  71  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  71   ].colorName));
                imageView.setImageResource(R.drawable.yellow_maiganhuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  72  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  72   ].colorName));
                imageView.setImageResource(R.drawable.yellow_molihuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  73  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  73   ].colorName));
                imageView.setImageResource(R.drawable.yellow_yaohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  74  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  74  ].colorName));
                imageView.setImageResource(R.drawable.yellow_xiangyahuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  75  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  75   ].colorName));
                imageView.setImageResource(R.drawable.yellow_xiangshuimeigui);
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
                view.setBackgroundColor(Color.parseColor(yellowColors[  76  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[ 76   ].colorName));
                imageView.setImageResource(R.drawable.yellow_miehuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  77  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  77   ].colorName));
                imageView.setImageResource(R.drawable.yellow_laohuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  78  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  78   ].colorName));
                imageView.setImageResource(R.drawable.yellow_danrouse);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  79  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  79   ].colorName));
                imageView.setImageResource(R.drawable.yellow_xingrenhuang);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  80  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  80   ].colorName));
                imageView.setImageResource(R.drawable.yellow_mise);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(yellowColors[  81  ].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(yellowColors[  81  ].colorName));
                imageView.setImageResource(R.drawable.yellow_douzhihuang);
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