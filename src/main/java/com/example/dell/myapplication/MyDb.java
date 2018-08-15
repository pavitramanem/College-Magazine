package com.example.dell.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDb extends SQLiteOpenHelper {
    SQLiteDatabase readable, writable;
    Context ct;

    public MyDb(Context context) {
        super(context, "user", null, 1);
        this.ct = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table data(name text,uid int,pwd text,phn int);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists data");

    }

    public long insertdata(String name, String uid, String pwd, String phn) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("uid", uid);
        values.put("pwd", pwd);
        values.put("phn", phn);
        writable = getWritableDatabase();
        return writable.insert("data", null, values);
    }

    public void display() {
        readable = getReadableDatabase();
        Cursor c = readable.query("data", new String[]{"name", "uid", "pwd", "phn"}, null, null, null, null, null);
        //Cursor c=readable.query("data",new String[]{"name","uid","pwd","phn"},"uid=? and pwd=?",new String[]{"values['uid']","values['pwd']"},null,null,null);
        while (c.moveToNext()) {
            String name = c.getString(0);
            String uid = c.getString(1);
            String pwd = c.getString(2);
            String phn = c.getString(3);
            Toast.makeText(ct, "" + name + "" + uid + "" + pwd + "" + phn + "\n", Toast.LENGTH_SHORT).show();
        }
    }

    public int select(String uid, String pwd) {
        readable = getReadableDatabase();
        Cursor c = readable.query("data", new String[]{"name", "uid", "pwd", "phn"}, "uid=? and pwd=?", new String[]{uid, pwd}, null, null, null);
        while (c.moveToNext()) {
            return 2;
        }
        return 3;
    }
    public int check(String uid) {
            readable = getReadableDatabase();
            Cursor c=readable.query("data",new String[]{"name","uid","pwd","phn"},"uid=?",new String[]{uid},null,null,null);
            while(c.moveToNext()){
                return 2;
            }
        return 3;
    }
}
