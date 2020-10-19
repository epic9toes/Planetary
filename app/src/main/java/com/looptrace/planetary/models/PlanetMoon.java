package com.looptrace.planetary.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PlanetMoon implements Parcelable {

    private String moon;
    private String rel;

    public PlanetMoon(String moon, String rel) {
        this.moon = moon;
        this.rel = rel;
    }

    protected PlanetMoon(Parcel in) {
        moon = in.readString();
        rel = in.readString();
    }

    public static final Creator<PlanetMoon> CREATOR = new Creator<PlanetMoon>() {
        @Override
        public PlanetMoon createFromParcel(Parcel in) {
            return new PlanetMoon(in);
        }

        @Override
        public PlanetMoon[] newArray(int size) {
            return new PlanetMoon[size];
        }
    };

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(moon);
        dest.writeString(rel);
    }
}
