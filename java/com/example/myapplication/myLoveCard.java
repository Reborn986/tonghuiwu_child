package com.example.myapplication;

import android.annotation.SuppressLint;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myLoveCard extends AppCompatActivity {
    //我的色卡，包括色卡取色和AI绘画收藏后的作品
    //涉及从后端获取作品及信息
    //但是写的很粗制滥造，你们可以想一下，参考一些现有的软件点赞收藏点评之类的，重新写一下
    private List<ImageCard> dataSource = new ArrayList<>();
    private CommonAdapter<ImageCard> adapter;
    private ImageButton back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_love_card);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        adapter = new CommonAdapter<ImageCard>(this, R.layout.item_card, dataSource) {
            @Override
            protected void convert(ViewHolder viewHolder, ImageCard picture, int i) {
                Glide.with(myLoveCard.this)
                        .load(picture.imageUrl)
                        .into((ImageView) viewHolder.getView(R.id.picture));
                if(picture.status == 1) {
                    viewHolder.setBackgroundRes(R.id.star, R.drawable.blue_point);
                    viewHolder.setText(R.id.star,"点赞！你真棒");
                    viewHolder.setTextColor(R.id.star,Color.parseColor("#FF445978"));
                }
                else
                    viewHolder.setBackgroundRes(R.id.star,R.drawable.blue_border);
            }
        };
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initData();

        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myLoveCard.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initData() {

        OkHttpClient client = new OkHttpClient();
        String url = "http://120.53.102.245:8000/get_child_images/"+ Login.currentUser.child_id+"/";
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String myResponse = response.body().string();

                    try {
                        JSONObject json = new JSONObject(myResponse);
                        JSONArray images = json.getJSONArray("images");
                        for (int i = images.length()-1; i >=0; i--) {
                            ImageCard imageCard = new ImageCard();
                            JSONArray imageItem = images.getJSONArray(i);
                            String imageUrl = "http://120.53.102.245:8000"+imageItem.getString(0);
                            int status = imageItem.getInt(1);
                            imageCard.imageUrl = imageUrl;
                            imageCard.status = status;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    dataSource.add(imageCard);
                                    adapter.notifyDataSetChanged();
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}