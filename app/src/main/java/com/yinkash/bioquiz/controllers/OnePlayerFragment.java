package com.yinkash.bioquiz.controllers;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yinkash.bioquiz.R;

/**
 * Created by yinksb23 on 08/01/2017.
 */

public class OnePlayerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_player_fragment, container, false);

        final Button fb1Player = (Button)view.findViewById(R.id.one_player_button); //mpMode change; my 1P button

        fb1Player.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                buttonClicked(v);
            }
        });

        return view;
    }

    public void buttonClicked(View v){
        //retrieves the username stored using sharedpreferences
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String spUname = sharedPref.getString("username", "");

        //makes the username of the user available to WelcomeActivity
        Intent uWelcomeIntent = new Intent(this.getActivity(), UserWelcomeActivity.class);
        uWelcomeIntent.putExtra("Username", spUname);
        OnePlayerFragment.this.startActivity((uWelcomeIntent));

        //By choosing the 1P button the user has confirmed their decision to not enter multiplayer; stored as a boolean
        final boolean mpMode = false;
        SharedPreferences sharedPref3 = this.getActivity().getSharedPreferences("userInfo3", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref3.edit();
        editor.putBoolean("mpMode2", mpMode);
        editor.apply();
    }

}
