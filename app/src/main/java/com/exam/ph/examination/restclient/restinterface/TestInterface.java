package com.exam.ph.examination.restclient.restinterface;

import com.exam.ph.examination.models.MovieResponse;
import com.exam.ph.examination.models.ResponseModel;
import com.exam.ph.examination.models.ScheduleResponse;
import com.exam.ph.examination.models.SeatResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by IanBlanco on 10/04/2017.
 */

public interface TestInterface {

    @GET("/movie.json")
    Observable<Response<MovieResponse>> getMovies();


    @GET("/schedule.json")
    Observable<Response<ScheduleResponse>> getSchedule();

    @GET("/seatmap.json")
    Observable<Response<SeatResponse>> getSeats();

}
