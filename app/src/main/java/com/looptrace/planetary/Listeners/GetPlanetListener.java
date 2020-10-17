package com.looptrace.planetary.Listeners;

import androidx.lifecycle.MutableLiveData;

import com.looptrace.planetary.models.PlanetData;

public interface GetPlanetListener {

    void OnStarted();

    void OnSuccess(MutableLiveData<PlanetData> planets);

    void OnFailure(String s);

    void OnThrowableError(Throwable throwable);
}
