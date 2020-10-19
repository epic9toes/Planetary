package com.looptrace.planetary.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.looptrace.planetary.Listeners.GetPlanetDetailsListener;
import com.looptrace.planetary.datasource.repo.PlanetRepo;
import com.looptrace.planetary.models.PlanetDetailRoot;

public class PlanetDetailViewModel extends ViewModel {

    public GetPlanetDetailsListener mGetPlanetDetailsListener;
    private MutableLiveData<PlanetDetailRoot> mPlanetDetail;
    private PlanetRepo mPlanetRepo;


    public void init(int thumbnailSize, String planetName) {
        if (mPlanetDetail != null) {
            return;
        }
        mPlanetRepo = PlanetRepo.getInstance();
        mPlanetRepo.mGetPlanetDetailsListener = this.mGetPlanetDetailsListener;
        mPlanetDetail = mPlanetRepo.GetPlanetDetail(thumbnailSize, planetName);
    }

    public MutableLiveData<PlanetDetailRoot> GetPlanetDetails() {
        return mPlanetDetail;
    }

    public void Retry(int thumbnailSize, String planetName) {
        mPlanetDetail = mPlanetRepo.GetPlanetDetail(thumbnailSize,planetName);
    }
}
