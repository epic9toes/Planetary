package com.looptrace.planetary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.looptrace.planetary.R;
import com.looptrace.planetary.activities.MainActivity;
import com.looptrace.planetary.databinding.FragmentSignUpBinding;


public class SignUpFragment extends Fragment {

    private Button mBtnSignUp;
    private TextView mBtnLoginAcct;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        mBtnSignUp = view.findViewById(R.id.sign_up_btn);
        mBtnSignUp.setOnClickListener(v -> {
            startActivity(new Intent(requireActivity(), MainActivity.class));
            requireActivity().finish();
        });

        mBtnLoginAcct = view.findViewById(R.id.sign_in_acct);
        mBtnLoginAcct.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_signUpFragment_to_signInFragment);
            mBtnSignUp.setVisibility(View.INVISIBLE);
        });

        return view;
    }
}