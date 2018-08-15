package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void add(View view) {
        Intent i=new Intent(this,addArticle.class);
        startActivity(i);
    }

    public void view(View view) {
        Intent i=new Intent(this,adminView.class);
        startActivity(i);
    }

    public void dlt(View view) {
        Intent i=new Intent(this,delete.class);
        startActivity(i);
    }
}
