package com.exam.ph.examination.models.seatmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */
@Data
public class Available implements Serializable {
    @SerializedName("seats")
    @Expose
    private ArrayList<String> seats;
    @SerializedName("seat_count")
    @Expose
    private Integer seatCount;
}
