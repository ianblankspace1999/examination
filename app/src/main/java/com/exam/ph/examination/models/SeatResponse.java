package com.exam.ph.examination.models;

import com.exam.ph.examination.models.seatmodel.Available;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */

@Data
public class SeatResponse implements Serializable {

    @SerializedName("seatmap")
    @Expose
    private ArrayList<ArrayList<String>> seatmap;
    @SerializedName("available")
    @Expose
    private Available available;


}
