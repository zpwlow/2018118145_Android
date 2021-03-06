package com.example.notificationtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                String CHANNEL_ONE_ID = "com.primedu.cn";
                String CHANNEL_ONE_NAME = "Channel One";
                NotificationChannel notificationChannel = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    notificationChannel = new NotificationChannel(CHANNEL_ONE_ID,
                            CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(Color.RED);
                    notificationChannel.setShowBadge(true);
                    notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                    NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    manager.createNotificationChannel(notificationChannel);
                }
                NotificationManager manager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification.Builder(this)
                        .setChannelId(CHANNEL_ONE_ID)
                        .setContentTitle("This is context title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources()
                                ,R.mipmap.ic_launcher))
                        .setSound(Uri.fromFile(new
                                File("/system/media/audio/ringtones/Luna.ogg"))) //响铃
                        .setVibrate(new long[]{0,1000,1000,1000})  //震动一秒，静止一秒
                        .setLights(Color.GREEN,1000,1000) //LED灯绿色闪动
                        .setDefaults(NotificationCompat.DEFAULT_ALL) //根据手机环境播放铃声
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;

        }

    }

}