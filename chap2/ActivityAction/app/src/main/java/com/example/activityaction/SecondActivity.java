package com.example.activityaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity2", this.toString());
        setContentView(R.layout.second_layout);
        Button returnButton = (Button) findViewById(R.id.secondactivity);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,
                                           DialogActivity.class);
                startActivity(intent);
            }
        });
    }
}