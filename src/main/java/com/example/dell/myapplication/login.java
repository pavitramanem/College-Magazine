package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
EditText e1,e2;
Button b1;
MyDb my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1=(Button)findViewById(R.id.b3);
        my=new MyDb(this);
    }

    public void check(View view) {
        String uid=e1.getText().toString();
        String pwd=e2.getText().toString();
        String admin_uid=new String("admin");
        String admin_pwd=new String("8901");
        if(uid.equals(admin_uid) && pwd.equals(admin_pwd)){
            Intent i=new Intent(this,admin.class);
            startActivity(i);
        }
        else if(my.select(uid,pwd)==2){
            Intent i= new Intent(this,articles.class);
            startActivity(i);
        }
        else{
            Intent i= new Intent(this,login.class);
            startActivity(i);
            Toast.makeText(this, "login falied", Toast.LENGTH_SHORT).show();
        }

    }

}
