package com.looptrace.planetary.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.looptrace.planetary.adapters.MoonAdapter;
import com.looptrace.planetary.databinding.FragmentPlanetDetailBinding;
import com.looptrace.planetary.models.Moon;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class PlanetDetailFragment extends Fragment implements MoonAdapter.OnMoonListener {


    private FragmentPlanetDetailBinding mBinding;
    private ArrayList<Moon> mMoons;
    private MoonAdapter mMoonAdapter;

    public PlanetDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPlanetDetailBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        processMoonRecycler();
        populateMoonRecycler();

        return view;
    }

    private void processMoonRecycler() {
        mMoons = new ArrayList<>();
        if (mMoons.size() < 1) {
            mMoonAdapter = new MoonAdapter(mMoons, this);
            mBinding.moonRecycler.setAdapter(mMoonAdapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
            mBinding.moonRecycler.setLayoutManager(layoutManager);
        }
    }


    private void populateMoonRecycler() {
        new Handler().postDelayed(() -> {

            for (int i = 0; i < 15; i++) {
                Moon moon = new Moon("1", "Circus", "");
                mMoons.add(moon);
            }
            AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(mMoonAdapter);
            alphaInAnimationAdapter.setDuration(2000);
            alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator());
            alphaInAnimationAdapter.setFirstOnly(false);
            mBinding.moonRecycler.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
            mBinding.moonRecycler.setVisibility(View.VISIBLE);
//            mBinding.loadingIndicator.getRoot().setVisibility(View.INVISIBLE);
//            mBinding.errorPage.getRoot().setVisibility(View.VISIBLE);
            mMoonAdapter.notifyDataSetChanged();

        }, 1000);
    }

    @Override
    public void onMoonClick(View view, int position) {

    }
}