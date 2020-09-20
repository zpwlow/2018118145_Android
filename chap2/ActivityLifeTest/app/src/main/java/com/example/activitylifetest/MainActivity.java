package com.example.activitylifetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        if(savedInstanceState !=null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG,tempData);
        }
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        Button startThreeActivity = (Button) findViewById(R.id.start_Three_activity);
        Button startFourActivity = (Button) findViewById(R.id.start_Four_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onCreate");
                //Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                Intent intent = new Intent(MainActivity.this,
                                           MainActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,this.toString());
                Intent intent = new Intent(MainActivity.this,
                                           DialogActivity.class);
                startActivity(intent);
            }
        });
        startThreeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,this.toString());
                //Intent intent = new Intent(MainActivity.this, ThreeActivity.class);
                Intent intent = new Intent(MainActivity.this,
                                           ThreeActivity.class);
                startActivity(intent);
            }
        });
        startFourActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Task id is" +getTaskId());
                //Intent intent = new Intent(MainActivity.this, FourActivity.class);
                Intent intent = new Intent(MainActivity.this,
                                           FourActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void  onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }


}