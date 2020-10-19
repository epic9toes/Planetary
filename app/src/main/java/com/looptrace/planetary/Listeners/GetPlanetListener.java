package com.looptrace.planetary.Listeners;

public interface GetPlanetListener {

    void OnFailure(String s);

    void OnThrowableError(Throwable throwable);
}
