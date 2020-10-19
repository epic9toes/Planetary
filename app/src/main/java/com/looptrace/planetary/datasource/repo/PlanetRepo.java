package com.looptrace.planetary.datasource.repo;

import androidx.lifecycle.MutableLiveData;

import com.looptrace.planetary.Listeners.GetPlanetDetailsListener;
import com.looptrace.planetary.Listeners.GetPlanetListener;
import com.looptrace.planetary.datasource.APIs;
import com.looptrace.planetary.datasource.RetrofitBase;
import com.looptrace.planetary.models.PlanetDataRoot;
import com.looptrace.planetary.models.PlanetDetailRoot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetRepo {

    private static PlanetRepo instance = null;
    private MutableLiveData<PlanetDataRoot> mPlanetDataRootMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<PlanetDetailRoot> mDetailRootMutableLiveData = new MutableLiveData<>();
    public GetPlanetListener mGetPlanetListener;
    public GetPlanetDetailsListener mGetPlanetDetailsListener;

    public static PlanetRepo getInstance() {
        if (instance == null) {
            instance = new PlanetRepo();
        }
        return instance;
    }

    public MutableLiveData<PlanetDataRoot> GetPlanets() {
        APIs apIs = RetrofitBase.getInstance().buildRetrofit(RetrofitBase.GET_SOLAIRE_BASE_URL).create(APIs.class);
        apIs.getPlanets().enqueue(new Callback<PlanetDataRoot>() {
            @Override
            public void onResponse(Call<PlanetDataRoot> call, Response<PlanetDataRoot> response) {
                if (!response.isSuccessful()) {
                    mGetPlanetListener.OnFailure("An " + response.code() + " has occurred, please try again later.");
                } else {
                    mPlanetDataRootMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PlanetDataRoot> call, Throwable t) {
                mGetPlanetListener.OnThrowableError(t);
            }
        });
        return mPlanetDataRootMutableLiveData;
    }

    public MutableLiveData<PlanetDetailRoot> GetPlanetDetail(int pithumbsize, String titles) {
        APIs apIs = RetrofitBase.getInstance().buildRetrofit(RetrofitBase.GET_WIKI_BASE_URL).create(APIs.class);
        apIs.getPlanetDetail("query", "json", pithumbsize, titles, "description|pageimages|extracts")
                .enqueue(new Callback<PlanetDetailRoot>() {
            @Override
            public void onResponse(Call<PlanetDetailRoot> call, Response<PlanetDetailRoot> response) {
                if (!response.isSuccessful()) {
                    mGetPlanetDetailsListener.OnFailure("An " + response.code() + " has occurred, please try again later.");
                } else {
                    mDetailRootMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PlanetDetailRoot> call, Throwable t) {
                mGetPlanetDetailsListener.OnThrowableError(t);
            }
        });
        return mDetailRootMutableLiveData;
    }
}
