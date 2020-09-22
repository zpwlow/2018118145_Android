package com.example.uiwindowtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        button.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                imageView.setImageResource(R.drawable.img_2);
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this,
                               inputText,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}