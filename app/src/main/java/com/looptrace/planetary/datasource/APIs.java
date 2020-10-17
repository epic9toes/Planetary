package com.looptrace.planetary.datasource;

import com.looptrace.planetary.models.PlanetData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {

    @GET("bodies/?filter[]=isPlanet,neq,0")
    Call<PlanetData> getPlanets();
}
