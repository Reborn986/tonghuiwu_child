package com.example.myapplication;
//这是打开APP后第一个跳转的页面 登录
//注：该注册功能写的就是一坨，建议重写，写成一个单独的activity进行跳转
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Login extends AppCompatActivity {

    private int count = 0;   //用来判断密码输入错误次数

    String status = "";//登陆状态

    public static User currentUser = new User(); //用户，用于接收后端发送过来的用户信息

    OkHttpClient client = new OkHttpClient().newBuilder()
            .build(); //后面发请求用的

    String user = "admin";
    String password = "admin"; //输入的用户名和密码，admin为管理员用户密码，测试app用的

    @SuppressLint("ClickableViewAccessibility")

    //onCreate函数你可以理解为main函数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //这个是调取xml布局文件，UI的格式位置都是在activity_title.xml中定义的

        //注册按钮的点击事件
        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里注册页面的实现方法是我提前写好了一个LinearLayout，然后设置了不可见，点击注册按钮就变为可见
                //这个写的丑的要死，建议重写
                LinearLayout linearLayout = findViewById(R.id.view10);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        //这个是注册 确认按钮，确认完以后LinearLayout重新变为不可见， 然后发送数据到后端
        Button certain = (Button) findViewById(R.id.change_con);
        certain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postRegister();//发送注册数据
                resetData();//重置注册LinearLayout中 输入框的数值为空
                LinearLayout linearLayout = findViewById(R.id.view10);
                linearLayout.setVisibility(View.GONE);
            }
        });

        //这个是注册 重置按钮，作用是用户输入错误时可以全部清楚
        Button reset =(Button)findViewById(R.id.change_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {resetData();}
        });
        //你们应该可以发现，这个注册功能是没法返回回登录页面的，不想重新写个activity的话可以把返回加一下

        /*
         *****************这里是页面启动时的动画特效，目的是为了好看，视觉上更柔和*****************
        */
        // 获取linearLayout，该对象包括用户名框、密码框、登录、注册
        LinearLayout linearLayout = findViewById(R.id.linear);
        linearLayout.setAlpha(0f);//最开始设置透明度为0，即不可见
        // 获取LinearLayout对象，该对象包括上半的图片和字
        FrameLayout frameLayout = findViewById(R.id.frame);
        frameLayout.setAlpha(0f);//同理
        // 创建一个属性动画对象，设置动画的属性为 "translationY"，即垂直方向的平移，设置透明度从0到1，也就是逐渐出现
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(frameLayout, "alpha", 0f, 1f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(frameLayout, "translationY", -800f, 0f);
        // 设置动画的持续时间
        animator.setDuration(1000);
        animator3.setDuration(1500);
        // 启动动画
        animator.start();
        animator3.start();
        // 创建一个透明度动画，将 LinearLayout 的透明度从 0 渐变到 1
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(linearLayout, "alpha", 0f, 1f);
        // 设置动画的持续时间
        animator2.setDuration(1000);
        // 启动动画
        animator2.start();


        //获取用户名、密码和登录按钮的实例
        EditText accountET = findViewById(R.id.account);
        EditText passwordET = findViewById(R.id.password);
        Button login = findViewById(R.id.login);


        //登录按钮点击事件
        login.setOnClickListener(view -> {
            //获取输入框的用户名和密码
            user = accountET.getText().toString();
            password = passwordET.getText().toString();
            //为空警告
            if (user.isEmpty() || password.isEmpty()) {
                Toast.makeText(Login.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            } else {
                //同为admin为管理员 否则调用APILogin发送login请求，如果后端返回了登录成功
                if (user.equals("admin") && password.equals("admin") || APILogin(user, password)) {
                    //弹窗
                    Toast.makeText(Login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    //当前页面逐渐消失
                    ObjectAnimator animator11 = ObjectAnimator.ofFloat(frameLayout, "alpha", 1f, 0f);
                    ObjectAnimator animator12 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1f, 0f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    // 设置两个动画同时执行
                    animatorSet.playTogether(animator11, animator12);
                    // 设置动画的持续时间
                    animatorSet.setDuration(1000);
                    // 启动动画
                    animatorSet.start();

                    //跳转登陆后页面
                    Intent intent = new Intent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//这俩可以简单理解为：如果有该activity则直接跳转，避免重复创建很多MainActivity
                    intent.setClass(Login.this, MainActivity.class);//设置跳转到哪儿
                    startActivity(intent);
                    finish();
                }
                //如果登录失败则弹窗提醒
                else {
                    count += 1;
                    Toast.makeText(Login.this, "用户名或密码错误，登陆失败,已错误" + count + "次", Toast.LENGTH_SHORT).show();
                    if (count == 10) {
                        Toast.makeText(Login.this, "账户密码输入错误累计10次，已退出活动", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }

    private void resetData() {
        //清除注册页面的输入框中的值
        EditText Edit_name = findViewById(R.id.change_name);
        EditText Edit_bir = findViewById(R.id.change_birthday);
        EditText Edit_user = findViewById(R.id.change_user);
        EditText Edit_password = findViewById(R.id.change_password);
        Edit_user.setText("");
        Edit_name.setText("");
        Edit_bir.setText("");
        Edit_password.setText("");
    }

    private void postRegister() {
        //发送注册的post请求，post请求的格式比较统一，你们需要写的话可以从这复制过去改改就行
        EditText Edit_name = findViewById(R.id.change_name);
        EditText Edit_bir = findViewById(R.id.change_birthday);
        EditText Edit_user = findViewById(R.id.change_user);
        EditText Edit_password = findViewById(R.id.change_password);
        if(Edit_name.getText().toString().isEmpty()||Edit_bir.getText().toString().isEmpty()||Edit_user.getText().toString().isEmpty()||Edit_password.getText().toString().isEmpty()) {
            Toast.makeText(Login.this, "注册信息不可为空", Toast.LENGTH_SHORT).show();
            return;
        }

        int age =0;
        age = currentUser.getAge(Edit_bir.getText().toString());//age是调函数自动计算的
        int finalAge1 = age;

        Thread thread = new Thread(() -> {
            // 创建一个RequestBody对象，包含发送的数据
            RequestBody body = new FormBody.Builder()
                    .add("user_type","child")
                    .add("username", Edit_user.getText().toString())
                    .add("password", Edit_password.getText().toString())
                    .add("age", String.valueOf(finalAge1))
                    .add("birth_date",Edit_bir.getText().toString())
                    .build();
            // 创建一个Request对象
            Request request = new Request.Builder()
                    .url("http://120.53.102.245:8000/register/")
                    .post(body)
                    .build();
            //使用OkHttpClient发送请求
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(Login.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join(); // 主线程会等待thread线程执行完成后再继续执行
        } catch (InterruptedException e) {
            // 处理中断异常
            e.printStackTrace();
        }


    }

    public boolean APILogin(String user, String password) {
        //这里同理，是登录post请求
        System.out.println("User");
        Thread thread = new Thread(() -> {
            // 创建一个RequestBody对象，包含你要发送的数据
            RequestBody body = new FormBody.Builder()
                    .add("username", "mancheems")
                    .add("password", "mancheems")
                    .build();
            // 创建一个Request对象
            Request request = new Request.Builder()
                    .url("http://120.53.102.245:8000/login/")
                    .post(body)
                    .build();
            // 使用OkHttpClient发送请求
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    status = jsonObject.getString("status");
                    currentUser.initUser(
                            status,jsonObject.getString("name"),
                            jsonObject.getString("gender"),
                            jsonObject.getString("birth_date"),
                            jsonObject.getString("school"),
                            jsonObject.getString("class_name"),
                            Integer.parseInt(jsonObject.getString("usage_1")),
                            Integer.parseInt(jsonObject.getString("usage_2")),
                            Integer.parseInt(jsonObject.getString("usage_3")),
                            Integer.parseInt(jsonObject.getString("usage_4")),
                            Integer.parseInt(jsonObject.getString("usage_5")),
                            Integer.parseInt(jsonObject.getString("child_id")));

                    System.out.println("User"+currentUser.name);
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join(); // 主线程会等待thread线程执行完成后再继续执行，否则会导致信息还没获取到就跳转mainActivity然后显示出现错误
        } catch (InterruptedException e) {
            // 处理中断异常
            e.printStackTrace();
        }
        return status.equals("success");
    }

}