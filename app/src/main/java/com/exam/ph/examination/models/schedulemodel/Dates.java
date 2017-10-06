package com.exam.ph.examination.models.schedulemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */
@Data
public class Dates implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("date")
    @Expose
    private String date;


}
