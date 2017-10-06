package com.exam.ph.examination.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

/**
 * Created by IanBlanco on 03/10/2017.
 */
@Data
public class MovieResponse implements Serializable {

    @SerializedName("movie_id")
    @Expose
    private String movieId;

    @SerializedName("advisory_rating")
    @Expose
    private String advisoryRating;

    @SerializedName("canonical_title")
    @Expose
    private String canonicalTitle;

    @SerializedName("cast")
    @Expose
    private ArrayList<String> cast;

    @SerializedName("genre")
    @Expose
    private String genre;

    @SerializedName("has_schedules")
    @Expose
    private int hasSchedules;

    @SerializedName("is_inactive")
    @Expose
    private int isInactive;

    @SerializedName("is_showing")
    @Expose
    private int isShowing;

    @SerializedName("link_name")
    @Expose
    private String linkName;

    @SerializedName("poster")
    @Expose
    private String poster;

    @SerializedName("poster_landscape")
    @Expose
    private String posterLandscape;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("runtime_mins")
    @Expose
    private int runtimeMins;

    @SerializedName("synopsis")
    @Expose
    private String synopsis;

    @SerializedName("trailer")
    @Expose
    private String trailer;

    @SerializedName("average_rating")
    @Expose
    private String averageRating;

    @SerializedName("total_reviews")
    @Expose
    private String totalReviews;

    @SerializedName("variants")
    @Expose
    private ArrayList<String> variants;

    @SerializedName("theater")
    @Expose
    private String theater;

    @SerializedName("order")
    @Expose
    private int order;

    @SerializedName("is_featured")
    @Expose
    private int isFeatured;

    @SerializedName("watch_list")
    @Expose
    private boolean watchList;

    @SerializedName("your_rating")
    @Expose
    private int yourRating;
}
