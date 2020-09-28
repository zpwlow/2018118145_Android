package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {

    public static final String  TAGE = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new
                        Intent(SecondActivity.this,
                               MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAGE, "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAGE,"onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAGE,"onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAGE,"onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAGE,"onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAGE,"onRestart");
    }


}