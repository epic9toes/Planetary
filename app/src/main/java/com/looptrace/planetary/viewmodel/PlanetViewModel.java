package com.looptrace.planetary.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.looptrace.planetary.Listeners.GetPlanetListener;
import com.looptrace.planetary.datasource.repo.PlanetRepo;
import com.looptrace.planetary.models.PlanetDataRoot;

public class PlanetViewModel extends ViewModel {

    public GetPlanetListener mGetPlanetListener;
    private MutableLiveData<PlanetDataRoot> mPlanets;
    private PlanetRepo mPlanetRepo;

    public void init() {
        if (mPlanets != null) {
            return;
        }
        mPlanetRepo = PlanetRepo.getInstance();
        mPlanetRepo.mGetPlanetListener = this.mGetPlanetListener;
        mPlanets = mPlanetRepo.GetPlanets();
    }

    public MutableLiveData<PlanetDataRoot> GetPlanets() {
        return mPlanets;
    }


    public void Retry() {
        mPlanets = mPlanetRepo.GetPlanets();
    }
}
