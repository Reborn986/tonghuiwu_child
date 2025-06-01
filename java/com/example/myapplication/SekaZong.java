package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.kongzue.dialogx.dialogs.BottomMenu;

import java.util.Random;


public class SekaZong extends AppCompatActivity {

    String[] zongColors={
           "#482522","#592620","#5c3719","#5a1f1b","#5d3d21","#5c1e19","#603d30","#673424",
            "#652b1c","#692a1b","#71361d","#732e12","#753117","#773d31","#66462a","#863020",
            "#883a1e","#954416","#b7511d","#945833","#964d22","#986524","#aa6a4c","#be7e4a",
            "#c1651a","#de7622","#d99156","#c09351","#e7a23f","#e2c17c","#e3bd8d"
    };


    String[] shiju = new String[]{"意行到南园,杏子半红碧","乳莺啼晓销兰炷,媚蝶伤春失蕙丛","韎韐有爽,以作六师","落花纷纷稍觉多,美人欲醉朱颜酡","红颜熙曜,晔若笤荣","春光放尽百花房,开到林檎与海棠","丹罽潜胎珠玓瓅,脂肤满绽玉精神","腻歪红匀称檀唇,晚妆新,暗伤春","一枝价重万琼琚,直恐姑山雪不如","棠梨叶落胭脂色,养麦花开白雪香",
            "绿蚁新醅酒,红泥小火炉","龙团笑恙酒,狐腋袭驼茸","泮宫翠栢真奇特,溜雨霜皮古铜色","寂寂春花烟色暮,檐燕双双落花度","八品九品绿袍,未入流檀褐绿袍","栗壳黄腴猿哺子,松巢碧冷鹤温雏","山泉鸣石涧,地籁响岩风","漆园傲更养生主,栗里高人归去来","黑泰黄梁初熟后,朱柑绿橘半甜时","尽日窗间更无事,唯烧一炷降真香","边烂熟等雕虫,远志真看小草同","哀牢白叠贡南朝,黄润筒中价益高","惭幽闺之琴瑟,晦高台之流黄","登舟既虎啸,激水方龙战"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_cheng);
        LinearLayout toolbar1 = findViewById(R.id.toolbar_photo);


        ImageView imageView=findViewById(R.id.blue_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaZong.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        View view=findViewById(R.id.picture);

        ImageButton imageButton1=findViewById(R.id.button_huoshanzong);
        ImageButton imageButton2=findViewById(R.id.button_antuozong);
        ImageButton imageButton3=findViewById(R.id.button_gutonghe);
        ImageButton imageButton4=findViewById(R.id.button_jiangzong);
        ImageButton imageButton5=findViewById(R.id.button_chahe);
        ImageButton imageButton6=findViewById(R.id.button_lizong);
        ImageButton imageButton7=findViewById(R.id.button_zhonghuituo);
        ImageButton imageButton8=findViewById(R.id.button_danlizong);
        ImageButton imageButton9=findViewById(R.id.button_kekezong);
        ImageButton imageButton10=findViewById(R.id.button_zhayezong);
        ImageButton imageButton11=findViewById(R.id.button_dingxiangzong);
        ImageButton imageButton12=findViewById(R.id.button_sunpizong);
        ImageButton imageButton13=findViewById(R.id.button_kafei);
        ImageButton imageButton14=findViewById(R.id.button_xiangshuzong);
        ImageButton imageButton15=findViewById(R.id.button_tuose);
        ImageButton imageButton16=findViewById(R.id.button_huoshanyan);
        ImageButton imageButton17=findViewById(R.id.button_yekezong);
        ImageButton imageButton18=findViewById(R.id.button_mangguozong);
        ImageButton imageButton19=findViewById(R.id.button_dankekezong);
        ImageButton imageButton20=findViewById(R.id.button_dankafei);
        ImageButton imageButton21=findViewById(R.id.button_yanshizong);
        ImageButton imageButton22=findViewById(R.id.button_shanjihe);
        ImageButton imageButton23=findViewById(R.id.button_huonizong);
        ImageButton imageButton24=findViewById(R.id.button_danzhe);
        ImageButton imageButton25=findViewById(R.id.button_binglangzong);
        ImageButton imageButton26=findViewById(R.id.button_jizong);
        ImageButton imageButton27=findViewById(R.id.button_lupihe);
        ImageButton imageButton28=findViewById(R.id.button_guipidanzong);
        ImageButton imageButton29=findViewById(R.id.button_diaoyezong);
        ImageButton imageButton30=findViewById(R.id.button_qiantuose);
        ImageButton imageButton31=findViewById(R.id.button_lujiaozong);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(zongColors[0]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[0]));
                imageView.setImageResource(R.drawable.zong_huoshanzong);
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
                imageView.setImageResource(R.drawable.zong_antuozong);
                view.setBackgroundColor(Color.parseColor(zongColors[1]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[1]));
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
                imageView.setImageResource(R.drawable.zong_gutonghe);
                view.setBackgroundColor(Color.parseColor(zongColors[2]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[2]));
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
                imageView.setImageResource(R.drawable.zong_jiangzong);
                view.setBackgroundColor(Color.parseColor(zongColors[3]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[3]));
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
                imageView.setImageResource(R.drawable.zong_chahe);
                view.setBackgroundColor(Color.parseColor(zongColors[4]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[4]));
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
                imageView.setImageResource(R.drawable.zong_lizong);
                view.setBackgroundColor(Color.parseColor(zongColors[5]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[5]));
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
                imageView.setImageResource(R.drawable.zong_zhonghuituo);
                view.setBackgroundColor(Color.parseColor(zongColors[6]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[6]));
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
                imageView.setImageResource(R.drawable.zong_danlizong);
                view.setBackgroundColor(Color.parseColor(zongColors[7]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[7]));
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
                imageView.setImageResource(R.drawable.zong_kekezong);
                view.setBackgroundColor(Color.parseColor(zongColors[8]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[8]));
            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_zhayezong);
                view.setBackgroundColor(Color.parseColor(zongColors[9]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[9]));
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
                imageView.setImageResource(R.drawable.zong_dingxiangzong);
                view.setBackgroundColor(Color.parseColor(zongColors[10]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[10]));
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
                imageView.setImageResource(R.drawable.zong_sunpizong);
                view.setBackgroundColor(Color.parseColor(zongColors[11]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[11]));
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
                imageView.setImageResource(R.drawable.zong_kafei);
                view.setBackgroundColor(Color.parseColor(zongColors[12]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[12]));
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
                imageView.setImageResource(R.drawable.zong_xiangshuzong);
                view.setBackgroundColor(Color.parseColor(zongColors[13]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[13]));
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
                imageView.setImageResource(R.drawable.zong_tuose);
                view.setBackgroundColor(Color.parseColor(zongColors[14]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[14]));
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
                imageView.setImageResource(R.drawable.zong_huoyanzong);
                view.setBackgroundColor(Color.parseColor(zongColors[15]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[15]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });
        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {imageView.setImageResource(R.drawable.zong_yekezong);
                view.setBackgroundColor(Color.parseColor(zongColors[16]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[16]));
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
                imageView.setImageResource(R.drawable.zong_mangguozong);
                view.setBackgroundColor(Color.parseColor(zongColors[17]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[17]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);   }
        });
        imageButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_dankekezong);
                view.setBackgroundColor(Color.parseColor(zongColors[18]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[18]));
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
                imageView.setImageResource(R.drawable.zong_dankafei);
                view.setBackgroundColor(Color.parseColor(zongColors[19]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[19]));
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
                imageView.setImageResource(R.drawable.zong_yanshizong);
                view.setBackgroundColor(Color.parseColor(zongColors[20]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[20]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });
        imageButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_shanjihe);
                view.setBackgroundColor(Color.parseColor(zongColors[21]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[21]));
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
                imageView.setImageResource(R.drawable.zong_huonizong);
                view.setBackgroundColor(Color.parseColor(zongColors[22]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[22]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);   }
        });

        imageButton24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_danzhe );
                view.setBackgroundColor(Color.parseColor(zongColors[23]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[23]));
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
                imageView.setImageResource(R.drawable.zong_binglangzong);
                view.setBackgroundColor(Color.parseColor(zongColors[24]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[24]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);   }
        });
        imageButton26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_jizong);
                view.setBackgroundColor(Color.parseColor(zongColors[25]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[25]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });
        imageButton27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_lupihe);
                view.setBackgroundColor(Color.parseColor(zongColors[26]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[26]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);   }
        });
        imageButton28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_guipidanzong);
                view.setBackgroundColor(Color.parseColor(zongColors[27]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[27]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);   }
        });
        imageButton29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_diaoyezong);
                view.setBackgroundColor(Color.parseColor(zongColors[28]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[28]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);   }
        });
        imageButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zong_qiantuose);
                view.setBackgroundColor(Color.parseColor(zongColors[29]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[29]));
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
                imageView.setImageResource(R.drawable.zong_lujiaozong);
                view.setBackgroundColor(Color.parseColor(zongColors[30]));
                toolbar1.setBackgroundColor(Color.parseColor(zongColors[30]));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);   }
        });

        findViewById(R.id.ic_more).setOnClickListener(v -> BottomMenu.show(new String[]{"红","黄","棕", "蓝", "绿", "茶", "水蓝", "紫", "黑白灰"})
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