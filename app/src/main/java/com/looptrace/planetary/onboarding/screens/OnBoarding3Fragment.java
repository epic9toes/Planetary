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
import com.looptrace.planetary.databinding.FragmentOnBoarding3Binding;


public class OnBoarding3Fragment extends Fragment {


    private FragmentOnBoarding3Binding mBinding;

    public OnBoarding3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentOnBoarding3Binding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        final ViewPager2 viewPager = getActivity().findViewById(R.id.view_pager);

        mBinding.btnNext.setOnClickListener(v -> viewPager.setCurrentItem(2));

        mBinding.btnSkip.setOnClickListener(v -> {
            SharedPrefSetup.getInstance().OnBoardingCompleted(requireContext());
            startActivity(new Intent(getActivity(), MainActivity.class));
            requireActivity().finish();
        });


        // Inflate the layout for this fragment
        return view;
    }
}