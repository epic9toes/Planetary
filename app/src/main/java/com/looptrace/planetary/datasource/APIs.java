package com.looptrace.planetary.datasource;

import androidx.lifecycle.MutableLiveData;

import com.looptrace.planetary.models.PlanetDataRoot;
import com.looptrace.planetary.models.PlanetDetailRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIs {

    @GET("bodies/?filter[]=isPlanet,neq,0")
    Call<PlanetDataRoot> getPlanets();

    @GET("api.php/")
    Call<PlanetDetailRoot> getPlanetDetail(@Query("action") String action, @Query("format") String format, @Query("pithumbsize") int pithumbsize,
                                           @Query("titles") String titles, @Query("prop") String prop);

}
