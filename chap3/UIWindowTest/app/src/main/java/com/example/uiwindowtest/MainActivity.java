package com.example.uiwindowtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        ActionBar actionbar = getActionBar();
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener((View.OnClickListener) this);
        if (actionbar != null){
            actionbar.hide();
        }
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                imageView.setImageResource(R.drawable.img_2); //点击按钮更换图片
                String inputText = editText.getText().toString(); //将输入的信息显示再Toast.
                Toast.makeText(MainActivity.this,
                               inputText,Toast.LENGTH_SHORT).show();
                /*int progress = progressBar.getProgress();//点击按钮增加条形进度条进度
                progress = progress + 10;
                progressBar.setProgress(progress);  */
                /*if(progressBar.getVisibility()==View.GONE){ //圆形进度
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);} */
                //点击按钮弹出确认框
                /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     }
                 });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                 });
                dialog.show(); */
                ProgressDialog progressDialog = new ProgressDialog
                        (MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog.。");
                progressDialog.setMessage("Loading.....");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}


class TitleLayout extends LinearLayout{

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button titleBack = (Button)
    }
}