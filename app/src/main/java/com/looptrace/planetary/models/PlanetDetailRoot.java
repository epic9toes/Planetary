package com.looptrace.planetary.models;

import com.google.gson.annotations.SerializedName;

public class PlanetDetailRoot {
    @SerializedName("batchcomplete")
    private String batchcomplete;

    @SerializedName("warnings")
    private Warning warnings;

    @SerializedName("query")
    private DetailQuery query;

    public PlanetDetailRoot(String batchcomplete, Warning warnings, DetailQuery query) {
        this.batchcomplete = batchcomplete;
        this.warnings = warnings;
        this.query = query;
    }

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Warning getWarnings() {
        return warnings;
    }

    public void setWarnings(Warning warnings) {
        this.warnings = warnings;
    }

    public DetailQuery getQuery() {
        return query;
    }

    public void setQuery(DetailQuery query) {
        this.query = query;
    }
}
