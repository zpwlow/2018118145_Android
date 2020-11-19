package com.example.androidthreadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int UPDATE_TEXT = 1;

    private Handler mHandler2;

    private Handler mHandler3;

    private TextView text;


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    //在这里可以进行UI操作
                    text.setText(msg.getData().getString("msg"));
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        Button changeText = (Button) findViewById(R.id.change_text);
        Button sendText = (Button) findViewById(R.id.send_text);
        Button threadSendText = (Button) findViewById(R.id.thread_send_text);
        new MyThread2().start();
        changeText.setOnClickListener(this);
        sendText.setOnClickListener(this);
        threadSendText.setOnClickListener(this);
    }

    class MyThread2 extends Thread {
        @Override
        public void run() {
            super.run();
            //1.init Looper
            Looper.prepare();
            //2.init Handler
            mHandler2 = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what) {
                        case 1:
                            Log.d("MyThread2","Thread id is "
                                    +Thread.currentThread().getId());
                            Log.d("MyThread2","收到的消息为："
                                    + msg.obj.toString());
                            break;
                    }
                }
            };
            //3.Looper start loop
            Looper.loop();
        }
    }


    class MyThread3 extends Thread {
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            mHandler3 = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what) {
                        case 1:
                            Log.d("MyThread3","Thread id is "
                                    +Thread.currentThread().getId());
                            Log.d("MyThread3","收到的消息为："
                                    + msg.obj.toString());
                            break;
                    }
                }
            };
            Looper.loop();
        }
    }

    class MyThread4 extends Thread {
        @Override
        public void run() {
            super.run();
            Log.d("MyThread4","Thread id is "+Thread.currentThread().getId());
            Log.d("MyThread4","发送的消息为： 你好，线程三，我是线程四");
            mHandler3.obtainMessage(1, "你好，线程三，我是线程四").sendToTarget();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        Bundle data = new Bundle();
                        data.putString("msg", "你好，我是线程一");
                        message.what = UPDATE_TEXT;
                        message.setData(data);
                        handler.sendMessage(message);//将Message对象发送出去
                    }
                }).start();
                break;
            case R.id.send_text:
                Log.d("MainActivity","Thread id is "+Thread.currentThread().getId());
                Log.d("MainActivity","发送的消息为： 你好，线程二, 我是UI");
                mHandler2.obtainMessage(1, "你好，线程二, 我是UI").sendToTarget();
                break;
            case R.id.thread_send_text:
                new MyThread3().start();
                new MyThread4().start();
            default:
                break;
        }
    }
}



