package com.example.activityaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FourActivity", "Task id is"+getTaskId());
        setContentView(R.layout.four_layout);
        Button returnButton = (Button) findViewById(R.id.return_activity4);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourActivity.this,
                                           NormalActivity.class);
                startActivity(intent);
            }
        });
    }
}