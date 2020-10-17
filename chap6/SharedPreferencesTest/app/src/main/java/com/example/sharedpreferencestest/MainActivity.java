package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button savedata = (Button) findViewById(R.id.save_data);
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =
                        getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });

        Button retoreData = (Button) findViewById(R.id.restore_data);
        retoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","");
                int age = pref.getInt("age",0);
                boolean married = pref.getBoolean("married",false);
                Log.d("MainActivity","name is " +name);
                Log.d("MainActivity","age is " +age);
                Log.d("MainActivity","married is " +married);
            }
        });
    }
}