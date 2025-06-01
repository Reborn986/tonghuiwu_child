package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialogx.dialogs.BottomMenu;
import com.kongzue.dialogx.interfaces.OnMenuItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SekaAqua extends AppCompatActivity {
    public class AquaColor {
        private int imageId;
        private String colorName;

        public AquaColor(int ImageId, String ColorName) {
            this.imageId = ImageId;
            this.colorName = ColorName;
        }

        public int getImageId() {
            return imageId;
        }
    }

    //RecyclerView使用

    private List<AquaColor> aquaColorList1 = new ArrayList<>();
    private List<AquaColor> aquaColorList2 = new ArrayList<AquaColor>();

    private LinearLayout toolbar1;

    private AquaColor[] aquaColors = {
            new AquaColor(R.drawable.aqua_shenhuilan, "#132c33"),
            new AquaColor(R.drawable.aqua_huilan, "#21373d"),
            new AquaColor(R.drawable.aqua_canglan, "#134857"),
            new AquaColor(R.drawable.aqua_tangcilan, "#11659a"),
            new AquaColor(R.drawable.aqua_yuqinlan, "#126e82"),
            new AquaColor(R.drawable.aqua_qianniuhualan, "#1177b0"),
            new AquaColor(R.drawable.aqua_qingtinglan, "#3b818c"),
            new AquaColor(R.drawable.aqua_tianlan, "#1677b3"),
            new AquaColor(R.drawable.aqua_chaolan, "#2983bb"),
            new AquaColor(R.drawable.aqua_youlan, "#1781b5"),
            new AquaColor(R.drawable.aqua_baoshilan, "#2486b9"),
            new AquaColor(R.drawable.aqua_wanbolan, "#648e93"),
            new AquaColor(R.drawable.aqua_yuanweilan, "#158bb8"),
            new AquaColor(R.drawable.aqua_xiakeqing, "#869d9d"),
            new AquaColor(R.drawable.aqua_yunshanlan, "#2f90b9"),
            new AquaColor(R.drawable.aqua_jianniaolan, "#1491a8"),
            new AquaColor(R.drawable.aqua_cuilan, "#1e9eb3"),
            new AquaColor(R.drawable.aqua_gulan, "#1a94bc"),
            new AquaColor(R.drawable.aqua_qinglan, "#5698c3"),
            new AquaColor(R.drawable.aqua_danfanlan, "#0f95b0"),
            new AquaColor(R.drawable.aqua_haiqing, "#22a2c3"),
            new AquaColor(R.drawable.aqua_kongquelan, "#0eb0c9"),
            new AquaColor(R.drawable.aqua_biqing, "#5cb3cc"),
            new AquaColor(R.drawable.aqua_shanlan, "#7cabb1"),
            new AquaColor(R.drawable.aqua_dianzilan, "#10aec2"),
            new AquaColor(R.drawable.aqua_jianshilan, "#66a9c9"),
            new AquaColor(R.drawable.aqua_bingshanlan, "#a4aca7"),
            new AquaColor(R.drawable.aqua_weilan, "#29b7cb"),
            new AquaColor(R.drawable.aqua_pubulan, "#51c4d3"),
            new AquaColor(R.drawable.auqa_qingshanlan, "#8fb2c9"),
            new AquaColor(R.drawable.aqua_jiqing, "#63bbd0"),
            new AquaColor(R.drawable.aqua_qiubolan, "#8abcd1"),
            new AquaColor(R.drawable.aqua_qingshuilan, "#93d5dc"),
            new AquaColor(R.drawable.aqua_hushuilan, "#b0d5df"),
            new AquaColor(R.drawable.aqua_oulan, "#c7d2d4"),
            new AquaColor(R.drawable.aqua_jingtianlan, "#c3d7df"),
            new AquaColor(R.drawable.auqa_haitianlan, "#c6e6e8"),
            new AquaColor(R.drawable.aqua_yuantianlan, "#d0dfe6"),
    };

    private void initAquaCard1() {
        aquaColorList1.clear();
        for (int i = 0; i < 38; i += 2) {
            aquaColorList1.add(aquaColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(aquaColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }

    private void initAquaCard2() {
        aquaColorList2.clear();
        for (int i = 1; i < 38; i += 2) {
            aquaColorList2.add(aquaColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(aquaColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    String[] shiju = new String[]{"相与枕藉乎舟中,不知东方之既白","看花饮美酒,听鸟临晴山","上穷碧落下黄泉,两处茫茫皆不见","千里潇湘挼蓝浦,兰桡昔日曾经","上有青冥之长天,下有渌水之波澜","水色倒空青,林烟横积素","月白烟青水暗流,孤猿衔恨叫中秋","白枕垂云选梦,玉箫品月偷声","翻然一笑,不知东方既白","水绿天青不起尘,风光和暖胜三秦"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_aqua);
        toolbar1 = findViewById(R.id.toolbar_photo);

        ImageView imageView = findViewById(R.id.aqua_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaAqua.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout view = findViewById(R.id.picture);
        ImageButton imageButton1 = findViewById(R.id.button_shenhuilan);
        ImageButton imageButton2 = findViewById(R.id.button_huilan);
        ImageButton imageButton3 = findViewById(R.id.button_canglan);
        ImageButton imageButton4 = findViewById(R.id.button_tangcilan);
        ImageButton imageButton5 = findViewById(R.id.button_yuqinlan);
        ImageButton imageButton6 = findViewById(R.id.button_qianniuhualan);
        ImageButton imageButton7 = findViewById(R.id.button_qingtinglan);
        ImageButton imageButton8 = findViewById(R.id.button_tianlan);
        ImageButton imageButton9 = findViewById(R.id.button_chaolan);
        ImageButton imageButton10 = findViewById(R.id.button_youlan);
        ImageButton imageButton11 = findViewById(R.id.button_baoshilan);
        ImageButton imageButton12 = findViewById(R.id.button_wanbolan);
        ImageButton imageButton13 = findViewById(R.id.button_yuanweilan);
        ImageButton imageButton14 = findViewById(R.id.button_xiakeqing);
        ImageButton imageButton15 = findViewById(R.id.button_yunshanlan);
        ImageButton imageButton16 = findViewById(R.id.button_jianniaolan);
        ImageButton imageButton17 = findViewById(R.id.button_cuilan);
        ImageButton imageButton18 = findViewById(R.id.button_gulan);
        ImageButton imageButton19 = findViewById(R.id.button_qinglan);
        ImageButton imageButton20 = findViewById(R.id.button_danfanlan);
        ImageButton imageButton21 = findViewById(R.id.button_haiqing);
        ImageButton imageButton22 = findViewById(R.id.button_kongquelan);
        ImageButton imageButton23 = findViewById(R.id.button_biqing);
        ImageButton imageButton24 = findViewById(R.id.button_shanlan);
        ImageButton imageButton25 = findViewById(R.id.button_dianzilan);
        ImageButton imageButton26 = findViewById(R.id.button_jianshilan);
        ImageButton imageButton27 = findViewById(R.id.button_bingshanlan);
        ImageButton imageButton28 = findViewById(R.id.button_weilan);
        ImageButton imageButton29 = findViewById(R.id.button_pubulan);
        ImageButton imageButton30 = findViewById(R.id.button_qingshanlan);
        ImageButton imageButton31 = findViewById(R.id.button_jiqing);
        ImageButton imageButton32 = findViewById(R.id.button_qiubolan);
        ImageButton imageButton33 = findViewById(R.id.button_qingshuilan);
        ImageButton imageButton34 = findViewById(R.id.button_hushuilan);
        ImageButton imageButton35 = findViewById(R.id.button_oulan);
        ImageButton imageButton36 = findViewById(R.id.button_jingtianlan);
        ImageButton imageButton37 = findViewById(R.id.button_haitianlan);
        ImageButton imageButton38 = findViewById(R.id.button_yuantianlan);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(aquaColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[0].colorName));
                imageView.setImageResource(R.drawable.aqua_shenhuilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[1].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[1].colorName));
                imageView.setImageResource(R.drawable.aqua_huilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[2].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[2].colorName));
                imageView.setImageResource(R.drawable.aqua_canglan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[3].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[3].colorName));
                imageView.setImageResource(R.drawable.aqua_tangcilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[4].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[4].colorName));
                imageView.setImageResource(R.drawable.aqua_yuqinlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[5].colorName));
                imageView.setImageResource(R.drawable.aqua_qianniuhualan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[6].colorName));
                imageView.setImageResource(R.drawable.aqua_qingtinglan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[7].colorName));
                imageView.setImageResource(R.drawable.aqua_tianlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[8].colorName));
                imageView.setImageResource(R.drawable.aqua_chaolan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[9].colorName));
                imageView.setImageResource(R.drawable.aqua_youlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[10].colorName));
                imageView.setImageResource(R.drawable.aqua_baoshilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[11].colorName));
                imageView.setImageResource(R.drawable.aqua_wanbolan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[12].colorName));
                imageView.setImageResource(R.drawable.aqua_yuanweilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[13].colorName));
                imageView.setImageResource(R.drawable.aqua_xiakeqing);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[14].colorName));
                imageView.setImageResource(R.drawable.aqua_yunshanlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[15].colorName));
                imageView.setImageResource(R.drawable.aqua_jianniaolan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[16].colorName));
                imageView.setImageResource(R.drawable.aqua_cuilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[17].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[17].colorName));
                imageView.setImageResource(R.drawable.aqua_gulan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[18].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[18].colorName));
                imageView.setImageResource(R.drawable.aqua_qinglan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[19].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[19].colorName));
                imageView.setImageResource(R.drawable.aqua_danfanlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[20].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[20].colorName));
                imageView.setImageResource(R.drawable.aqua_haiqing);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[21].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[21].colorName));
                imageView.setImageResource(R.drawable.aqua_kongquelan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[22].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[22].colorName));
                imageView.setImageResource(R.drawable.aqua_biqing);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });
        imageButton24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(aquaColors[23].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[23].colorName));
                imageView.setImageResource(R.drawable.aqua_shanlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[24].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[24].colorName));
                imageView.setImageResource(R.drawable.aqua_dianzilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[25].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[25].colorName));
                imageView.setImageResource(R.drawable.aqua_jianshilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[26].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[26].colorName));
                imageView.setImageResource(R.drawable.aqua_bingshanlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[27].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[27].colorName));
                imageView.setImageResource(R.drawable.aqua_weilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[28].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[28].colorName));
                imageView.setImageResource(R.drawable.aqua_pubulan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[29].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[29].colorName));
                imageView.setImageResource(R.drawable.auqa_qingshanlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[30].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[30].colorName));
                imageView.setImageResource(R.drawable.aqua_jiqing);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[31].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[31].colorName));
                imageView.setImageResource(R.drawable.aqua_qiubolan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[32].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[32].colorName));
                imageView.setImageResource(R.drawable.aqua_qingshuilan);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });
        imageButton34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(aquaColors[33].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[33].colorName));
                imageView.setImageResource(R.drawable.aqua_hushuilan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[34].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[34].colorName));
                imageView.setImageResource(R.drawable.aqua_oulan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[35].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[35].colorName));
                imageView.setImageResource(R.drawable.aqua_jingtianlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[36].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[36].colorName));
                imageView.setImageResource(R.drawable.auqa_haitianlan);
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
                view.setBackgroundColor(Color.parseColor(aquaColors[37].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(aquaColors[37].colorName));
                imageView.setImageResource(R.drawable.aqua_yuantianlan);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });


        findViewById(R.id.ic_more).setOnClickListener(v -> BottomMenu.show(new String[]{"红", "黄", "蓝","棕", "绿", "茶", "水蓝", "紫", "黑白灰"})
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