package com.looptrace.planetary.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.looptrace.planetary.R;
import com.looptrace.planetary.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private NavController mNavController;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        mNavController = Navigation.findNavController(this, R.id.main_fragment);
        NavigationUI.setupWithNavController(mBinding.bottomNavigation, mNavController);
        mNavController.addOnDestinationChangedListener((controller, destination, arguments) -> {
//            switch (destination.getId()) {
//                case R.id.homeFragment:
//                   destination.getId();
//                    return;
//
//                case R.id.searchFragment:
//                    title.setText("Classroom");
//                    return;
//
//            }

        });
    }

}