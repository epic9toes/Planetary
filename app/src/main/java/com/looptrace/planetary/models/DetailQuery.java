package com.looptrace.planetary.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Map;

public class DetailQuery {

    @SerializedName("normalized")
    private ArrayList<Normalized> normalized;

    @SerializedName("pages")
    private Map<String, DetailPages> pages;

    public DetailQuery(ArrayList<Normalized> normalized, Map<String, DetailPages> pages) {
        this.normalized = normalized;
        this.pages = pages;
    }

    public ArrayList<Normalized> getNormalized() {
        return normalized;
    }

    public void setNormalized(ArrayList<Normalized> normalized) {
        this.normalized = normalized;
    }

    public Map<String, DetailPages> getPages() {
        return pages;
    }

    public void setPages(Map<String, DetailPages> pages) {
        this.pages = pages;
    }
}
