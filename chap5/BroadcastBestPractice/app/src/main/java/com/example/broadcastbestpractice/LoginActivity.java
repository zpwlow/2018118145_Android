package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;

public class LoginActivity extends BaseActivity{
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private SharedPreferences pref;
    private  SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle sevedInstanceState){
        super.onCreate(sevedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remeber_pass);
        login = (Button) findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            //将账号和密码都设置到文本中
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("zhong") && password.equals("123456")){
                    editor = pref.edit();
                    if(rememberPass.isChecked()){
                        //检查复选框是否选择
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"账号或者密码错误！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
