package com.exam.ph.examination.models;

import com.exam.ph.examination.models.schedulemodel.Cinemas;
import com.exam.ph.examination.models.schedulemodel.Dates;
import com.exam.ph.examination.models.schedulemodel.Times;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */
@Data
public class ScheduleResponse implements Serializable {

    @SerializedName("dates")
    @Expose
    private ArrayList<Dates> dates;

    @SerializedName("cinemas")
    @Expose
    private ArrayList<Cinemas> cinemas;

    @SerializedName("times")
    @Expose
    private ArrayList<Times> times;
}
