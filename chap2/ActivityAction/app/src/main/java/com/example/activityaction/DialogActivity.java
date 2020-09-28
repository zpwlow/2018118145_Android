package com.example.activityaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity2",this.toString());
        setContentView(R.layout.dialog_layout);
        Button returnButton = (Button) findViewById(R.id.return_activity2);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DialogActivity.this,
                                           SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}