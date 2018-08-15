package com.example.dell.myapplication;

import android.widget.Toast;

class Nb_event {
    private int TITLE_ID;
    private String title;
    private String about;


    public int getId() {
        return TITLE_ID;
    }

    public void setId(int TITLE_ID) {
        this.TITLE_ID = TITLE_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}
