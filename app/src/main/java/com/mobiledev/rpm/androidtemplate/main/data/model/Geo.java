package com.mobiledev.rpm.androidtemplate.main.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rmanacmol on 10/8/2016.
 */

public class Geo {

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}
