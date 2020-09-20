package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent1 = getIntent();
        String data = intent1.getStringExtra("extra_data");
        Log.d("SecondActivity", data);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Intent intent = new Intent(Intent.ACTION_VIEW); //打开百度网页
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //Intent intent = new Intent(Intent.ACTION_DIAL); //使用电话拨打电话
                //intent.setData(Uri.parse("tel:10086"));
                //startActivity(intent);
                Intent intent = new Intent();//给上一个活动传数据
                intent.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}