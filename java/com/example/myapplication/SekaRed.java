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

public class SekaRed extends AppCompatActivity {


        public class RedColor {
            private int imageId;
            private String colorName;

            public RedColor(int ImageId,String ColorName) {
                this.imageId = ImageId;
                this.colorName=ColorName;
            }

            public int getImageId() {
                return imageId;
            }
        }


    private List<RedColor> redColorList1 = new ArrayList<>();
    private List<RedColor> redColorList2 = new ArrayList<>();
    private LinearLayout toolbar1;

    private RedColor[] RedColors={
            new RedColor(R.drawable.red_dousha,"#481e1c"),
            new RedColor(R.drawable.red_tanzi,"#381924"),
            new RedColor(R.drawable.red_tanzi,"#381924"),
            new RedColor(R.drawable.red_putaojiuhong,"#62102e"),
            new RedColor(R.drawable.red_zaohong,"#7c1823"),
            new RedColor(R.drawable.red_zaohong,"#7c1823"),
            new RedColor(R.drawable.red_anziyuanhong,"#82202b"),
            new RedColor(R.drawable.red_yinhong,"#82111f"),
            new RedColor(R.drawable.red_zheshi,"#862617"),
            new RedColor(R.drawable.red_xiancaihong,"#a61b29"),
            new RedColor(R.drawable.red_dandousha,"#873d24"),
            new RedColor(R.drawable.red_yanhong_12,"#894e54"),
            new RedColor(R.drawable.red_fupenzihong,"#ac1f18"),
            new RedColor(R.drawable.red_manjianghong,"#a7535a"),
            new RedColor(R.drawable.red_exueshihong,"#ab372f"),
            new RedColor(R.drawable.red_gaolianghong,"#c02c38"),
            new RedColor(R.drawable.red_fengyehong,"#c21f30"),
            new RedColor(R.drawable.red_jianjingyuhong,"#cc163a"),
            new RedColor(R.drawable.red_eguanhong,"#d11a2d"),
            new RedColor(R.drawable.red_hedinghong,"#d42517"),
            new RedColor(R.drawable.red_tangchangpuhong,"#de1c31"),
            new RedColor(R.drawable.red_ganhong,"#a6522c"),
            new RedColor(R.drawable.red_jinkuihong,"#bf3553"),
            new RedColor(R.drawable.red_xiemaohong,"#b14b28"),
            new RedColor(R.drawable.red_luoxiahong,"#cf4813"),
            new RedColor(R.drawable.red_xiyanghong,"#de2a18"),
            new RedColor(R.drawable.red_qiuhaitanghong,"#ec2b24"),
            new RedColor(R.drawable.red_yingtaohong,"#ed3321"),
            new RedColor(R.drawable.red_lichunhong,"#eb261a"),
            new RedColor(R.drawable.red_goushuhong,"#ed3333"),
            new RedColor(R.drawable.red_yusaihong,"#ed3b2f"),
            new RedColor(R.drawable.red_jiguanghong,"#f33b1f"),
            new RedColor(R.drawable.red_luobohong,"#f13c22"),
            new RedColor(R.drawable.red_yanzhihong,"#f03f24"),
            new RedColor(R.drawable.red_yuhong,"#c04851"),
            new RedColor(R.drawable.red_meiguizi,"#ba2f7b"),
            new RedColor(R.drawable.red_meiguihong,"#d2357d"),
            new RedColor(R.drawable.red_danshuhong,"#ee2746"),
            new RedColor(R.drawable.red_haitanghong,"#f03752"),
            new RedColor(R.drawable.red_zijinghong,"#ee2c79"),
            new RedColor(R.drawable.red_bogenhong,"#d13c74"),
            new RedColor(R.drawable.red_yuejihong,"#ce5777"),
            new RedColor(R.drawable.red_longxvhong,"#cc5595"),
            new RedColor(R.drawable.red_meihong,"#c45a65"),
            new RedColor(R.drawable.red_huozhuanhong,"#cd6227"),
            new RedColor(R.drawable.red_taocihong,"#e16723"),
            new RedColor(R.drawable.red_yujinhong,"#cf7543"),
            new RedColor(R.drawable.red_shanhuhong,"#f04a3a"),
            new RedColor(R.drawable.red_dahong,"#f04b22"),
            new RedColor(R.drawable.red_danshuhong_2,"#ed4845"),
            new RedColor(R.drawable.red_honggonghong,"#f23e23"),
            new RedColor(R.drawable.red_chahuahong,"#ee3f4d"),
            new RedColor(R.drawable.red_qingtinghong,"#f1441d"),
            new RedColor(R.drawable.red_tieshuihong,"#f5391c"),
            new RedColor(R.drawable.red_liuhuahong,"#f34718"),
            new RedColor(R.drawable.red_shihong,"#f2481b"),
            new RedColor(R.drawable.red_yinzhu,"#f43e06"),
            new RedColor(R.drawable.red_dianqishihong,"#c35691"),
            new RedColor(R.drawable.red_xidanhong,"#ec2c64"),
            new RedColor(R.drawable.red_wenpohong,"#ed2f6a"),
            new RedColor(R.drawable.red_yanhanhong,"#fc6315"),
            new RedColor(R.drawable.red_nenlinghong,"#de3f7c"),
            new RedColor(R.drawable.red_longjingyuhong,"#ef632b"),
            new RedColor(R.drawable.red_pingguohong,"#f15642"),
            new RedColor(R.drawable.red_danruixianghong,"#ee4866"),
            new RedColor(R.drawable.red_danzihong,"#d2568c"),
            new RedColor(R.drawable.red_zhuhong,"#ed5126"),
            new RedColor(R.drawable.red_guihong,"#f25a47"),
            new RedColor(R.drawable.red_meijianghong,"#fa5d19"),
            new RedColor(R.drawable.red_quhong,"#f05a46"),
            new RedColor(R.drawable.red_shizhuhong,"#ee4863"),
            new RedColor(R.drawable.red_lianbanhong,"#ea517f"),
            new RedColor(R.drawable.red_pinhong,"#ef3473"),
            new RedColor(R.drawable.red_xiekehong,"#f27635"),
            new RedColor(R.drawable.red_furonghong,"#f9723d"),
            new RedColor(R.drawable.red_boluohong,"#fc7930"),
            new RedColor(R.drawable.red_caomeihong,"#ef6f48"),
            new RedColor(R.drawable.red_caomolihong,"#ef475d"),
            new RedColor(R.drawable.red_shanchahong,"#ed556a"),
            new RedColor(R.drawable.red_canghuahong,"#ec2d7a"),
            new RedColor(R.drawable.red_biandouhuahong,"#ef498b"),
            new RedColor(R.drawable.red_tuyanhong,"#ec4e8a"),
            new RedColor(R.drawable.red_yanhong_81,"#ed5a65"),
            new RedColor(R.drawable.red_guqiaohong,"#f17666"),
            new RedColor(R.drawable.red_jiazhutaohong,"#eb507e"),
            new RedColor(R.drawable.red_diaozhonghuahong,"#ce5e8a"),
            new RedColor(R.drawable.red_zuojiangcaohong,"#c5708b"),
            new RedColor(R.drawable.red_shanlidouhong,"#c27c88"),
            new RedColor(R.drawable.red_faluohong,"#ee8055"),
            new RedColor(R.drawable.red_guaranghong,"#f68c60"),
          //  new SekaRed.RedColor(R.drawable.red_chenxihong,"#ea8958"),
            new RedColor(R.drawable.red_yeqiangweihong,"#fb9968"),
            new RedColor(R.drawable.red_danqianhong,"#e77c8e"),
            new RedColor(R.drawable.red_danjianghong,"#ec7696"),
            new RedColor(R.drawable.red_lingmenghong,"#d276a3"),
            new RedColor(R.drawable.red_guiyuhong,"#f09c5a"),
            new RedColor(R.drawable.red_xiangyehong,"#f07c82"),
            new RedColor(R.drawable.red_chuhehong,"#e16c96"),
            new RedColor(R.drawable.red_fengxianhuahong,"#ea7293"),
            new RedColor(R.drawable.red_baijihong,"#de7897"),
            new RedColor(R.drawable.red_xiaguanghong,"#ef82a0"),
            new RedColor(R.drawable.red_baochunhong,"#ec8aa4"),
            new RedColor(R.drawable.red_liuzihong,"#f1908c"),
            new RedColor(R.drawable.red_shehong,"#f19790"),
            new RedColor(R.drawable.red_chunmeihong,"#f1939c"),
            new RedColor(R.drawable.red_dancanghuahong,"#f6ad8f"),
            new RedColor(R.drawable.red_danyingsuhong,"#eea08c"),
            new RedColor(R.drawable.red_guarangfen,"#f9cb8b"),
            new RedColor(R.drawable.red_fentuanhuahong,"#ec9bad"),
            new RedColor(R.drawable.red_jiangdouhong,"#ed9db2"),
            new RedColor(R.drawable.red_shaoyaogenghong,"#eba0b3"),
            new RedColor(R.drawable.red_jiahong,"#eeaa9c"),
            new RedColor(R.drawable.red_yufenhong,"#e8b49a"),
            new RedColor(R.drawable.red_taohong,"#f0ada0"),
            new RedColor(R.drawable.red_mudanfenhong,"#eea2a4"),
            new RedColor(R.drawable.red_hehuanhong,"#f0a1a8"),
            new RedColor(R.drawable.red_wuhuaguohong,"#efafad"),
            new RedColor(R.drawable.red_ouhe,"#edc3ae"),
            new RedColor(R.drawable.red_jinghong,"#eea6b7"),
            new RedColor(R.drawable.red_fenhong,"#f2b9b2"),
            new RedColor(R.drawable.red_jianghong,"#eeb8c3"),
            new RedColor(R.drawable.red_runhong,"#f7cdbc"),
            new RedColor(R.drawable.red_dantaohong,"#f6cec1"),
            new RedColor(R.drawable.red_yangshuixianhong,"#f4c7ba"),
            new RedColor(R.drawable.red_shuihong,"#f1c4cd"),
            new RedColor(R.drawable.red_shiruihong,"#f0c9cf"),
            new RedColor(R.drawable.red_jiekedanfen,"#f7cfba"),
            new RedColor(R.drawable.red_jifenhong,"#e6d2d5"),
            new RedColor(R.drawable.red_danfei,"#f2cac9"),
            new RedColor(R.drawable.red_chutaofenhong,"#f6dcce"),
            new RedColor(R.drawable.red_zhilanzi,"#e9ccd3"),
            new RedColor(R.drawable.red_luoyingdanfen,"#f9e8d0"),
            new RedColor(R.drawable.red_caozhuhong,"#f8ebe6"),
            new RedColor(R.drawable.red_danmifen,"#fbeee2"),
    };


    private void initRedCard1() {
        redColorList1.clear();
        for (int i = 0; i <129; i+=2) {
            redColorList1.add(RedColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color = Color.parseColor(RedColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }
    private void initRedCard2() {
        redColorList2.clear();
        for (int i = 1; i <129; i+=2) {
            redColorList2.add(RedColors[i]);
            CardView cardView = findViewById(R.id.blue_cardview);
            int finalI = i;
            cardView.setOnClickListener(v -> {
                // 处理点击事件的逻辑
                int color =Color.parseColor(RedColors[finalI].colorName);
                toolbar1.setBackgroundColor(Color.parseColor("#87CEFA"));
            });
        }
    }

    String[] shiju = new String[]{"竹外桃花三两枝,春江水暖鸭先知", "贡里泉清,铅中火赫", "蕉红荔子佛手黄,榴花洞闭蓉山荒", "头昏腿脚一身黄,翅滑牙红促织王", "落花纷纷稍觉多,美人欲醉朱颜酡", "回望还迷堤柳绿,回来才辨谢梅红", "红色鲜于二月中,分明姹紫胜嫣红", "夜雨染成天水碧,朝阳借出胭脂色", "众中唤做百宜娇,诗里装成十样锦", "欲知菡萏色,但请看芙蓉", "堂下朱阑小魏红,一枝浓艳占春风", "美人背着内园中,犹自风流着褪红", "见说朱樱正及时,眼穿火齐晓云披", "杨妃醉醒晕犹在,顺圣名高价尽低", "职司虽翰墨,佩服已银朱", "官谷窑成重霁红,最难全美费良工", "烂漫花棚锦绣窠,海天霞色上轻罗"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seka_red);


        toolbar1 = findViewById(R.id.toolbar_photo);

        ImageView imageView=findViewById(R.id.red_im);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imb_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekaRed.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout view=findViewById(R.id.picture);

        ImageButton imageButton1=findViewById(R.id.button_dousha);
        ImageButton imageButton5=findViewById(R.id.button_putaojiuhong);
        ImageButton imageButton6=findViewById(R.id.button_zaohong);
        ImageButton imageButton7=findViewById(R.id.button_anziyuanhong);
        ImageButton imageButton8=findViewById(R.id.button_yinhong);
        ImageButton imageButton9=findViewById(R.id.button_zheshi);
        ImageButton imageButton10=findViewById(R.id.button_xiancaihong);
        ImageButton imageButton11=findViewById(R.id.button_dandousha);
        ImageButton imageButton12=findViewById(R.id.button_yanhong_12);
        ImageButton imageButton13=findViewById(R.id.button_fupenzihong);
        ImageButton imageButton14=findViewById(R.id.button_manjianghong);
        ImageButton imageButton15=findViewById(R.id.button_exueshihong);
        ImageButton imageButton16=findViewById(R.id.button_gaolianghong);
        ImageButton imageButton17=findViewById(R.id.button_fengyehong);
        ImageButton imageButton18=findViewById(R.id.button_jianjingyuhong);
        ImageButton imageButton19=findViewById(R.id.button_eguanhong);
        ImageButton imageButton20=findViewById(R.id.button_hedinghong);
        ImageButton imageButton21=findViewById(R.id.button_tangchangpuhong);
        ImageButton imageButton22=findViewById(R.id.button_ganhong);
        ImageButton imageButton23=findViewById(R.id.button_jinkuihong);
        ImageButton imageButton24=findViewById(R.id.button_xiemaohong);
        ImageButton imageButton25=findViewById(R.id.button_luoxiahong);
        ImageButton imageButton26=findViewById(R.id.button_xiyanghong);
        ImageButton imageButton27=findViewById(R.id.button_qiuhaitanghong);
        ImageButton imageButton28=findViewById(R.id.button_yingtaohong);
        ImageButton imageButton29=findViewById(R.id.button_lichunhong);
        ImageButton imageButton30=findViewById(R.id.button_goushuhong);
        ImageButton imageButton31=findViewById(R.id.button_yusaihong);
        ImageButton imageButton32=findViewById(R.id.button_jiguanghong);
        ImageButton imageButton33=findViewById(R.id.button_luobohong);
        ImageButton imageButton34=findViewById(R.id.button_yanzhihong);
        ImageButton imageButton35=findViewById(R.id.button_yuhong);
        ImageButton imageButton37=findViewById(R.id.button_meiguihong);
        ImageButton imageButton38=findViewById(R.id.button_danshuhong);
        ImageButton imageButton39=findViewById(R.id.button_haitanghong);
        ImageButton imageButton40=findViewById(R.id.button_zijinghong);
        ImageButton imageButton41=findViewById(R.id.button_bogenhong);
        ImageButton imageButton42=findViewById(R.id.button_yuejihong);
        ImageButton imageButton43=findViewById(R.id.button_longxvhong);
        ImageButton imageButton44=findViewById(R.id.button_meihong);
        ImageButton imageButton45=findViewById(R.id.button_huozhuanhong);
        ImageButton imageButton46=findViewById(R.id.button_taocihong);
        ImageButton imageButton47=findViewById(R.id.button_yujinhong);
        ImageButton imageButton48=findViewById(R.id.button_shanhuhong);
        ImageButton imageButton49=findViewById(R.id.button_dahong);
        ImageButton imageButton50=findViewById(R.id.button_danshuhong_2);
        ImageButton imageButton51=findViewById(R.id.button_honggonghong);
        ImageButton imageButton52=findViewById(R.id.button_chahuahong);
        ImageButton imageButton53=findViewById(R.id.button_qingtinghong);
        ImageButton imageButton54=findViewById(R.id.button_tieshuihong);
        ImageButton imageButton55=findViewById(R.id.button_liuhuahong);
        ImageButton imageButton56=findViewById(R.id.button_shihong);
        ImageButton imageButton57=findViewById(R.id.button_yinzhu);
        ImageButton imageButton58=findViewById(R.id.button_dianqishihong);
        ImageButton imageButton59=findViewById(R.id.button_xidanhong);
        ImageButton imageButton60=findViewById(R.id.button_wenpohong);
        ImageButton imageButton61=findViewById(R.id.button_yanhanhong);
        ImageButton imageButton62=findViewById(R.id.button_nenlinghong);
        ImageButton imageButton63=findViewById(R.id.button_longjingyuhong);
        ImageButton imageButton64=findViewById(R.id.button_pingguohong);
        ImageButton imageButton65=findViewById(R.id.button_danruixianghong);
        ImageButton imageButton66=findViewById(R.id.button_danzihong);
        ImageButton imageButton67=findViewById(R.id.button_zhuhong);
        ImageButton imageButton68=findViewById(R.id.button_guihong);
        ImageButton imageButton69=findViewById(R.id.button_meijianghong);
        ImageButton imageButton70=findViewById(R.id.button_quhong);
        ImageButton imageButton71=findViewById(R.id.button_shizhuhong);
        ImageButton imageButton72=findViewById(R.id.button_lianbanhong);
        ImageButton imageButton73=findViewById(R.id.button_pinhong);
        ImageButton imageButton74=findViewById(R.id.button_xiekehong);
        ImageButton imageButton75=findViewById(R.id.button_furonghong);
        ImageButton imageButton76=findViewById(R.id.button_boluohong);
        ImageButton imageButton77=findViewById(R.id.button_caomeihong);
        ImageButton imageButton78=findViewById(R.id.button_caomolihong);
        ImageButton imageButton79=findViewById(R.id.button_shanchahong);
        ImageButton imageButton80=findViewById(R.id.button_canghuahong);
        ImageButton imageButton81=findViewById(R.id.button_biandouhuahong);
        ImageButton imageButton82=findViewById(R.id.button_tuyanhong);
        ImageButton imageButton83=findViewById(R.id.button_yanhong_81);
        ImageButton imageButton84=findViewById(R.id.button_guqiaohong);
        ImageButton imageButton85=findViewById(R.id.button_jiazhutaohong);
        ImageButton imageButton86=findViewById(R.id.button_diaozhonghuahong);
        ImageButton imageButton87=findViewById(R.id.button_zuojiangcaohong);
        ImageButton imageButton88=findViewById(R.id.button_shanlidouhong);
        ImageButton imageButton89=findViewById(R.id.button_faluohong);
        ImageButton imageButton90=findViewById(R.id.button_guaranghong);
        ImageButton imageButton91=findViewById(R.id.button_yeqiangweihong);
        ImageButton imageButton92=findViewById(R.id.button_danqianhong);
        ImageButton imageButton93=findViewById(R.id.button_danjianghong);
        ImageButton imageButton94=findViewById(R.id.button_lingmenghong);
        ImageButton imageButton95=findViewById(R.id.button_guiyuhong);
        ImageButton imageButton96=findViewById(R.id.button_xiangyehong);
        ImageButton imageButton97=findViewById(R.id.button_chuhehong);
        ImageButton imageButton98=findViewById(R.id.button_fengxianhuahong);
        ImageButton imageButton99=findViewById(R.id.button_baijihong);
        ImageButton imageButton100=findViewById(R.id.button_xiaguanghong);
        ImageButton imageButton101=findViewById(R.id.button_baochunhong);
        ImageButton imageButton102=findViewById(R.id.button_liuzihong);
        ImageButton imageButton103=findViewById(R.id.button_shehong);
        ImageButton imageButton104=findViewById(R.id.button_chunmeihong);
        ImageButton imageButton105=findViewById(R.id.button_dancanghuahong);
        ImageButton imageButton106=findViewById(R.id.button_danyingsuhong);
        ImageButton imageButton107=findViewById(R.id.button_guarangfen);
        ImageButton imageButton108=findViewById(R.id.button_fentuanhuahong);
        ImageButton imageButton109=findViewById(R.id.button_jiangdouhong);
        ImageButton imageButton110=findViewById(R.id.button_shaoyaogenghong);
        ImageButton imageButton111=findViewById(R.id.button_jiahong);
        ImageButton imageButton112=findViewById(R.id.button_yufenhong);
        ImageButton imageButton113=findViewById(R.id.button_taohong);
        ImageButton imageButton114=findViewById(R.id.button_mudanfenhong);
        ImageButton imageButton115=findViewById(R.id.button_hehuanhong);
        ImageButton imageButton116=findViewById(R.id.button_wuhuaguohong);
        ImageButton imageButton117=findViewById(R.id.button_ouhe);
        ImageButton imageButton118=findViewById(R.id.button_jinghong);
        ImageButton imageButton119=findViewById(R.id.button_fenhong);
        ImageButton imageButton120=findViewById(R.id.button_jianghong);
        ImageButton imageButton121=findViewById(R.id.button_runhong);
        ImageButton imageButton122=findViewById(R.id.button_dantaohong);
        ImageButton imageButton123=findViewById(R.id.button_yangshuixianhong);
        ImageButton imageButton124=findViewById(R.id.button_shuihong);
        ImageButton imageButton125=findViewById(R.id.button_shiruihong);
        ImageButton imageButton126=findViewById(R.id.button_jiekedanfen);
        ImageButton imageButton127=findViewById(R.id.button_jifenhong);
        ImageButton imageButton128=findViewById(R.id.button_danfei);
        ImageButton imageButton129=findViewById(R.id.button_chutaofenhong);
        ImageButton imageButton131=findViewById(R.id.button_luoyingdanfen);
        ImageButton imageButton132=findViewById(R.id.button_caozhuhong);
        ImageButton imageButton133=findViewById(R.id.button_danmifen);





        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[0].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[0].colorName));
                imageView.setImageResource(R.drawable.red_dousha);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
                }
        });





        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[4].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[4].colorName));
                imageView.setImageResource(R.drawable.red_putaojiuhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[5].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[5].colorName));
                imageView.setImageResource(R.drawable.red_zaohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[6].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[6].colorName));
                imageView.setImageResource(R.drawable.red_anziyuanhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[7].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[7].colorName));
                imageView.setImageResource(R.drawable.red_yinhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[8].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[8].colorName));
                imageView.setImageResource(R.drawable.red_zheshi);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[9].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[9].colorName));
                imageView.setImageResource(R.drawable.red_xiancaihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[10].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[10].colorName));
                imageView.setImageResource(R.drawable.red_dandousha);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[11].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[11].colorName));
                imageView.setImageResource(R.drawable.red_yanhong_12);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[12].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[12].colorName));
                imageView.setImageResource(R.drawable.red_fupenzihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[13].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[13].colorName));
                imageView.setImageResource(R.drawable.red_manjianghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[14].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[14].colorName));
                imageView.setImageResource(R.drawable.red_exueshihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[15].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[15].colorName));
                imageView.setImageResource(R.drawable.red_gaolianghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[16].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[16].colorName));
                imageView.setImageResource(R.drawable.red_fengyehong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[17].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[17].colorName));
                imageView.setImageResource(R.drawable.red_jianjingyuhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[18].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[18].colorName));
                imageView.setImageResource(R.drawable.red_eguanhong); TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[19].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[19].colorName));
                imageView.setImageResource(R.drawable.red_hedinghong); TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);
            }
        });

        imageButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[20].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[20].colorName));
                imageView.setImageResource(R.drawable.red_tangchangpuhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[21].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[21].colorName));
                imageView.setImageResource(R.drawable.red_ganhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[22].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[22].colorName));
                imageView.setImageResource(R.drawable.red_jinkuihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[23].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[23].colorName));
                imageView.setImageResource(R.drawable.red_xiemaohong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[24].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[24].colorName));
                imageView.setImageResource(R.drawable.red_luoxiahong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[25].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[25].colorName));
                imageView.setImageResource(R.drawable.red_xiyanghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[26].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[26].colorName));
                imageView.setImageResource(R.drawable.red_qiuhaitanghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[27].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[27].colorName));
                imageView.setImageResource(R.drawable.red_yingtaohong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[28].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[28].colorName));
                imageView.setImageResource(R.drawable.red_lichunhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[29].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[29].colorName));
                imageView.setImageResource(R.drawable.red_goushuhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[30].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[30].colorName));
                imageView.setImageResource(R.drawable.red_yusaihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[31].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[31].colorName));
                imageView.setImageResource(R.drawable.red_jiguanghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[32].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[32].colorName));
                imageView.setImageResource(R.drawable.red_luobohong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[33].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[33].colorName));
                imageView.setImageResource(R.drawable.red_yanzhihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[34].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[34].colorName));
                imageView.setImageResource(R.drawable.red_yuhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[36].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[36].colorName));
                imageView.setImageResource(R.drawable.red_meiguihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[37].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[37].colorName));
                imageView.setImageResource(R.drawable.red_danshuhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[38].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[38].colorName));
                imageView.setImageResource(R.drawable.red_haitanghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[39].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[39].colorName));
                imageView.setImageResource(R.drawable.red_zijinghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[40].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[40].colorName));
                imageView.setImageResource(R.drawable.red_bogenhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[41].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[41].colorName));
                imageView.setImageResource(R.drawable.red_yuejihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[42].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[42].colorName));
                imageView.setImageResource(R.drawable.red_longxvhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[43].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[43].colorName));
                imageView.setImageResource(R.drawable.red_meihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[44].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[44].colorName));
                imageView.setImageResource(R.drawable.red_huozhuanhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[45].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[45].colorName));
                imageView.setImageResource(R.drawable.red_taocihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[46].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[46].colorName));
                imageView.setImageResource(R.drawable.red_yujinhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[47].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[47].colorName));
                imageView.setImageResource(R.drawable.red_shanhuhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[48].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[48].colorName));
                imageView.setImageResource(R.drawable.red_dahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[49].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[49].colorName));
                imageView.setImageResource(R.drawable.red_danshuhong_2);
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
                view.setBackgroundColor(Color.parseColor(RedColors[50].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[50].colorName));
                imageView.setImageResource(R.drawable.red_honggonghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[51].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[51].colorName));
                imageView.setImageResource(R.drawable.red_chahuahong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[52].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[52].colorName));
                imageView.setImageResource(R.drawable.red_qingtinghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[53].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[53].colorName));
                imageView.setImageResource(R.drawable.red_tieshuihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[54].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[54].colorName));
                imageView.setImageResource(R.drawable.red_liuhuahong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[55].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[55].colorName));
                imageView.setImageResource(R.drawable.red_shihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[56].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[56].colorName));
                imageView.setImageResource(R.drawable.red_yinzhu);
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
                view.setBackgroundColor(Color.parseColor(RedColors[57].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[57].colorName));
                imageView.setImageResource(R.drawable.red_dianqishihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[58].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[58].colorName));
                imageView.setImageResource(R.drawable.red_xidanhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[59].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[59].colorName));
                imageView.setImageResource(R.drawable.red_wenpohong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[60].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[60].colorName));
                imageView.setImageResource(R.drawable.red_yanhanhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[61].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[61].colorName));
                imageView.setImageResource(R.drawable.red_nenlinghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[62].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[62].colorName));
                imageView.setImageResource(R.drawable.red_longjingyuhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[63].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[63].colorName));
                imageView.setImageResource(R.drawable.red_pingguohong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[64].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[64].colorName));
                imageView.setImageResource(R.drawable.red_danruixianghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[65].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[65].colorName));
                imageView.setImageResource(R.drawable.red_danzihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[66].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[66].colorName));
                imageView.setImageResource(R.drawable.red_zhuhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[67].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[67].colorName));
                imageView.setImageResource(R.drawable.red_guihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[68].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[68].colorName));
                imageView.setImageResource(R.drawable.red_meijianghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[69].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[69].colorName));
                imageView.setImageResource(R.drawable.red_quhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[70].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[70].colorName));
                imageView.setImageResource(R.drawable.red_shizhuhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[71].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[71].colorName));
                imageView.setImageResource(R.drawable.red_lianbanhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[72].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[72].colorName));
                imageView.setImageResource(R.drawable.red_pinhong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[73].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[73].colorName));
                imageView.setImageResource(R.drawable.red_xiekehong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[74].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[74].colorName));
                imageView.setImageResource(R.drawable.red_furonghong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[75].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[75].colorName));
                imageView.setImageResource(R.drawable.red_boluohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[76].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[76].colorName));
                imageView.setImageResource(R.drawable.red_caomeihong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[77].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[77].colorName));
                imageView.setImageResource(R.drawable.red_caomolihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[78].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[78].colorName));
                imageView.setImageResource(R.drawable.red_shanchahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[79].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[79].colorName));
                imageView.setImageResource(R.drawable.red_canghuahong);
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
                view.setBackgroundColor(Color.parseColor(RedColors[80].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[80].colorName));
                imageView.setImageResource(R.drawable.red_biandouhuahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[81].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[81].colorName));
                imageView.setImageResource(R.drawable.red_tuyanhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[82].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[82].colorName));
                imageView.setImageResource(R.drawable.red_yanhong_81);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[83].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[83].colorName));
                imageView.setImageResource(R.drawable.red_guqiaohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[84].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[84].colorName));
                imageView.setImageResource(R.drawable.red_jiazhutaohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[85].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[85].colorName));
                imageView.setImageResource(R.drawable.red_diaozhonghuahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[86].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[86].colorName));
                imageView.setImageResource(R.drawable.red_zuojiangcaohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[87].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[87].colorName));
                imageView.setImageResource(R.drawable.red_shanlidouhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton89.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[88].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[88].colorName));
                imageView.setImageResource(R.drawable.red_faluohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[89].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[89].colorName));
                imageView.setImageResource(R.drawable.red_guaranghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[90].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[90].colorName));
                imageView.setImageResource(R.drawable.red_yeqiangweihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[91].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[91].colorName));
                imageView.setImageResource(R.drawable.red_danqianhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton93.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[92].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[92].colorName));
                imageView.setImageResource(R.drawable.red_danjianghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton94.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[93].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[93].colorName));
                imageView.setImageResource(R.drawable.red_lingmenghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[94].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[94].colorName));
                imageView.setImageResource(R.drawable.red_guiyuhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton96.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[95].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[95].colorName));
                imageView.setImageResource(R.drawable.red_xiangyehong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton97.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[96].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[96].colorName));
                imageView.setImageResource(R.drawable.red_chuhehong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[97].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[97].colorName));
                imageView.setImageResource(R.drawable.red_fengxianhuahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[98].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[98].colorName));
                imageView.setImageResource(R.drawable.red_baijihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[99].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[99].colorName));
                imageView.setImageResource(R.drawable.red_xiaguanghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[100].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[100].colorName));
                imageView.setImageResource(R.drawable.red_baochunhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[101].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[101].colorName));
                imageView.setImageResource(R.drawable.red_liuzihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[102].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[102].colorName));
                imageView.setImageResource(R.drawable.red_shehong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[103].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[103].colorName));
                imageView.setImageResource(R.drawable.red_chunmeihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[104].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[104].colorName));
                imageView.setImageResource(R.drawable.red_dancanghuahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[105].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[105].colorName));
                imageView.setImageResource(R.drawable.red_danyingsuhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[106].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[106].colorName));
                imageView.setImageResource(R.drawable.red_guarangfen);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[107].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[107].colorName));
                imageView.setImageResource(R.drawable.red_fentuanhuahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton109.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[108].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[108].colorName));
                imageView.setImageResource(R.drawable.red_jiangdouhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[109].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[109].colorName));
                imageView.setImageResource(R.drawable.red_shaoyaogenghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[110].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[110].colorName));
                imageView.setImageResource(R.drawable.red_jiahong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[111].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[111].colorName));
                imageView.setImageResource(R.drawable.red_yufenhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton113.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[112].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[112].colorName));
                imageView.setImageResource(R.drawable.red_taohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton114.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[114].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[114].colorName));
                imageView.setImageResource(R.drawable.red_mudanfenhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[114].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[114].colorName));
                imageView.setImageResource(R.drawable.red_hehuanhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[115].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[115].colorName));
                imageView.setImageResource(R.drawable.red_wuhuaguohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton117.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[116].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[116].colorName));
                imageView.setImageResource(R.drawable.red_ouhe);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[117].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[117].colorName));
                imageView.setImageResource(R.drawable.red_jinghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[118].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[118].colorName));
                imageView.setImageResource(R.drawable.red_fenhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton120.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[119].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[119].colorName));
                imageView.setImageResource(R.drawable.red_jianghong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton121.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[120].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[120].colorName));
                imageView.setImageResource(R.drawable.red_runhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[121].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[121].colorName));
                imageView.setImageResource(R.drawable.red_dantaohong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[122].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[122].colorName));
                imageView.setImageResource(R.drawable.red_yangshuixianhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton124.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[123].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[123].colorName));
                imageView.setImageResource(R.drawable.red_shuihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton125.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[124].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[124].colorName));
                imageView.setImageResource(R.drawable.red_shiruihong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton126.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[125].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[125].colorName));
                imageView.setImageResource(R.drawable.red_jiekedanfen);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton127.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[126].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[126].colorName));
                imageView.setImageResource(R.drawable.red_jifenhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton128.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[127].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[127].colorName));
                imageView.setImageResource(R.drawable.red_danfei);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton129.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[128].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[128].colorName));
                imageView.setImageResource(R.drawable.red_chutaofenhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);}
        });

        imageButton131.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[130].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[130].colorName));
                imageView.setImageResource(R.drawable.red_luoyingdanfen);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString);  }
        });

        imageButton132.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[131].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[131].colorName));
                imageView.setImageResource(R.drawable.red_caozhuhong);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
        });

        imageButton133.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.parseColor(RedColors[132].colorName));
                toolbar1.setBackgroundColor(Color.parseColor(RedColors[132].colorName));
                imageView.setImageResource(R.drawable.red_danmifen);
                TextView tShiju = findViewById(R.id.t_shiju);
                tShiju.setVisibility(View.VISIBLE);
                Random random = new Random();
                int index = random.nextInt(shiju.length);
                String randomString = shiju[index];
                tShiju.setText(randomString); }
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