package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button createbase = (Button) findViewById(R.id.create_database);
        createbase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper.getWritableDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db  = dbhelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","The Da Vinci Code");
                values.put("author","Dan Browm");
                values.put("pages",454);
                values.put("price",16.96);
                db.insert("Book",null,values); //插入第一条数据
                values.clear();
                // 插入第二条数据
                values.put("name","The Lost Symbol");
                values.put("author","Dan Browm");
                values.put("pages",510);
                values.put("price",19.95);
                db.insert("Book",null,values);

            }
        });
    }
}