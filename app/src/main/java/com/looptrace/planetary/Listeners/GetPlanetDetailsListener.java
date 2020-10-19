package com.looptrace.planetary.Listeners;

public interface GetPlanetDetailsListener {

    void OnFailure(String s);

    void OnThrowableError(Throwable throwable);
}
