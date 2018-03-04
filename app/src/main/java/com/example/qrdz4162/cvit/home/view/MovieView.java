package com.example.qrdz4162.cvit.home.view;

import com.example.qrdz4162.cvit.base.view.BaseView;
import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;

import java.util.List;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface MovieView extends BaseView{

    /**
     * @desc display list of movies returned from presenter in recyclerView
     * @param banners list of UpComingEventsResponse holds movie data needed
     */
    void loadBannersList(List<BannerResponse> banners);
    void loadUpComingEventsList(List<UpComingEventsResponse> upComingEvents);
    void loadGeneralEventsList(List<GeneralEventResponse> generalEvents);
    void NoMovieFoundView();



    }
