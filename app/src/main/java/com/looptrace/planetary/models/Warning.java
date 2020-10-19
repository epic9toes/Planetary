package com.looptrace.planetary.models;

import com.google.gson.annotations.SerializedName;

public class Warning {
    @SerializedName("extract")
    private Extract extracts;

    public Warning(Extract extracts) {
        this.extracts = extracts;
    }

    public Extract getExtracts() {
        return extracts;
    }

    public void setExtracts(Extract extracts) {
        this.extracts = extracts;
    }
}
