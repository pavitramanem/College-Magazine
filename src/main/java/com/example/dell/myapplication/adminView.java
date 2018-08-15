package com.example.dell.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class adminView extends AppCompatActivity {
RecyclerView r;
add ad;
 private List<Nb_event> listUsers;
    private adaptr adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        r=(RecyclerView)findViewById(R.id.rec);
        ad=new add(this);
        listUsers = new ArrayList<>();
        adapt = new adaptr(listUsers);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        r.setLayoutManager(new LinearLayoutManager(this));
        r.setLayoutManager(mLayoutManager);
        r.setItemAnimator(new DefaultItemAnimator());
        r.setAdapter(new adaptr(listUsers));
        getDataFromSQLite();
    }

    @SuppressLint("StaticFieldLeak")
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(ad.getAllUser());
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapt.notifyDataSetChanged();
            }
        }.execute();
    }
}

