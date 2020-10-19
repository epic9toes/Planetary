package com.looptrace.planetary.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Vol implements Parcelable {

    private float volValue;
    private int volExponent;

    public Vol(float volValue, int volExponent) {
        this.volValue = volValue;
        this.volExponent = volExponent;
    }

    protected Vol(Parcel in) {
        volValue = in.readFloat();
        volExponent = in.readInt();
    }

    public static final Creator<Vol> CREATOR = new Creator<Vol>() {
        @Override
        public Vol createFromParcel(Parcel in) {
            return new Vol(in);
        }

        @Override
        public Vol[] newArray(int size) {
            return new Vol[size];
        }
    };

    public float getVolValue() {
        return volValue;
    }

    public void setVolValue(float volValue) {
        this.volValue = volValue;
    }

    public int getVolExponent() {
        return volExponent;
    }

    public void setVolExponent(int volExponent) {
        this.volExponent = volExponent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(volValue);
        dest.writeInt(volExponent);
    }
}
