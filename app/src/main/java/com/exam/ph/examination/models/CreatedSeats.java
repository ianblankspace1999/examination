package com.exam.ph.examination.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.exam.ph.examination.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by ian.blanco on 10/5/2017.
 */
@Data
public class CreatedSeats {

    public CreatedSeats(int id, String seatPosition) {
        this.id = id;
        this.seatPosition = seatPosition;
    }

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("seat_position")
    @Expose
    private String seatPosition;


    public View getViewDisplay(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_seats, null);
        view.setId(id);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        tvName.setTag(id);
        tvName.setText("" + seatPosition);
        return view;
    }
}
