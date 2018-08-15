package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addArticle extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    add ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);
        e1 = (EditText) findViewById(R.id.a1);
        e2 = (EditText) findViewById(R.id.a2);
        b1 = (Button) findViewById(R.id.s1);
        ad = new add(this);
    }

    public void submit(View view) {
        String title = e1.getText().toString();
        String about = e2.getText().toString();
        if (ad.check(title) == 3) {
            long a = ad.insertdata(title, about);

            if (a > 0) {
                Toast.makeText(this, "submitted successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, articles.class);
                startActivity(i);

            } else {
                Toast.makeText(this, "submission failed", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "article already existed", Toast.LENGTH_SHORT).show();
        }
    }
}
