package com.looptrace.planetary.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetDataRoot implements Parcelable {
    @SerializedName("bodies")
    private List<PlanetModel> mPlanetModels;

    public PlanetDataRoot(List<PlanetModel> planetModels) {
        mPlanetModels = planetModels;
    }

    protected PlanetDataRoot(Parcel in) {
    }

    public static final Creator<PlanetDataRoot> CREATOR = new Creator<PlanetDataRoot>() {
        @Override
        public PlanetDataRoot createFromParcel(Parcel in) {
            return new PlanetDataRoot(in);
        }

        @Override
        public PlanetDataRoot[] newArray(int size) {
            return new PlanetDataRoot[size];
        }
    };

    public List<PlanetModel> getPlanetModels() {
        return mPlanetModels;
    }

    public void setPlanetModels(List<PlanetModel> planetModels) {
        mPlanetModels = planetModels;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
