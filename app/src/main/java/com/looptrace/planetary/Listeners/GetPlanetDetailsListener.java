package com.looptrace.planetary.Listeners;

import androidx.lifecycle.MutableLiveData;

import com.looptrace.planetary.models.PlanetDetailRoot;

public interface GetPlanetDetailsListener {

    void OnSuccess();

    void OnFailure(String s);

    void OnThrowableError(Throwable throwable);
}
