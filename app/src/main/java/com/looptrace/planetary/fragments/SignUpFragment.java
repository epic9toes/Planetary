package com.looptrace.planetary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.looptrace.planetary.R;
import com.looptrace.planetary.databinding.FragmentSignUpBinding;


public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding mBinding;


    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentSignUpBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        mBinding.signUpBtn.setOnClickListener(v -> {
            Toast.makeText(requireActivity(), "The sign up process hasn't been implemented.", Toast.LENGTH_SHORT).show();
        });

        mBinding.signInAcct.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_signUpFragment_to_signInFragment);
            mBinding.signUpBtn.setVisibility(View.INVISIBLE);
        });

        return view;
    }
}