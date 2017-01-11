package com.yinkash.bioquiz.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yinkash.bioquiz.R;

public class UserWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_welcome);

        final EditText etUserName = (EditText) findViewById(R.id.etUserName);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMSG);
        final Button bStartQuiz = (Button) findViewById(R.id.bStartQ);

        String username = getIntent().getStringExtra("Username"); //need to explain this line

        //This line finds the XML code of a certain textbook and makes it accessible via Java
        TextView tv = (TextView) findViewById(R.id.TVusername);
        tv.setText(username); //This textbox is then set to display the user's Username

        //Clicking on this button starts the Biology quiz
        bStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startquizIntent = new Intent(UserWelcomeActivity.this, BioQuizActivity.class);
                UserWelcomeActivity.this.startActivity(startquizIntent);
            }
        });
    }
}
