package com.example.srez.data.model;

import com.google.gson.annotations.SerializedName;

public class CatResponsePOJO {
    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
