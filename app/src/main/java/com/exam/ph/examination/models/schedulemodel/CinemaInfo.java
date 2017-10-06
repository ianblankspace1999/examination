package com.exam.ph.examination.models.schedulemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */

@Data
public class CinemaInfo implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("cinema_id")
    @Expose
    private String cinemaId;

    @SerializedName("label")
    @Expose
    private String label;
}
