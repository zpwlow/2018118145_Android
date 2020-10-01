package com.example.uiwindowtest;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

class TitleLayout extends LinearLayout {

    private ImageView imageView;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button titleBack = (Button)findViewById(R.id.title_back);
        Button titlenext = (Button) findViewById(R.id.title_next);
        imageView = (ImageView) findViewById(R.id.image_view);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
        titlenext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"您点击下一步按钮",
                               Toast.LENGTH_SHORT).show();
            }
        });
    }
}
