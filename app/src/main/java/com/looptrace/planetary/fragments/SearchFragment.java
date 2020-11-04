package com.looptrace.planetary.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.looptrace.planetary.databinding.FragmentSearchBinding;



public class SearchFragment extends Fragment {

    private FragmentSearchBinding mBinding;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentSearchBinding.inflate(getLayoutInflater());

        View view = mBinding.getRoot();

        mBinding.searchBtn.setOnClickListener(v -> {
            if (mBinding.searchBox.getText().length() > 0) {
                mBinding.progressCircular.setVisibility(View.VISIBLE);
                mBinding.pageNotFound.getRoot().setVisibility(View.INVISIBLE);
                new Handler().postDelayed(() -> {
                    mBinding.progressCircular.setVisibility(View.INVISIBLE);
                    mBinding.pageNotFound.getRoot().setVisibility(View.VISIBLE);
                }, 1000);
            } else {
                mBinding.progressCircular.setVisibility(View.INVISIBLE);
                mBinding.pageNotFound.getRoot().setVisibility(View.INVISIBLE);
                Toast.makeText(requireActivity(), "Search field cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}