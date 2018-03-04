package com.example.qrdz4162.cvit.home.model.repo.remote;

import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingBodyRequest;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.repo.NasiListDataSource;
import com.example.qrdz4162.cvit.network.RetrofitClient;
import com.example.qrdz4162.cvit.network.service.NasiApiService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public class NasiListRemoteDataSource implements NasiListDataSource {

    private static NasiListRemoteDataSource nasiListDataSource;
    private final NasiApiService nasiApiService;

    // prevent direct instantiation
    private NasiListRemoteDataSource(){
        nasiApiService = RetrofitClient.getRetrofitInstance().create(NasiApiService.class);
    }

    // NasiListRemoteDataSource single instance instantiation using singleton design pattern
    public static NasiListRemoteDataSource getInstance(){
        if(nasiListDataSource == null){
            nasiListDataSource = new NasiListRemoteDataSource();
        }

        return nasiListDataSource;
    }

    @Override
    public Observable<List<BannerResponse>> getBanners() {
        return nasiApiService.getBanners();
    }

    @Override
    public Observable<List<UpComingEventsResponse>> getUpComingEvents(UpComingBodyRequest userId) {
        return nasiApiService.getUpCommingEvents(userId);
    }

    @Override
    public Observable<List<GeneralEventResponse>> getGeneralEvents() {
        return nasiApiService.getGeneralEvent();
    }
}
