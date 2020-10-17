package com.looptrace.planetary.datasource;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBase {

    private static RetrofitBase instance = null;
    public static final String GET_PLANET_BASE_URL = "https://api.le-systeme-solaire.net/rest/";

    public static RetrofitBase getInstance() {
        if (instance == null) {
            instance = new RetrofitBase();
        }

        return instance;
    }

    public Retrofit buildRetrofit(String BaseUrl) {
        return new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
