package com.looptrace.planetary.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Mass implements Parcelable {

    private float massValue;
    private int massExponent;

    public Mass(float massValue, int massExponent) {
        this.massValue = massValue;
        this.massExponent = massExponent;
    }

    protected Mass(Parcel in) {
        massValue = in.readFloat();
        massExponent = in.readInt();
    }

    public static final Creator<Mass> CREATOR = new Creator<Mass>() {
        @Override
        public Mass createFromParcel(Parcel in) {
            return new Mass(in);
        }

        @Override
        public Mass[] newArray(int size) {
            return new Mass[size];
        }
    };

    public float getMassValue() {
        return massValue;
    }

    public void setMassValue(float massValue) {
        this.massValue = massValue;
    }

    public int getMassExponent() {
        return massExponent;
    }

    public void setMassExponent(int massExponent) {
        this.massExponent = massExponent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(massValue);
        dest.writeInt(massExponent);
    }
}
