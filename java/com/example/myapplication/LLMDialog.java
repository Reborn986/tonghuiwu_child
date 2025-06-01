package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import java.io.Serializable;

public class LLMDialog implements Serializable {
    //为LLMActivity准备的类
    public String llm_text;
    public String person_text;
    public String time;
    private Drawable llm_image;
    private Drawable person_image;
    private boolean flag = false;
}
