package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialogx.dialogs.BottomMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SekaBlue extends AppCompatActivity {
    public class BlueColor {
        private int imageId;
        private String colorName;

        public BlueColor(int ImageId,String ColorName) {
            this.imageId = ImageId;
            this.colorName=ColorName;
        }

        public int getImageId() {
            return imageId;
        }
    }

    //RecyclerView使用

    private List<BlueColor> blueColorList1 = new ArrayList<>();
    private List<BlueColor> blueColorList2 = new ArrayList<>();
    private BlueColorAdapter blueColorAdapter1;
    private BlueColorAdapter blueColorAdapter2;
    private LinearLayout toolbar1;

    private BlueColor[] blueColors={
            new BlueColor(R.drawable.blue_anlan,"#101f30"),
            new BlueColor(R.drawable.blue_ganglan,"#0f1423"),
            new BlueColor(R.drawable.blue_gangqing,"#142334"),
            new BlueColor(R.drawable.blue_yanhanlan,"#131824"),
            new BlueColor(R.drawable.blue_gelan,"#1c2938"),
            new BlueColor(R.drawable.blue_yanlan,"#144a74"),
            new BlueColor(R.drawable.blue_haitaolan,"#15559a"),
            new BlueColor(R.drawable.blue_feiyancaolan,"#0f59a4"),
            new BlueColor(R.drawable.blue_dianqing,"#1661ab"),
            new BlueColor(R.drawable.blue_bolinlan,"#126bae"),
            new BlueColor(R.drawable.blue_haijunlan,"#346c9c"),
            new BlueColor(R.drawable.blue_ananlan,"#3170a7"),
            new BlueColor(R.drawable.vlue_niluolan,"#2474b5"),
            new BlueColor(R.drawable.blue_jingtailan,"#2775b6"),
            new BlueColor(R.drawable.blue_honglan,"#2177b8"),
            new BlueColor(R.drawable.blue_huaqing,"#2376b6"),
            new BlueColor(R.drawable.blue_qunqing,"#1772b4"),
            new BlueColor(R.drawable.blue_pinglan,"#2b73af"),
            new BlueColor(R.drawable.blue_diechilan,"#4e7ca1"),
            new BlueColor(R.drawable.blue_yushandoulan,"#619ac3"),
            new BlueColor(R.drawable.blue_xinglan,"#93b5cf"),
            new BlueColor(R.drawable.blue_yunshuilan,"#baccd9")
    };

    private void initBlueCard1() {
        blueColorList1.clear();
        for (int i = 0; i <22; i+=2) {
            blueColorList1.add(blueColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color =Color.parseColor(blueColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    private void initBlueCard2() {
        blueColorList2.clear();
        for (int i = 1; i <22; i+=2) {
            blueColorList2.add(blueColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color =Color.parseColor(blueColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }

    String[] shiju = new String[]{"天苍苍,野茫茫,风吹草低见牛羊","如分雁荡群青过,忽挟龙湫万玉来","天之苍苍,其正色耶","碧城十二曲阑千,犀辟尘埃玉辟寒","朱门收画戟,绀宇出青莲","河西王沮渠蒙逊,献青雀头黛百斤","踏歌踏歌蓝采和,世界能几何","暖风晴日融春昼,闲看花阴鸡吐绶","白玉凝素液,瑾瑜发奇光","湖上飞来小祝融,群青在侧一居中","物有无穷好,蓝青又出青","春水净于僧眼碧,晚山浓似佛头青","已爱平平仄仄,复爱花青入墨","笑老去心情,也将醉眼,镇为花青","揉蓝衫子杏黄裙,独倚玉阑无语、点檀唇"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_blue);

        toolbar1 = findViewById(R.id.toolbar_photo);


        ImageView imageView=findViewById(R.id.blue_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaBlue.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout view=findViewById(R.id.picture);

        ImageButton imageButton1=findViewById(R.id.button_anlan);
        ImageButton imageButton2=findViewById(R.id.button_ganglan);
        ImageButton imageButton3=findViewById(R.id.button_gangqing);
        ImageButton imageButton4=findViewById(R.id.button_yanhanlan);
        ImageButton imageButton5=findViewById(R.id.button_gelan);
        ImageButton imageButton6=findViewById(R.id.button_yanlan);
        ImageButton imageButton7=findViewById(R.id.button_haitaolan);
        ImageButton imageButton8=findViewById(R.id.button_feiyancaolan);
        ImageButton imageButton9=findViewById(R.id.button_dianqing);
        ImageButton imageButton10=findViewById(R.id.button_bolinlan);
        ImageButton imageButton11=findViewById(R.id.button_haijunlan);
        ImageButton imageButton12=findViewById(R.id.button_ananlan);
        ImageButton imageButton13=findViewById(R.id.button_niluolan);
        ImageButton imageButton14=findViewById(R.id.button_jingtailan);
        ImageButton imageButton15=findViewById(R.id.button_honglan);
        ImageButton imageButton16=findViewById(R.id.button_huaqing);
        ImageButton imageButton17=findViewById(R.id.button_qunqing);
        ImageButton imageButton18=findViewById(R.id.button_pinglan);
        ImageButton imageButton19=findViewById(R.id.button_diechilan);
        ImageButton imageButton20=findViewById(R.id.button_yunshandoulan);
        ImageButton imageButton21=findViewById(R.id.button_xinglan);
        ImageButton imageButton22=findViewById(R.id.button_yunshuilan);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(blueColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[0].colorName));
                imageView.setImageResource(R.drawable.blue_anlan);
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
                imageView.setImageResource(R.drawable.blue_ganglan);
                view.setBackgroundColor(Color.parseColor(blueColors[1].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[1].colorName));
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
                imageView.setImageResource(R.drawable.blue_gangqing);
                view.setBackgroundColor(Color.parseColor(blueColors[2].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[2].colorName));
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
                imageView.setImageResource(R.drawable.blue_yanhanlan);
                view.setBackgroundColor(Color.parseColor(blueColors[3].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[3].colorName));
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
                imageView.setImageResource(R.drawable.blue_gelan);
                view.setBackgroundColor(Color.parseColor(blueColors[4].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[4].colorName));
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
                imageView.setImageResource(R.drawable.blue_yanlan);
                view.setBackgroundColor(Color.parseColor(blueColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[5].colorName));
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
                imageView.setImageResource(R.drawable.blue_haitaolan);
                view.setBackgroundColor(Color.parseColor(blueColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[6].colorName));
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
                imageView.setImageResource(R.drawable.blue_feiyancaolan);
                view.setBackgroundColor(Color.parseColor(blueColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[7].colorName));
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
                imageView.setImageResource(R.drawable.blue_dianqing);
                view.setBackgroundColor(Color.parseColor(blueColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[8].colorName));
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
                imageView.setImageResource(R.drawable.blue_bolinlan);
                view.setBackgroundColor(Color.parseColor(blueColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[9].colorName));
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
                imageView.setImageResource(R.drawable.blue_haijunlan);
                view.setBackgroundColor(Color.parseColor(blueColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[10].colorName));
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
                imageView.setImageResource(R.drawable.blue_ananlan);
                view.setBackgroundColor(Color.parseColor(blueColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[11].colorName));
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
                imageView.setImageResource(R.drawable.vlue_niluolan);
                view.setBackgroundColor(Color.parseColor(blueColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[12].colorName));
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
                imageView.setImageResource(R.drawable.blue_jingtailan);
                view.setBackgroundColor(Color.parseColor(blueColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[13].colorName));
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
                imageView.setImageResource(R.drawable.blue_honglan);
                view.setBackgroundColor(Color.parseColor(blueColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[14].colorName));
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
                imageView.setImageResource(R.drawable.blue_huaqing);
                view.setBackgroundColor(Color.parseColor(blueColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[15].colorName));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });
        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {imageView.setImageResource(R.drawable.blue_qunqing);
                view.setBackgroundColor(Color.parseColor(blueColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[16].colorName));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });
        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.blue_pinglan);
                view.setBackgroundColor(Color.parseColor(blueColors[17].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[17].colorName));
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
                imageView.setImageResource(R.drawable.blue_diechilan);
                view.setBackgroundColor(Color.parseColor(blueColors[18].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[18].colorName));
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
                imageView.setImageResource(R.drawable.blue_yushandoulan);
                view.setBackgroundColor(Color.parseColor(blueColors[19].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[19].colorName));
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
                imageView.setImageResource(R.drawable.blue_xinglan);
                view.setBackgroundColor(Color.parseColor(blueColors[20].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[20].colorName));
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
                imageView.setImageResource(R.drawable.blue_yunshuilan);
                view.setBackgroundColor(Color.parseColor(blueColors[21].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(blueColors[21].colorName));
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        findViewById(R.id.ic_more).setOnClickListener(v -> BottomMenu.show(new String[]{"红", "黄", "蓝", "绿", "茶", "水蓝", "紫", "黑白灰"})
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