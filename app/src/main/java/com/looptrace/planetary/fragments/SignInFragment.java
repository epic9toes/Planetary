package com.looptrace.planetary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.looptrace.planetary.R;
import com.looptrace.planetary.activities.MainActivity;
import com.looptrace.planetary.databinding.FragmentSignInBinding;

public class SignInFragment extends Fragment {

    private FragmentSignInBinding mBinding;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentSignInBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        mBinding.signInBtn.setOnClickListener(v -> {
            if (mBinding.email.getText().length() > 0 && mBinding.passwordInput.getText().length() > 0) {
                if (mBinding.email.getText().toString().equals("admin@admin.com") && mBinding.passwordInput.getText().toString().equals("admin")) {
                    startActivity(new Intent(requireActivity(), MainActivity.class));
                    requireActivity().finish();
                } else {
                    Toast.makeText(requireActivity(), "Email must be admin@admin.com and password must be admin", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(requireActivity(), "Email and password fields are required", Toast.LENGTH_SHORT).show();
            }

        });

        mBinding.createAcct.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_signInFragment_to_signUpFragment);
            mBinding.signInBtn.setVisibility(View.INVISIBLE);
        });

        return view;
    }
}