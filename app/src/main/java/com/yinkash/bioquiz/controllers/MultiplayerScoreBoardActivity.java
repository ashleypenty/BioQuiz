package com.yinkash.bioquiz.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yinkash.bioquiz.R;

public class MultiplayerScoreBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_score_board);

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String spUname = sharedPref.getString("username", "");

        int mpScore1 = getIntent().getIntExtra("P1Score", 0);
        int mpScore2 = getIntent().getIntExtra("P2Score", 0);

        String Score1 = "Player 1 " + spUname +  " scored " + mpScore1;
        String Score2 = "Player 2 aka the Challenger scored " + mpScore2;

        TextView tvPlayer1 = (TextView) findViewById(R.id.tvPlayer1Score);
        TextView tvPlayer2 = (TextView) findViewById(R.id.tvPlayer2Score);

        tvPlayer1.setText(Score1);
        tvPlayer2.setText(Score2);

    }
}
