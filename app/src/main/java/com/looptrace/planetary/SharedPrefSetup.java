package com.looptrace.planetary;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefSetup {

    private static SharedPrefSetup instance;

    public static SharedPrefSetup getInstance() {
        if (instance == null) {
            instance = new SharedPrefSetup();
        }
        return instance;
    }

    public void OnBoardingCompleted(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.preference_key_file), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("Finished", true);
        editor.apply();

    }
}
