package com.example.dell.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {
add ad;
EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        e1=(EditText)findViewById(R.id.edt);
        ad=new add(this);
    }

    public void del(View view) {
        Toast.makeText(this,"deleted succesfully",Toast.LENGTH_SHORT).show();
        String del=e1.getText().toString();
        Intent i=new Intent(this,admin.class);
        startActivity(i);
        ad.deleteTitle(del);



    }
}
