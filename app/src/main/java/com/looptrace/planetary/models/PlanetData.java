package com.looptrace.planetary.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetData {
    @SerializedName("bodies")
    private List<PlanetModel> mPlanetModels;

    public PlanetData(List<PlanetModel> planetModels) {
        mPlanetModels = planetModels;
    }

    public List<PlanetModel> getPlanetModels() {
        return mPlanetModels;
    }

    public void setPlanetModels(List<PlanetModel> planetModels) {
        mPlanetModels = planetModels;
    }
}
