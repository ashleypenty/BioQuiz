package com.yinkash.bioquiz.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yinkash.bioquiz.DatabaseHelper;
import com.yinkash.bioquiz.R;
import com.yinkash.bioquiz.models.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        final DatabaseHelper db = new DatabaseHelper(this);

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Integer currentUserId = sharedPref.getInt("userId", -1);

        List<Result> resultList = db.getAllResultsByUserId(currentUserId);
        Collections.sort(resultList, Collections.reverseOrder(new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        }));

        List<String> formattedList = new ArrayList<>();
        for (Result result : resultList) {
            formattedList.add(
                String.format("%s        %s", result.getCreatedOn(), result.getScore())
            );
        }

        ListView results = (ListView) findViewById(R.id.lvLeaderboard);
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                R.layout.activity_listview,
                formattedList.toArray()
        );

        results.setAdapter(adapter);
    }
}
