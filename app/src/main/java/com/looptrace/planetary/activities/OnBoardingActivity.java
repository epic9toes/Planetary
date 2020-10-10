package com.looptrace.planetary.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.looptrace.planetary.databinding.ActivityOnBoardingBinding;

public class OnBoardingActivity extends AppCompatActivity {

    private ActivityOnBoardingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mBinding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
    }
}