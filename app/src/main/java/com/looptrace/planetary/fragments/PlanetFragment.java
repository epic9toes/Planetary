package com.looptrace.planetary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.looptrace.planetary.Listeners.GetPlanetListener;
import com.looptrace.planetary.R;
import com.looptrace.planetary.adapters.PlanetAdapter;
import com.looptrace.planetary.databinding.FragmentPlanetBinding;
import com.looptrace.planetary.models.PlanetModel;
import com.looptrace.planetary.viewmodel.PlanetViewModel;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class PlanetFragment extends Fragment implements PlanetAdapter.OnPlanetListener, GetPlanetListener {

    private FragmentPlanetBinding mBinding;
    private PlanetAdapter mPlanetAdapter;
    private ArrayList<PlanetModel> mPlanets;
    PlanetViewModel planetViewModel;

    public PlanetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPlanetBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        prepareRecycler();
        planetViewModel = ViewModelProviders.of(requireActivity()).get(PlanetViewModel.class);
        planetViewModel.mGetPlanetListener = this;
        planetViewModel.init();

        planetViewModel.GetPlanets().observe(requireActivity(), planetDataRoot -> populatePlanetRecycler((ArrayList<PlanetModel>) planetDataRoot.getPlanetModels()));

        mBinding.errorPage.refreshBtn.setOnClickListener(v -> {
            mBinding.errorPage.getRoot().setVisibility(View.INVISIBLE);
            mBinding.loadingIndicator.getRoot().setVisibility(View.VISIBLE);
            planetViewModel.Retry();
        });
        return view;
    }


    private void prepareRecycler() {
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
        mPlanets.addAll(planets);
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(mPlanetAdapter);
        alphaInAnimationAdapter.setDuration(2000);
        alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator());
        alphaInAnimationAdapter.setFirstOnly(false);
        mBinding.planetRecycler.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
        mBinding.planetRecycler.setVisibility(View.VISIBLE);
        mBinding.loadingIndicator.getRoot().setVisibility(View.INVISIBLE);
        mPlanetAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPlanetClick(View view, int position) {
        PlanetModel model = mPlanets.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable("planetModel", model);
        Navigation.findNavController(view).navigate(R.id.planetDetailFragment, bundle);
    }

    @Override
    public void OnFailure(String s) {
        mBinding.loadingIndicator.getRoot().setVisibility(View.INVISIBLE);
        mBinding.errorPage.getRoot().setVisibility(View.VISIBLE);
        mBinding.errorPage.errorMsg.setText("Error: " + s);
    }

    @Override
    public void OnThrowableError(Throwable throwable) {
        mBinding.loadingIndicator.getRoot().setVisibility(View.INVISIBLE);
        mBinding.errorPage.getRoot().setVisibility(View.VISIBLE);
        mBinding.errorPage.errorMsg.setText("Error: " + throwable.getMessage());

    }
}