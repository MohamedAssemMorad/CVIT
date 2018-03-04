package com.example.qrdz4162.cvit.home.presenter;

import com.example.qrdz4162.cvit.base.presenter.BasePresenter;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingBodyRequest;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface HomePresenter extends BasePresenter{

    void loadBanners();
    void loadComingEvents(UpComingBodyRequest userId);
    void loadGeneralEvents();

}
