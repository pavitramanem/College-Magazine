package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class articles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
    }

    public void add(View view) {
        Intent i=new Intent(this,addArticle.class);
        startActivity(i);
    }

    public void view(View view) {
        Intent i1=new Intent(this,viewArticle.class);
        startActivity(i1);
    }
}
