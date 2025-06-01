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

public class SekaGreen extends AppCompatActivity {

    public class GreenColor {
        private int imageId;
        private String colorName;

        public GreenColor(int ImageId,String ColorName) {
            this.imageId = ImageId;
            this.colorName=ColorName;
        }

        public int getImageId() {
            return imageId;
        }
    }

    private List<GreenColor> greenColorList1 = new ArrayList<>();
    private List<GreenColor> greenColorList2 = new ArrayList<>();
    private LinearLayout toolbar1;
    private GreenColor[] GreenColors= {
            new GreenColor(R.drawable.green_yunshanlv, "#15231b"),
            new GreenColor(R.drawable.green_ganlanlv, "#1f2623"),
            new GreenColor(R.drawable.green_mangconglv, "#141e1b"),
            new GreenColor(R.drawable.green_hujishenglv, "#2b312c"),
            new GreenColor(R.drawable.green_shenhailv, "#1a3b32"),
            new GreenColor(R.drawable.green_canglv, "#223e36"),
            new GreenColor(R.drawable.green_enyoulv, "#373834"),
            new GreenColor(R.drawable.green_youlv, "#253d24"),
            new GreenColor(R.drawable.green_heyelv, "#1a6840"),
            new GreenColor(R.drawable.green_tianluolv, "#5e665b"),
            new GreenColor(R.drawable.green_langyanhuilv, "#5d655f"),
            new GreenColor(R.drawable.green_feiquanlv, "#497568"),
            new GreenColor(R.drawable.green_baiqucailv, "#485b4d"),
            new GreenColor(R.drawable.green_yadinglv, "#428675"),
            new GreenColor(R.drawable.green_haiwanglv, "#248067"),
            new GreenColor(R.drawable.green_bohelv, "#207f4c"),
            new GreenColor(R.drawable.green_kongquelv, "#229453"),
            new GreenColor(R.drawable.green_gongdianlv, "#20894d"),
            new GreenColor(R.drawable.green_danbaishilv, "#579572"),
            new GreenColor(R.drawable.green_lanlv, "#12a182"),
            new GreenColor(R.drawable.green_qingfanlv, "#2c9678"),
            new GreenColor(R.drawable.green_zhulv, "#1ba784"),
            new GreenColor(R.drawable.green_wasonglv, "#6e8b74"),
            new GreenColor(R.drawable.green_meidielv, "#12aa9c"),
            new GreenColor(R.drawable.green_chanlv, "#3c9566"),
            new GreenColor(R.drawable.green_conglv, "#40a070"),
            new GreenColor(R.drawable.green_cuilv, "#20a162"),
            new GreenColor(R.drawable.green_tonglv, "#2bae85"),
            new GreenColor(R.drawable.green_walv, "#45b787"),
            new GreenColor(R.drawable.green_danlv, "#61ac85"),
            new GreenColor(R.drawable.green_baoshilv, "#41ae3c"),
            new GreenColor(R.drawable.green_yusuilv, "#41b349"),
            new GreenColor(R.drawable.green_xianlv, "#43b244"),
            new GreenColor(R.drawable.green_yingwulv, "#5bae23"),
            new GreenColor(R.drawable.green_wuzhilv, "#69a794"),
            new GreenColor(R.drawable.green_koushaolv, "#5dbe8a"),
            new GreenColor(R.drawable.green_maimiaolv, "#55bb8a"),
            new GreenColor(R.drawable.green_maolv, "#66c18c"),
            new GreenColor(R.drawable.green_songshuanglv, "#83a78d"),
            new GreenColor(R.drawable.green_tianyuanlv, "#68b88e"),
            new GreenColor(R.drawable.green_langhualv, "#92b3a5"),
            new GreenColor(R.drawable.green_shilv, "#57c3c2"),
            new GreenColor(R.drawable.green_shuilv, "#8cc269"),
            new GreenColor(R.drawable.green_yalv, "#96c24e"),
            new GreenColor(R.drawable.green_ganlanhuanglv, "#bec936"),
            new GreenColor(R.drawable.green_pingguolv, "#bacf65"),
            new GreenColor(R.drawable.green_luweilv, "#b7d07a"),
            new GreenColor(R.drawable.green_fenlv, "#83cbac"),
            new GreenColor(R.drawable.green_minglv, "#9eccab"),
            new GreenColor(R.drawable.green_ganlanshilv, "#b2cf87"),
            new GreenColor(R.drawable.green_huaihuahuanglv, "#d2d97a"),
            new GreenColor(R.drawable.green_caoyuanyuanlv, "#9abeaf"),
            new GreenColor(R.drawable.green_jialingshuilv, "#add5a2"),
            new GreenColor(R.drawable.green_yuzanlv, "#a4cab6"),
            new GreenColor(R.drawable.green_ailv, "#cad3c3"),
            new GreenColor(R.drawable.green_zhuhuanglv, "#b9dec9"),
            new GreenColor(R.drawable.green_dancuilv, "#c6dfc8"),
            new GreenColor(R.drawable.green_haimeilv, "#e2e7bf"),
            new GreenColor(R.drawable.green_aibeilv, "#dfecd5"),
            new GreenColor(R.drawable.green_nenjvlv, "#f0f5e5"),
    };

    private void initRedCard1() {
        greenColorList1.clear();
        for (int i = 0; i <60; i+=2) {
            greenColorList1.add(GreenColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(GreenColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    private void initBlueCard2() {
        greenColorList2.clear();
        for (int i = 1; i <60; i+=2) {
            greenColorList2.add(GreenColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color =Color.parseColor(GreenColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }


    String[] shiju = new String[]{"碧玉妆成一树高,万条垂下绿丝绦","江涵秋影雁初飞,与客携壶上翠微","沧浪浑是烟雨,黄河路接银河路","今日云景好,水绿秋山明","林莺何处吟筝柱,墙柳谁家晒麴尘","豆绿缸中梅水满,何时小啜龙团饷","前溪沧浪映,通波澄绿青","梅黄麦绿无归处,可得漂漂爱浪游","户上犹悬艾绿,尊中尚染雄黄","欧碧姚黄,总是让他风韵","落花称意红,芳草无心绿","美人赠我锦绣段,何以报之青玉案","孤月沧浪河汉清,北斗错落长庚明","蓬窗窥天缥,江水真安流","叶枯红藕,条疏青柳"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_green);


        toolbar1 = findViewById(R.id.toolbar_photo);


        ImageView imageView=findViewById(R.id.green_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaGreen.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout view=findViewById(R.id.picture);
        ImageButton imageButton1=findViewById(R.id.button_yunshanlv);
        ImageButton imageButton2=findViewById(R.id.button_ganlanlv);
        ImageButton imageButton3=findViewById(R.id.button_mangconglv);
        ImageButton imageButton4=findViewById(R.id.button_hujishenglv);
        ImageButton imageButton5=findViewById(R.id.button_shenhailv);
        ImageButton imageButton6=findViewById(R.id.button_canglv);
        ImageButton imageButton7=findViewById(R.id.button_enyoulv);
        ImageButton imageButton8=findViewById(R.id.button_youlv);
        ImageButton imageButton9=findViewById(R.id.button_heyelv);
        ImageButton imageButton10=findViewById(R.id.button_tianluolv);
        ImageButton imageButton11=findViewById(R.id.button_langyanlv);
        ImageButton imageButton12=findViewById(R.id.button_feiquanlv);
        ImageButton imageButton13=findViewById(R.id.button_baiqucailv);
        ImageButton imageButton14=findViewById(R.id.button_yadinglv);
        ImageButton imageButton15=findViewById(R.id.button_haiwanglv);
        ImageButton imageButton16=findViewById(R.id.button_bohelv);
        ImageButton imageButton17=findViewById(R.id.button_kongquelv);
        ImageButton imageButton18=findViewById(R.id.button_gongdianlv);
        ImageButton imageButton19=findViewById(R.id.button_danbaishilv);
        ImageButton imageButton20=findViewById(R.id.button_lanlv);
        ImageButton imageButton21=findViewById(R.id.button_qingfanlv);
        ImageButton imageButton22=findViewById(R.id.button_zhulv);
        ImageButton imageButton23=findViewById(R.id.button_wasonglv);
        ImageButton imageButton24=findViewById(R.id.button_meidielv);
        ImageButton imageButton25=findViewById(R.id.button_chanlv);
        ImageButton imageButton26=findViewById(R.id.button_conglv);
        ImageButton imageButton27=findViewById(R.id.button_cuilv);
        ImageButton imageButton28=findViewById(R.id.button_tonglv);
        ImageButton imageButton29=findViewById(R.id.button_walv);
        ImageButton imageButton30=findViewById(R.id.button_danlv);
        ImageButton imageButton31=findViewById(R.id.button_baoshilv);
        ImageButton imageButton32=findViewById(R.id.button_yusuilv);
        ImageButton imageButton33=findViewById(R.id.button_xianlv);
        ImageButton imageButton34=findViewById(R.id.button_yingwulv);
        ImageButton imageButton35=findViewById(R.id.button_wuzhilv);
        ImageButton imageButton36=findViewById(R.id.button_koushaolv);
        ImageButton imageButton37=findViewById(R.id.button_maimiaolv);
        ImageButton imageButton38=findViewById(R.id.button_maolv);
        ImageButton imageButton39=findViewById(R.id.button_songshuanglv);
        ImageButton imageButton40=findViewById(R.id.button_tianyuanlv);
        ImageButton imageButton41=findViewById(R.id.button_langhualv);
        ImageButton imageButton42=findViewById(R.id.button_shilv);
        ImageButton imageButton43=findViewById(R.id.button_shuilv);
        ImageButton imageButton44=findViewById(R.id.button_yalv);
        ImageButton imageButton45=findViewById(R.id.button_ganlanhuanglv);
        ImageButton imageButton46=findViewById(R.id.button_pingguolv);
        ImageButton imageButton47=findViewById(R.id.button_luweilv);
        ImageButton imageButton48=findViewById(R.id.button_fenlv);
        ImageButton imageButton49=findViewById(R.id.button_minglv);
        ImageButton imageButton50=findViewById(R.id.button_ganlanshilv);
        ImageButton imageButton51=findViewById(R.id.button_huaihuahuanglv);
        ImageButton imageButton52=findViewById(R.id.button_caoyuanyuanlv);
        ImageButton imageButton53=findViewById(R.id.button_jialingshuilv);
        ImageButton imageButton54=findViewById(R.id.button_yuzanlv);
        ImageButton imageButton55=findViewById(R.id.button_ailv);
        ImageButton imageButton56=findViewById(R.id.button_zhuhuanglv);
        ImageButton imageButton57=findViewById(R.id.button_dancuilv);
        ImageButton imageButton58=findViewById(R.id.button_haimeilv);
        ImageButton imageButton59=findViewById(R.id.button_aibeilv);
        ImageButton imageButton60=findViewById(R.id.button_nenjvlv);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[0].colorName));
                imageView.setImageResource(R.drawable.green_yunshanlv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[1].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[1].colorName));
                imageView.setImageResource(R.drawable.green_ganlanlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[2].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[2].colorName));
                imageView.setImageResource(R.drawable.green_mangconglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[3].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[3].colorName));
                imageView.setImageResource(R.drawable.green_hujishenglv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[4].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[4].colorName));
                imageView.setImageResource(R.drawable.green_shenhailv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[5].colorName));
                imageView.setImageResource(R.drawable.green_canglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[6].colorName));
                imageView.setImageResource(R.drawable.green_enyoulv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[7].colorName));
                imageView.setImageResource(R.drawable.green_youlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[8].colorName));
                imageView.setImageResource(R.drawable.green_heyelv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[9].colorName));
                imageView.setImageResource(R.drawable.green_tianluolv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[10].colorName));
                imageView.setImageResource(R.drawable.green_langyanhuilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[11].colorName));
                imageView.setImageResource(R.drawable.green_feiquanlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[12].colorName));
                imageView.setImageResource(R.drawable.green_baiqucailv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[13].colorName));
                imageView.setImageResource(R.drawable.green_yadinglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[14].colorName));
                imageView.setImageResource(R.drawable.green_haiwanglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[15].colorName));
                imageView.setImageResource(R.drawable.green_bohelv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[16].colorName));
                imageView.setImageResource(R.drawable.green_kongquelv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[17].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[17].colorName));
                imageView.setImageResource(R.drawable.green_gongdianlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[18].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[18].colorName));
                imageView.setImageResource(R.drawable.green_danbaishilv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[19].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[19].colorName));
                imageView.setImageResource(R.drawable.green_lanlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[20].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[20].colorName));
                imageView.setImageResource(R.drawable.green_qingfanlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[21].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[21].colorName));
                imageView.setImageResource(R.drawable.green_zhulv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[22].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[22].colorName));
                imageView.setImageResource(R.drawable.green_wasonglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[23].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[23].colorName));
                imageView.setImageResource(R.drawable.green_meidielv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[24].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[24].colorName));
                imageView.setImageResource(R.drawable.green_chanlv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[25].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[25].colorName));
                imageView.setImageResource(R.drawable.green_conglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[26].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[26].colorName));
                imageView.setImageResource(R.drawable.green_cuilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[27].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[27].colorName));
                imageView.setImageResource(R.drawable.green_tonglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[28].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[28].colorName));
                imageView.setImageResource(R.drawable.green_walv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[29].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[29].colorName));
                imageView.setImageResource(R.drawable.green_danlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[30].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[30].colorName));
                imageView.setImageResource(R.drawable.green_baoshilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[31].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[31].colorName));
                imageView.setImageResource(R.drawable.green_yusuilv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[32].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[32].colorName));
                imageView.setImageResource(R.drawable.green_xianlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[33].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[33].colorName));
                imageView.setImageResource(R.drawable.green_yingwulv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[34].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[34].colorName));
                imageView.setImageResource(R.drawable.green_wuzhilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[35].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[35].colorName));
                imageView.setImageResource(R.drawable.green_koushaolv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[36].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[36].colorName));
                imageView.setImageResource(R.drawable.green_maimiaolv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[37].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[37].colorName));
                imageView.setImageResource(R.drawable.green_maolv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[38].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[38].colorName));
                imageView.setImageResource(R.drawable.green_songshuanglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[39].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[39].colorName));
                imageView.setImageResource(R.drawable.green_tianyuanlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[40].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[40].colorName));
                imageView.setImageResource(R.drawable.green_langhualv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[41].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[41].colorName));
                imageView.setImageResource(R.drawable.green_shilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[42].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[42].colorName));
                imageView.setImageResource(R.drawable.green_shuilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[43].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[43].colorName));
                imageView.setImageResource(R.drawable.green_yalv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[44].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[44].colorName));
                imageView.setImageResource(R.drawable.green_ganlanhuanglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[45].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[45].colorName));
                imageView.setImageResource(R.drawable.green_pingguolv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[46].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[46].colorName));
                imageView.setImageResource(R.drawable.green_luweilv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[47].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[47].colorName));
                imageView.setImageResource(R.drawable.green_fenlv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[48].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[48].colorName));
                imageView.setImageResource(R.drawable.green_minglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[49].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[49].colorName));
                imageView.setImageResource(R.drawable.green_ganlanshilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[50].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[50].colorName));
                imageView.setImageResource(R.drawable.green_huaihuahuanglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[51].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[51].colorName));
                imageView.setImageResource(R.drawable.green_caoyuanyuanlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[52].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[52].colorName));
                imageView.setImageResource(R.drawable.green_jialingshuilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[53].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[53].colorName));
                imageView.setImageResource(R.drawable.green_yuzanlv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[54].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[54].colorName));
                imageView.setImageResource(R.drawable.green_ailv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[55].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[55].colorName));
                imageView.setImageResource(R.drawable.green_zhuhuanglv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[56].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[56].colorName));
                imageView.setImageResource(R.drawable.green_dancuilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[57].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[57].colorName));
                imageView.setImageResource(R.drawable.green_haimeilv);
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
                view.setBackgroundColor(Color.parseColor(GreenColors[58].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[58].colorName));
                imageView.setImageResource(R.drawable.green_aibeilv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(GreenColors[59].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(GreenColors[59].colorName));
                imageView.setImageResource(R.drawable.green_nenjvlv);
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