package com.looptrace.planetary.models;

import com.google.gson.annotations.SerializedName;

public class Extract {
    @SerializedName("*")
    private String asterik;

    public Extract(String asterik) {
        this.asterik = asterik;
    }

    public String getAsterik() {
        return asterik;
    }

    public void setAsterik(String asterik) {
        this.asterik = asterik;
    }
}
