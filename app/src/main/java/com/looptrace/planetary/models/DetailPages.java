package com.looptrace.planetary.models;

import com.google.gson.annotations.SerializedName;

public class DetailPages {
    @SerializedName("pageid")
    private int pageid;

    @SerializedName("ns")
    private int ns;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("descriptionsource")
    private String descriptionsource;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @SerializedName("pageimage")
    private String pageimage;

    @SerializedName("extract")
    private String extract;

    public DetailPages(int pageid, int ns, String title, String description, String descriptionsource, Thumbnail thumbnail, String pageimage, String extract) {
        this.pageid = pageid;
        this.ns = ns;
        this.title = title;
        this.description = description;
        this.descriptionsource = descriptionsource;
        this.thumbnail = thumbnail;
        this.pageimage = pageimage;
        this.extract = extract;
    }

    public int getPageid() {
        return pageid;
    }

    public void setPageid(int pageid) {
        this.pageid = pageid;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionsource() {
        return descriptionsource;
    }

    public void setDescriptionsource(String descriptionsource) {
        this.descriptionsource = descriptionsource;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPageimage() {
        return pageimage;
    }

    public void setPageimage(String pageimage) {
        this.pageimage = pageimage;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }
}
