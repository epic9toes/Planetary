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

import com.looptrace.planetary.adapters.PlanetAdapter;
import com.looptrace.planetary.databinding.FragmentPlanetBinding;
import com.looptrace.planetary.models.Planet;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class PlanetFragment extends Fragment {

    private FragmentPlanetBinding mBinding;
    private PlanetAdapter mPlanetAdapter;
    private ArrayList<Planet> mPlanets;


    public PlanetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPlanetBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();


        processPlanetRecycler();
        populatePlanetRecycler();

        return view;
    }

    private void processPlanetRecycler() {
        mPlanets = new ArrayList<>();
        if (mPlanets.size() < 1) {
            mBinding.loadingIndicator.getRoot().setVisibility(View.VISIBLE);
            mPlanetAdapter = new PlanetAdapter(mPlanets);
            mBinding.planetRecycler.setAdapter(mPlanetAdapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
            mBinding.planetRecycler.setLayoutManager(layoutManager);
        }
    }


    private void populatePlanetRecycler() {
        new Handler().postDelayed(() -> {

            for (int i = 0; i < 15; i++) {
                Planet planet = new Planet("earth", "Earth", "17.5624 km hm",
                        "Jan 14th 1897", "Seth Barnes Kelvin");
                mPlanets.add(planet);
            }
            AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(mPlanetAdapter);
            alphaInAnimationAdapter.setDuration(2000);
            alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator());
            alphaInAnimationAdapter.setFirstOnly(false);
            mBinding.planetRecycler.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
            mBinding.planetRecycler.setVisibility(View.VISIBLE);
            mBinding.loadingIndicator.getRoot().setVisibility(View.INVISIBLE);
//            mBinding.errorPage.getRoot().setVisibility(View.VISIBLE);
            mPlanetAdapter.notifyDataSetChanged();

        }, 1000);
    }
}