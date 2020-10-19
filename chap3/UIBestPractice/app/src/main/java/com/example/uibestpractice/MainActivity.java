package com.example.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerview;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs(); //初始化信息数据
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerview.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerview.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1); //当有消息时
                    msgRecyclerview.scrollToPosition(msgList.size()-1);
                    inputText.setText("");
                }
            }
        });
    }

    private  void initMsgs(){
        Msg msg1 =  new Msg("Hello guy",Msg.TYPR_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello, Who is that?",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 =  new Msg("This is Tom. Nice talking to you.", Msg.TYPR_RECEIVED);
        msgList.add(msg3);
    }
}