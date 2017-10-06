package com.exam.ph.examination.models.schedulemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */
@Data
public class Times implements Serializable {

    @SerializedName("parent")
    @Expose
    private String parent;

    @SerializedName("times")
    @Expose
    private ArrayList<TimesInfo> timesInfos;
}
