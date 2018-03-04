package com.example.qrdz4162.cvit.home.presenter;

import com.example.qrdz4162.cvit.R;
import com.example.qrdz4162.cvit.base.view.BaseView;
import com.example.qrdz4162.cvit.home.model.NasiListRepo;
import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingBodyRequest;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;
import com.example.qrdz4162.cvit.home.view.MovieView;
import com.example.qrdz4162.cvit.utils.TextUtils;

import java.net.UnknownHostException;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public class HomePresenterImp implements HomePresenter {

    private MovieView movieView;
    private NasiListRepo nasiListRepo;
    private CompositeDisposable mCompositeDisposable;
    Scheduler processScheduler;
    Scheduler androidScheduler;
    private boolean isViewAttached;

    public HomePresenterImp(MovieView movieView, NasiListRepo nasiListRepo, Scheduler processScheduler, Scheduler androidScheduler){
        this.movieView = movieView;
        this.nasiListRepo = nasiListRepo;
        mCompositeDisposable = new CompositeDisposable();
        this.processScheduler = processScheduler;
        this.androidScheduler = androidScheduler;
    }


    @Override
    public void onViewAttached(BaseView view) {
        isViewAttached = true;
    }

    @Override
    public void onViewDetached() {
        isViewAttached = false;
        mCompositeDisposable.clear();
    }

    @Override
    public void loadBanners () {
        movieView.showProgressLoading();

        Disposable disposable = nasiListRepo.getBanners()
                .subscribeOn(processScheduler)
                .observeOn(androidScheduler)
                .subscribeWith(new DisposableObserver<List<BannerResponse>>() {
                    @Override
                    public void onNext(@NonNull List<BannerResponse> bannerResponses) {
                        if (isViewAttached) {
                            if(bannerResponses.size() > 0){
                                movieView.loadBannersList(bannerResponses);
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                        // Handle No Internet Connection
                        if (throwable instanceof UnknownHostException) {
                            if (isViewAttached) {
                                movieView.hideProgressLoading();
                                movieView.showInlineConnectionError();
                            }
                        }
                        // Handle HTTP Exceptions
                        else if (throwable instanceof HttpException) {
                            HttpException exception = (HttpException) throwable;
                            switch (exception.code()) {

                                case 500:
                                    // Handle code 500
                                    break;
                                default:
                                    break;
                            }
                        }
                        // Handle Unknown Exception
                        else {
                            if (isViewAttached) {
                                movieView.hideProgressLoading();
                                movieView.showInlineError(TextUtils.getString(R.string.unknown_error));
                            }
                        }


                    }

                    @Override
                    public void onComplete() {
                        if (isViewAttached) {
                            movieView.hideProgressLoading();
                        }
                    }
                });

        mCompositeDisposable.add(disposable);
    }

    @Override
    public void loadComingEvents(UpComingBodyRequest userId) {

        movieView.showProgressLoading();

        Disposable disposable = nasiListRepo.getUpComingEvents(userId)
                .subscribeOn(processScheduler)
                .observeOn(androidScheduler)
                .subscribeWith(new DisposableObserver<List<UpComingEventsResponse>>() {
                    @Override
                    public void onNext(@NonNull List<UpComingEventsResponse> upComingEventsResponses) {
                        if (isViewAttached) {
                            if(upComingEventsResponses.size() > 0){
                                movieView.loadUpComingEventsList(upComingEventsResponses);
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                        // Handle No Internet Connection
                        if (throwable instanceof UnknownHostException) {
                            if (isViewAttached) {
                                movieView.hideProgressLoading();
                                movieView.showInlineConnectionError();
                            }
                        }
                        // Handle HTTP Exceptions
                        else if (throwable instanceof HttpException) {
                            HttpException exception = (HttpException) throwable;
                            switch (exception.code()) {

                                case 500:
                                    // Handle code 500
                                    break;
                                default:
                                    break;
                            }
                        }
                        // Handle Unknown Exception
                        else {
                            if (isViewAttached) {
                                movieView.hideProgressLoading();
                                movieView.showInlineError(TextUtils.getString(R.string.unknown_error));
                            }
                        }


                    }

                    @Override
                    public void onComplete() {
                        if (isViewAttached) {
                            movieView.hideProgressLoading();
                        }
                    }
                });

        mCompositeDisposable.add(disposable);
    }

    @Override
    public void loadGeneralEvents() {

        movieView.showProgressLoading();

        Disposable disposable = nasiListRepo.getGeneralEvents()
                .subscribeOn(processScheduler)
                .observeOn(androidScheduler)
                .subscribeWith(new DisposableObserver<List<GeneralEventResponse>>() {
                    @Override
                    public void onNext(@NonNull List<GeneralEventResponse> generalEventResponses) {
                        if (isViewAttached) {
                            if(generalEventResponses.size() > 0){
                                movieView.loadGeneralEventsList(generalEventResponses);
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                        // Handle No Internet Connection
                        if (throwable instanceof UnknownHostException) {
                            if (isViewAttached) {
                                movieView.hideProgressLoading();
                                movieView.showInlineConnectionError();
                            }
                        }
                        // Handle HTTP Exceptions
                        else if (throwable instanceof HttpException) {
                            HttpException exception = (HttpException) throwable;
                            switch (exception.code()) {

                                case 500:
                                    // Handle code 500
                                    break;
                                default:
                                    break;
                            }
                        }
                        // Handle Unknown Exception
                        else {
                            if (isViewAttached) {
                                movieView.hideProgressLoading();
                                movieView.showInlineError(TextUtils.getString(R.string.unknown_error));
                            }
                        }


                    }

                    @Override
                    public void onComplete() {
                        if (isViewAttached) {
                            movieView.hideProgressLoading();
                        }
                    }
                });

        mCompositeDisposable.add(disposable);
    }
}
