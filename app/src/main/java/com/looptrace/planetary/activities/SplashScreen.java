package com.looptrace.planetary.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.looptrace.planetary.R;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences(getString(R.string.preference_key_file), MODE_PRIVATE);
        boolean isFinished = preferences.getBoolean("Finished", false);

        if (isFinished)
            startActivity(new Intent(this, SignInUpActivity.class));
        else startActivity(new Intent(this, GetStartedActivity.class));
        finish();

    }
}