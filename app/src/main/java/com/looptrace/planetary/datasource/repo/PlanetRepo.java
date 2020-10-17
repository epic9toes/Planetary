package com.looptrace.planetary.datasource.repo;

import com.looptrace.planetary.datasource.APIs;
import com.looptrace.planetary.datasource.RetrofitBase;
import com.looptrace.planetary.models.PlanetData;

import retrofit2.Call;

public class PlanetRepo {

    private static PlanetRepo instance = null;

    public static PlanetRepo getInstance() {
        if (instance == null) {
            instance = new PlanetRepo();
        }
        return instance;
    }

    public Call<PlanetData> GetPlanets() {
        APIs apIs = RetrofitBase.getInstance().buildRetrofit(RetrofitBase.GET_PLANET_BASE_URL).create(APIs.class);
        return apIs.getPlanets();


    }
}
