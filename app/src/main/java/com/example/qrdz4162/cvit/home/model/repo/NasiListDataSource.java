package com.example.qrdz4162.cvit.home.model.repo;

import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingBodyRequest;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface NasiListDataSource {

    Observable<List<BannerResponse>> getBanners();
    Observable<List<UpComingEventsResponse>> getUpComingEvents(UpComingBodyRequest userId);
    Observable<List<GeneralEventResponse>> getGeneralEvents();
    ;
}
