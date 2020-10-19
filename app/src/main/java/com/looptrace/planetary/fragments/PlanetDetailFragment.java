package com.looptrace.planetary.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.looptrace.planetary.Listeners.GetPlanetDetailsListener;
import com.looptrace.planetary.R;
import com.looptrace.planetary.adapters.MoonAdapter;
import com.looptrace.planetary.databinding.FragmentPlanetDetailBinding;
import com.looptrace.planetary.models.DetailPages;
import com.looptrace.planetary.models.PlanetModel;
import com.looptrace.planetary.models.PlanetMoon;
import com.looptrace.planetary.viewmodel.PlanetDetailViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class PlanetDetailFragment extends Fragment implements MoonAdapter.OnMoonListener, GetPlanetDetailsListener {


    private FragmentPlanetDetailBinding mBinding;
    private ArrayList<PlanetMoon> mMoons;
    private MoonAdapter mMoonAdapter;
    private PlanetModel mPlanet;
    private PlanetDetailViewModel mPlanetDetailViewModel;
    private Context appContext;

    public PlanetDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPlanetDetailBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        mPlanet = getArguments().getParcelable("planetModel");


        mPlanetDetailViewModel = ViewModelProviders.of(requireActivity()).get(PlanetDetailViewModel.class);
        mPlanetDetailViewModel.mGetPlanetDetailsListener = this;
        mPlanetDetailViewModel.init(800, mPlanet.getEnglishName());
        mPlanetDetailViewModel.GetPlanetDetails().observe(requireActivity(), planetDetailRoot -> {
            final Map<String, DetailPages> pages = planetDetailRoot.getQuery().getPages();
            for (DetailPages pages1 : pages.values()) {
                if (!pages1.getExtract().equals("")) {
                    mBinding.summaryText.loadData(pages1.getExtract(), "text/html", "UTF-8");
                } else {
                    mBinding.summaryText.loadData("<h4>There is no available summary at this time for this planet.</h4>", "text/html", "UTF-8");
                }
                mBinding.summaryLoader.setVisibility(View.INVISIBLE);

                if (pages1.getThumbnail() != null) {
                    Picasso.get().load(pages1.getThumbnail().getSource()).into(mBinding.planetImage);
                } else {
                    mBinding.planetImage.setImageDrawable(appContext.getResources().getDrawable(R.drawable.planets_illustrator));
                }
                mBinding.imageLoader.setVisibility(View.INVISIBLE);
            }
        });
        AssignUiObjects();
        processMoonRecycler();
        populateMoonRecycler();

        return view;
    }

    @SuppressLint("SetTextI18n")
    private void AssignUiObjects() {
        if (getArguments() != null && mPlanet != null) {
            mBinding.name.setText(mPlanet.getEnglishName());
            mBinding.axis.setText(mPlanet.getSemimajorAxis() + "");
            mBinding.perihelion.setText(mPlanet.getPerihelion() + "");
            mBinding.eccentricity.setText(mPlanet.getEccentricity() + "");
            mBinding.density.setText(mPlanet.getDensity() + "");
            mBinding.gravity.setText(mPlanet.getGravity() + "");
            mBinding.dimension.setText(mPlanet.getSideralOrbit() + "");

        }
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
            if (mPlanet.getMoons() != null) {
                for (PlanetMoon moon :
                        mPlanet.getMoons()) {
                    mMoons.add(moon);
                }
                AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(mMoonAdapter);
                alphaInAnimationAdapter.setDuration(2000);
                alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator());
                alphaInAnimationAdapter.setFirstOnly(false);
                mBinding.moonRecycler.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
                mBinding.moonRecycler.setVisibility(View.VISIBLE);
                mMoonAdapter.notifyDataSetChanged();
            } else {
                mBinding.availableMoonCard.setVisibility(View.INVISIBLE);
            }
        }, 1000);
    }


    @Override
    public void onResume() {
        super.onResume();
        Activity activity = getActivity();
        if (activity != null) {
            mPlanetDetailViewModel.Retry(800, mPlanet.getEnglishName());
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (appContext == null)
            appContext = context.getApplicationContext();
    }

    @Override
    public void onMoonClick(View view, int position) {

    }

    @Override
    public void OnFailure(String s) {
        Activity activity = getActivity();
        if (activity != null && isAdded()) {
            mBinding.summaryLoader.setVisibility(View.INVISIBLE);
            mBinding.imageLoader.setVisibility(View.INVISIBLE);
            Toast.makeText(requireActivity(), s, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void OnThrowableError(Throwable throwable) {
        Activity activity = getActivity();
        if (activity != null && isAdded()) {
            mBinding.summaryLoader.setVisibility(View.INVISIBLE);
            mBinding.imageLoader.setVisibility(View.INVISIBLE);
            Toast.makeText(requireActivity(), "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}