package com.looptrace.planetary.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.looptrace.planetary.Listeners.GetPlanetListener;
import com.looptrace.planetary.R;
import com.looptrace.planetary.adapters.PlanetAdapter;
import com.looptrace.planetary.databinding.FragmentPlanetBinding;
import com.looptrace.planetary.models.PlanetData;
import com.looptrace.planetary.models.PlanetModel;
import com.looptrace.planetary.viewmodel.PlanetViewModel;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

import static android.content.ContentValues.TAG;


public class PlanetFragment extends Fragment implements PlanetAdapter.OnPlanetListener, GetPlanetListener {

    private FragmentPlanetBinding mBinding;
    private PlanetAdapter mPlanetAdapter;
    private ArrayList<PlanetModel> mPlanets;
    private PlanetViewModel mPlanetViewModel;

    public PlanetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPlanetBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        mPlanetViewModel = ViewModelProviders.of(requireActivity()).get(PlanetViewModel.class);
        mPlanetViewModel.mGetPlanetListener = this;
        mPlanetViewModel.GetPlanets();

        processPlanetRecycler();

        return view;
    }

    private void processPlanetRecycler() {
        mPlanets = new ArrayList<>();
        if (mPlanets.size() < 1) {
            mBinding.loadingIndicator.getRoot().setVisibility(View.VISIBLE);
            mPlanetAdapter = new PlanetAdapter(mPlanets, this);
            mBinding.planetRecycler.setAdapter(mPlanetAdapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
            mBinding.planetRecycler.setLayoutManager(layoutManager);
        }
    }


    private void populatePlanetRecycler(ArrayList<PlanetModel> planets) {
        for (PlanetModel planet :
                planets) {
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
    }

    @Override
    public void onPlanetClick(View view, int position) {
        Navigation.findNavController(view).navigate(R.id.planetDetailFragment);
//        Toast.makeText(requireContext(), "planet info: " + mPlanets.get(position).toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnStarted() {
        Toast.makeText(requireContext(), "API call Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnSuccess(MutableLiveData<PlanetData> planets) {
        Log.d(TAG, "API call was Successful");

        planets.observe(requireActivity(), new Observer<PlanetData>() {
            @Override
            public void onChanged(PlanetData planets) {
                populatePlanetRecycler((ArrayList<PlanetModel>) planets.getPlanetModels());
            }
        });

    }

    @Override
    public void OnFailure(String s) {

        mBinding.loadingIndicator.getRoot().setVisibility(View.INVISIBLE);
        Log.d(TAG, "API call Failed");
    }

    @Override
    public void OnThrowableError(Throwable throwable) {

        mBinding.loadingIndicator.getRoot().setVisibility(View.INVISIBLE);
        Log.d(TAG, "Error: " + throwable.getMessage());
    }
}