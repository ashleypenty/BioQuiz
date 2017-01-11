package com.yinkash.bioquiz.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yinkash.bioquiz.DatabaseHelper;
import com.yinkash.bioquiz.R;
import com.yinkash.bioquiz.models.User;

public class LoginActivity extends AppCompatActivity {

    //Declare a DatabaseHelper object to allow access to the methods of that class
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*The variables below collect user input from the Login page and cast the input into a
        usable format*/
        final EditText etUserName = (EditText) findViewById(R.id.etUserName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterHere);

        /*In the event the user has not registered before, by clicking on the Register Here link
        the user will switch Activity from the Login Activity to the Register Activity wi*/
        tvRegisterLink.setOnClickListener(new View.OnClickListener() {

            @Override
            /**
             * create an Intent; this intent will allow us to transition from the Login Activity to
             * the Register Activity
             */
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        //After entering your Login details and pressing the Login button, the code below is executed
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //store the entered UserName as a string
                String inputtedUserName = etUserName.getText().toString();
                //store the entered password as a string; this is the password entered into the Login form
                String inputtedPassword = etPassword.getText().toString();

                User currentUser = helper.getUserByUserName(inputtedUserName);

                if (currentUser != null && inputtedPassword.equals(currentUser.getPassword())) {
                    //if the password entered and the password retrieved match, the user will be taken to the Welcome activity

                    //mpMode comment; switches control to my DashBoard before starting the quiz
                    Intent uDashBoardIntent = new Intent(LoginActivity.this, DashBoardActivity.class);
                    LoginActivity.this.startActivity((uDashBoardIntent));

                    /*Intent uWelcomeIntent = new Intent(LoginActivity.this, UserWelcomeActivity.class);
                    uWelcomeIntent.putExtra("Username", currentUser.getUserName());
                    startActivity(uWelcomeIntent);*/

                    SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("userId", currentUser.getId());
                    editor.putString("username", currentUser.getUserName());
                    editor.apply();

                } else {
                    //if the password entered and the password retrieved do no match an error message is produced
                    Toast.makeText(LoginActivity.this, "Username and password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
