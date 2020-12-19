package com.example.stickynotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;


public class SplashActivity extends Activity {

    private static int SPLASH_DISPLAY_LENGHT= 1000;    //延迟2秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);//去掉标题
        setContentView(R.layout.activity_splash);
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://abc.mcloc.cn/abc/love/php/love.php")
                        .build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    String data = response.body().string();
                    TextView textView = findViewById(R.id.textView2);
                    textView.setText(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

         */
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        MainActivity.class);	//第二个参数即为执行完跳转后的Activity
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();   //关闭splashActivity，将其回收，否则按返回键会返回此界面
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
