package com.example.qrdz4162.cvit.network.service;

import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingBodyRequest;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface NasiApiService {

    @GET("bannar.php")
    Observable<List<BannerResponse>> getBanners();

    @POST("upComingEvent.php")
    Observable<List<UpComingEventsResponse>> getUpCommingEvents(@Body UpComingBodyRequest upComingBodyRequest);

    @GET("generalEvent.php")
    Observable<List<GeneralEventResponse>> getGeneralEvent();
}
