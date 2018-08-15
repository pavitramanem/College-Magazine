package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
EditText e1,e2,e3,e4;
Button bt;
MyDb my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1 = (EditText) findViewById(R.id.ed1);
        e2 = (EditText) findViewById(R.id.ed2);
        e3 = (EditText) findViewById(R.id.ed3);
        e4 = (EditText) findViewById(R.id.ed4);
        bt = (Button) findViewById(R.id.bt1);
        my = new MyDb(this);
    }

    public void reg(View view) {
        String name = e1.getText().toString();
        String uid = e2.getText().toString();
        String pwd = e3.getText().toString();
        String phn = e4.getText().toString();
        if (my.check(uid) == 3) {
            long a = my.insertdata(name, uid, pwd, phn);

            if (a > 0) {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, login.class);
                startActivity(i);

            } else {
                Toast.makeText(this, "registration failed", Toast.LENGTH_SHORT).show();

            }
        }
        else{
            Toast.makeText(this,"user id already exixts",Toast.LENGTH_SHORT).show();
        }

    }

    public void display(View view) {
        my.display();
    }

    }

