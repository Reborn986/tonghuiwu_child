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

public class SekaTea extends AppCompatActivity {

    public class TeaColor {
        private int imageId;
        private String colorName;

        public TeaColor(int ImageId,String ColorName) {
            this.imageId = ImageId;
            this.colorName=ColorName;
        }

        public int getImageId() {
            return imageId;
        }

    }

    private TeaColor[] teaColors= {
            new TeaColor(R.drawable.tea_xiekelv, "#513c20"),
            new TeaColor(R.drawable.tea_gutonglv, "#533c1b"),
            new TeaColor(R.drawable.tea_jiaochalv, "#553b18"),
            new TeaColor(R.drawable.tea_anhaishuilv, "#584717"),
            new TeaColor(R.drawable.tea_zonglvlv, "#5b4913"),
            new TeaColor(R.drawable.tea_ganlanlv, "#5e5314"),
            new TeaColor(R.drawable.tea_tanshuilv, "#645822"),
            new TeaColor(R.drawable.tea_yililv, "#835e1d"),
            new TeaColor(R.drawable.tea_huilv, "#8a6913"),
            new TeaColor(R.drawable.tea_zongyelv, "#876818"),
            new TeaColor(R.drawable.tea_jiaoqing, "#87723e"),
            new TeaColor(R.drawable.tea_tailv, "#887322"),
            new TeaColor(R.drawable.tea_biluochunlv, "#867018"),
            new TeaColor(R.drawable.tea_caohuilv, "#8e804b"),
            new TeaColor(R.drawable.tea_kulv, "#b78d12"),
            new TeaColor(R.drawable.tea_xinhelv, "#d2b116"),
            new TeaColor(R.drawable.tea_danhuilv, "#ad9e5f"),
    };




    private List<TeaColor> teaColorList1 = new ArrayList<>();
    private List<TeaColor> teaColorList2 = new ArrayList<>();
    private LinearLayout toolbar1;

    private void initTeaCard1() {
        teaColorList1.clear();
        for (int i = 0; i <134; i+=2) {
            teaColorList1.add(teaColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(teaColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    private void initTeaCard2() {
        teaColorList2.clear();
        for (int i = 1; i <134; i+=2) {
            teaColorList2.add(teaColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color =Color.parseColor(teaColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }


    String[] shiju = new String[]{"青青子衿,悠悠我心","制芰荷以为衣兮,集芙蓉以为裳","不趁青梅尝煮酒,要看细雨熟黄梅","我有结绿珍,久藏浊水泥","莓莓郊原青,漠漠风雨黑","树头蚕葚熟,篱下雀梅香","风来弱柳摇官绿,云破奇峰涌帝青","雨抛金锁甲,苔卧绿沈枪","烟条涂石绿,粉蕊扑雌黄","峯攒石绿点,柳惹麴尘丝","吟诗白羽扇,校猎绿沈枪","螺青点出莫山色,石绿染成春浦潮"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_tea);


        toolbar1 = findViewById(R.id.toolbar_photo);

        ImageView imageView=findViewById(R.id.tea_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaTea.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout view=findViewById(R.id.picture);
        ImageButton imageButton1=findViewById(R.id.button_xiekelv);
        ImageButton imageButton2=findViewById(R.id.button_gutonglv);
        ImageButton imageButton3=findViewById(R.id.button_jiaochalv);
        ImageButton imageButton4=findViewById(R.id.button_anhaishuilv);
        ImageButton imageButton5=findViewById(R.id.button_zonglvlv);
        ImageButton imageButton6=findViewById(R.id.button_ganglanlv_2);
        ImageButton imageButton7=findViewById(R.id.button_tanshuilv);
        ImageButton imageButton8=findViewById(R.id.button_yililv);
        ImageButton imageButton9=findViewById(R.id.button_huilv);
        ImageButton imageButton10=findViewById(R.id.button_zongyelv);
        ImageButton imageButton11=findViewById(R.id.button_jiaoqing);
        ImageButton imageButton12=findViewById(R.id.button_tailv);
        ImageButton imageButton13=findViewById(R.id.button_biluochunlv);
        ImageButton imageButton14=findViewById(R.id.button_caohuilv);
        ImageButton imageButton15=findViewById(R.id.button_kulv);
        ImageButton imageButton16=findViewById(R.id.button_xinhelv);
        ImageButton imageButton17=findViewById(R.id.button_danhuilv);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(teaColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[0].colorName));
                imageView.setImageResource(R.drawable.tea_xiekelv);
                TextView tShiju = findViewById(R.id.t_shiju);
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
                view.setBackgroundColor(Color.parseColor(teaColors[1].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[1].colorName));
                imageView.setImageResource(R.drawable.tea_gutonglv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[2].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[2].colorName));
                imageView.setImageResource(R.drawable.tea_jiaochalv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[3].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[3].colorName));
                imageView.setImageResource(R.drawable.tea_anhaishuilv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[4].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[4].colorName));
                imageView.setImageResource(R.drawable.tea_zonglvlv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[5].colorName));
                imageView.setImageResource(R.drawable.tea_ganlanlv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[6].colorName));
                imageView.setImageResource(R.drawable.tea_tanshuilv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[7].colorName));
                imageView.setImageResource(R.drawable.tea_yililv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(teaColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[8].colorName));
                imageView.setImageResource(R.drawable.tea_huilv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[9].colorName));
                imageView.setImageResource(R.drawable.tea_zongyelv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[10].colorName));
                imageView.setImageResource(R.drawable.tea_jiaoqing);
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
                view.setBackgroundColor(Color.parseColor(teaColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[11].colorName));
                imageView.setImageResource(R.drawable.tea_tailv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[12].colorName));
                imageView.setImageResource(R.drawable.tea_biluochunlv);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(teaColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[13].colorName));
                imageView.setImageResource(R.drawable.tea_caohuilv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[14].colorName));
                imageView.setImageResource(R.drawable.tea_kulv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[15].colorName));
                imageView.setImageResource(R.drawable.tea_xinhelv);
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
                view.setBackgroundColor(Color.parseColor(teaColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(teaColors[16].colorName));
                imageView.setImageResource(R.drawable.tea_danhuilv);
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