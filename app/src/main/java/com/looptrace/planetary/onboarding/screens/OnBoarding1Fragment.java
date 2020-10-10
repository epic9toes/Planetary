package com.looptrace.planetary.onboarding.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.looptrace.planetary.activities.OnBoardingActivity;
import com.looptrace.planetary.databinding.FragmentOnBoarding1Binding;

public class OnBoarding1Fragment extends Fragment {

    private FragmentOnBoarding1Binding mBinding;

    public OnBoarding1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentOnBoarding1Binding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        mBinding.btnGetStarted.setOnClickListener(v -> {
            startActivity(new Intent(requireActivity(), OnBoardingActivity.class));
            requireActivity().finish();
        });

        return view;
    }
}