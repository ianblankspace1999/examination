package com.exam.ph.examination.repository;

import android.util.Log;

import com.exam.ph.examination.models.ErrorResponse;
import com.exam.ph.examination.models.MovieResponse;
import com.exam.ph.examination.models.ScheduleResponse;
import com.exam.ph.examination.models.SeatResponse;
import com.exam.ph.examination.restclient.restinterface.TestInterface;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by IanBlanco on 03/10/2017.
 */

public class DataRepository {

    private Retrofit mRetrofit;


    public Observable<MovieResponse> getMovies(final TestInterface testInterface) {
        return testInterface.getMovies().flatMap(new Func1<Response<MovieResponse>, Observable<MovieResponse>>() {
            @Override
            public Observable<MovieResponse> call(Response<MovieResponse> listResponse) {
                if (listResponse.isSuccessful()) {
                    return Observable.just(listResponse.body());
                }
                try {
                    Converter<ResponseBody, ErrorResponse> converter = mRetrofit.responseBodyConverter(ErrorResponse.class, new Annotation[0]);
                    ErrorResponse error = converter.convert(listResponse.errorBody());

                    return Observable.error(error);
                } catch (IOException e) {
                    Log.i("Error,", "Error:error");
                    return null;
                }

            }
        });
    }


    public Observable<ScheduleResponse> getSchedules(final TestInterface testInterface) {
        return testInterface.getSchedule().flatMap(new Func1<Response<ScheduleResponse>, Observable<ScheduleResponse>>() {
            @Override
            public Observable<ScheduleResponse> call(Response<ScheduleResponse> listResponse) {
                if (listResponse.isSuccessful()) {
                    return Observable.just(listResponse.body());
                }
                try {
                    Converter<ResponseBody, ErrorResponse> converter = mRetrofit.responseBodyConverter(ErrorResponse.class, new Annotation[0]);
                    ErrorResponse error = converter.convert(listResponse.errorBody());

                    return Observable.error(error);
                } catch (IOException e) {
                    Log.i("Error,", "Error:error");
                    return null;
                }

            }
        });
    }

    public Observable<SeatResponse> getSeats(final TestInterface testInterface) {
        return testInterface.getSeats().flatMap(new Func1<Response<SeatResponse>, Observable<SeatResponse>>() {
            @Override
            public Observable<SeatResponse> call(Response<SeatResponse> listResponse) {
                if (listResponse.isSuccessful()) {
                    return Observable.just(listResponse.body());
                }
                try {
                    Converter<ResponseBody, ErrorResponse> converter = mRetrofit.responseBodyConverter(ErrorResponse.class, new Annotation[0]);
                    ErrorResponse error = converter.convert(listResponse.errorBody());

                    return Observable.error(error);
                } catch (IOException e) {
                    Log.i("Error,", "Error:error");
                    return null;
                }

            }
        });
    }

}
