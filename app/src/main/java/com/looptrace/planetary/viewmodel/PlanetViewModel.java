package com.looptrace.planetary.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.looptrace.planetary.Listeners.GetPlanetListener;
import com.looptrace.planetary.datasource.repo.PlanetRepo;
import com.looptrace.planetary.models.PlanetData;
import com.looptrace.planetary.models.PlanetModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetViewModel extends ViewModel {

    public GetPlanetListener mGetPlanetListener;
    private MutableLiveData<List<PlanetModel>> mPlanets;
    private PlanetRepo mPlanetRepo;

    public PlanetViewModel() {
        init();
    }

    private void init() {
        if (mPlanets != null) {
            return;
        }
        mPlanetRepo = PlanetRepo.getInstance();
    }

    public void GetPlanets() {
        mGetPlanetListener.OnStarted();

        mPlanetRepo.GetPlanets().enqueue(new Callback<PlanetData>() {
            @Override
            public void onResponse(Call<PlanetData> call, Response<PlanetData> response) {
                if (!response.isSuccessful()) {
                    mGetPlanetListener.OnFailure("An " + response.code() + " has occurred, please try again later.");
                } else {
                    MutableLiveData<PlanetData> data = new MutableLiveData<>();
                    data.setValue(response.body());
                    mGetPlanetListener.OnSuccess(data);
                }
            }

            @Override
            public void onFailure(Call<PlanetData> call, Throwable t) {
                mGetPlanetListener.OnThrowableError(t);
            }
        });

    }
}
