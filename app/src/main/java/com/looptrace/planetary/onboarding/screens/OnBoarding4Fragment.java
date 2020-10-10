package com.looptrace.planetary.onboarding.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.looptrace.planetary.R;
import com.looptrace.planetary.SharedPrefSetup;
import com.looptrace.planetary.activities.MainActivity;
import com.looptrace.planetary.databinding.FragmentOnBoarding4Binding;


public class OnBoarding4Fragment extends Fragment {


    private FragmentOnBoarding4Binding mBinding;

    public OnBoarding4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentOnBoarding4Binding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        final ViewPager2 viewPager = getActivity().findViewById(R.id.view_pager);

        mBinding.btnFinish.setOnClickListener(v -> {
            SharedPrefSetup.getInstance().OnBoardingCompleted(requireContext());
            startActivity(new Intent(getActivity(), MainActivity.class));
            requireActivity().finish();
        });


        // Inflate the layout for this fragment
        return view;
    }
}