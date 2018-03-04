package com.example.qrdz4162.cvit.home.model;

import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingBodyRequest;
import com.example.qrdz4162.cvit.home.model.repo.NasiListDataSource;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public class NasiListRepo implements NasiListDataSource {

    private static NasiListRepo INSTANCE = null;
    private final NasiListDataSource nasiListRemoteDataSource;

    // Prevent direct instantiation.
    private NasiListRepo(NasiListDataSource nasiListRemoteDataSource) {
        this.nasiListRemoteDataSource = nasiListRemoteDataSource;
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param nasiListRemoteDataSource the backend data source
     * @return the {@link NasiListRepo} instance
     */
    public static NasiListRepo getInstance(NasiListDataSource nasiListRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new NasiListRepo(nasiListRemoteDataSource);
        }
        return INSTANCE;
    }


    @Override
    public Observable<List<BannerResponse>> getBanners() {
        return nasiListRemoteDataSource.getBanners();
    }

    @Override
    public Observable<List<UpComingEventsResponse>> getUpComingEvents(UpComingBodyRequest userId) {
        return nasiListRemoteDataSource.getUpComingEvents(userId);
    }

    @Override
    public Observable<List<GeneralEventResponse>> getGeneralEvents() {
        return nasiListRemoteDataSource.getGeneralEvents();
    }
}
