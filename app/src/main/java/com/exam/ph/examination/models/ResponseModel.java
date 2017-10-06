package com.exam.ph.examination.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by IanBlanco on 5/30/2017.
 */
public class ResponseModel {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("industry")
    @Expose
    private String industry;

    @SerializedName("Address")
    @Expose
    private String address;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("operation_hours")
    @Expose
    private String operationHours;

    @SerializedName("dress_code")
    @Expose
    private String dressCode;

    @SerializedName("banner")
    @Expose
    private String banner;

    @SerializedName("banner_landscape")
    @Expose
    private String bannerLandscape;

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getOperationHours() {
        return operationHours;
    }

    public String getDressCode() {
        return dressCode;
    }

    public String getBanner() {
        return banner;
    }

    public String getBannerLandscape() {
        return bannerLandscape;
    }
}
