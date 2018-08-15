package com.example.dell.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class add extends SQLiteOpenHelper {
    Context ct;
    SQLiteDatabase readable, writable;
    private static final String tag=add.class.getSimpleName();
    private static final String DB_NAME="user1";
    private static final String TABLE_NAME="article";
    private static final int DB_VERSION=1;
    private Nb_event eve;
    private static final String title="title";
    private static final String about="about";
    private static final String[] COLUMNS={title,about};

    public add(Context context) {
        super(context, "user1", null, 1);
        this.ct = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table article(title text,about text);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists data");
    }

    public long insertdata(String title, String about) {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("about", about);
        writable = getWritableDatabase();
        return writable.insert("article", null, values);
    }

    public void display() {
        readable = getReadableDatabase();
        Cursor c = readable.query("article", new String[]{"title", "about"}, null, null, null, null, null);
        //Cursor c=readable.query("data",new String[]{"name","uid","pwd","phn"},"uid=? and pwd=?",new String[]{"values['uid']","values['pwd']"},null,null,null);
        while (c.moveToNext()) {
            String title = c.getString(0);
            String about = c.getString(1);
            Toast.makeText(ct, "" + title + "" + about + "\n", Toast.LENGTH_SHORT).show();
        }
    }

    public int select(String title, String about) {
        readable = getReadableDatabase();
        Cursor c = readable.query("article", new String[]{"title", "about"}, "title=? and about=?", new String[]{title, about}, null, null, null);
        while (c.moveToNext()) {
            return 2;
        }
        return 3;
    }

    public int check(String title) {
        readable = getReadableDatabase();
        Cursor c = readable.query("article", new String[]{"title", "about"}, "title=?", new String[]{title}, null, null, null);
        while (c.moveToNext()) {
            return 2;
        }
        return 3;

    }

    public List getAllUser() {
        String[] columns = {"title","about"};
        List<Nb_event> userList = new ArrayList<Nb_event>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("article", //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                null);
        if (cursor.moveToFirst()) {
            do {
                Nb_event user = new Nb_event();
                //user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("EVENT_ID"))));
                user.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                user.setAbout(cursor.getString(cursor.getColumnIndex("about")));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }
    public  void deleteTitle(String del){
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete("article","title=?",new String[]{del});
        db.close();
    }
}


