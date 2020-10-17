package com.example.broadcastbestpractice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity{
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle sevedInstanceState){
        super.onCreate(sevedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
