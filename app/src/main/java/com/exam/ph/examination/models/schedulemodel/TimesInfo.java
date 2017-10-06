package com.exam.ph.examination.models.schedulemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */
@Data
public class TimesInfo implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("schedule_id")
    @Expose
    private String scheduleId;

    @SerializedName("popcorn_price")
    @Expose
    private String popcornPrice;

    @SerializedName("popcorn_label")
    @Expose
    private String popcornLabel;

    @SerializedName("seating_type")
    @Expose
    private String seatingType;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("variant")
    @Expose
    private String variant;
}
