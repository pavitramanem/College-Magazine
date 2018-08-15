package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
ImageView i1;
RecyclerView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        i1=(ImageView)findViewById(R.id.i1);
        r=(RecyclerView)findViewById(R.id.rec);
    }

    public void login(View view) {
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }

    public void register(View view) {
        Intent i=new Intent(this,register.class);
        startActivity(i);
    }
}
