package com.yinkash.bioquiz.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yinkash.bioquiz.DatabaseHelper;
import com.yinkash.bioquiz.R;

public class DashBoardActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }
}
