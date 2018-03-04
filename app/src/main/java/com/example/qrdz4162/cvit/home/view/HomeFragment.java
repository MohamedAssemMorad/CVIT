package com.example.qrdz4162.cvit.home.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.qrdz4162.cvit.R;
import com.example.qrdz4162.cvit.application.CvitApp;
import com.example.qrdz4162.cvit.base.injection.Injection;
import com.example.qrdz4162.cvit.base.view.BaseFragment;
import com.example.qrdz4162.cvit.home.adapter.ContactsListAdapter;
import com.example.qrdz4162.cvit.home.adapter.EventsListAdapter;
import com.example.qrdz4162.cvit.home.adapter.MyViewPagerAdapter;
import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingBodyRequest;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;
import com.example.qrdz4162.cvit.home.presenter.HomePresenter;
import com.example.qrdz4162.cvit.home.presenter.HomePresenterImp;
import com.example.qrdz4162.cvit.utils.DialogUtils;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qrdz4162 on 2/28/2018.
 */

public class HomeFragment extends BaseFragment implements MovieView, ContactsListAdapter.MovieClickListener,
        EventsListAdapter.MovieClickListener{


    @BindView(R.id.contacts_recycler_view)
    RecyclerView contacts_recycler_view;

    @BindView(R.id.events_recycler_view)
    RecyclerView events_recycler_view;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.v_reload)
    View mReloadView;

    @BindView(R.id.view_pager)
    ViewPager viewPager;


    private SimpleExoPlayer mExoPlayer;
    MediaSource mediaSource;
    String userAgent;

    ArrayList<GeneralEventResponse> arraylist = new ArrayList<GeneralEventResponse>();

    // declare product list components
    private RecyclerView.Adapter contactListAdapter;
    private RecyclerView.LayoutManager contactLayoutManager;
    private ArrayList<UpComingEventsResponse> contactList;

    // declare product list components
    private RecyclerView.Adapter eventListAdapter;
    private RecyclerView.LayoutManager eventLayoutManager;
    private ArrayList<GeneralEventResponse> eventList;

    private MyViewPagerAdapter myViewPagerAdapter;
    private MyViewPagerAdapter adapterView;
    private ArrayList<BannerResponse> bannerList;

    // declare main presenter
    private HomePresenter homePresenter;

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        // initialize recyclerView
        contacts_recycler_view.setHasFixedSize(true);
        contactLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        contacts_recycler_view.setLayoutManager(contactLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(contacts_recycler_view.getContext(),
                DividerItemDecoration.HORIZONTAL);
        contacts_recycler_view.addItemDecoration(dividerItemDecoration);

        contactList = new ArrayList<>();
        contactListAdapter = new ContactsListAdapter(contactList, this);
        contacts_recycler_view.setAdapter(contactListAdapter);

        // initialize recyclerView
        events_recycler_view.setHasFixedSize(true);
        eventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        events_recycler_view.setLayoutManager(eventLayoutManager);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(events_recycler_view.getContext(),
                DividerItemDecoration.HORIZONTAL);
        events_recycler_view.addItemDecoration(dividerItemDecoration1);

        eventList = new ArrayList<>();
        eventListAdapter = new EventsListAdapter(eventList, this);
        events_recycler_view.setAdapter(eventListAdapter);

        bannerList = new ArrayList<>();
        adapterView = new MyViewPagerAdapter(getActivity(), bannerList);
        viewPager.setAdapter(adapterView);

        initializePresenter();

    }



    /**
     * Release ExoPlayer.
     */
    private void releasePlayer() {
        mExoPlayer.stop();
        mExoPlayer.release();
        mExoPlayer = null;
    }

    /**
     * Release the player when the fragment is detached.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        releasePlayer();
    }




    private void initializePresenter() {
        homePresenter = new HomePresenterImp(this,
                Injection.provideMovieListRepo(CvitApp.getInstance()),
                Schedulers.io(),
                AndroidSchedulers.mainThread());
        homePresenter.loadBanners();
        homePresenter.loadComingEvents(new UpComingBodyRequest(55));
        homePresenter.loadGeneralEvents();
    }

    @Override
    public void showProgressLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressLoading() {

        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showInlineError(String error) {
        DialogUtils.getSnackBar(getView(), error, null, null).show();
    }

    @Override
    public void showInlineConnectionError() {

        mReloadView.setVisibility(View.VISIBLE);
        mReloadView.findViewById(R.id.rl_reload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mReloadView.setVisibility(View.GONE);
//                homePresenter.loadMovies(movieName);
            }
        });
    }

    @Override
    public void NoMovieFoundView() {
        showInlineError(getString(R.string.movie_doesnot_exist));
    }


    @Override
    public void onResume() {
        super.onResume();
        homePresenter.onViewAttached(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        homePresenter.onViewDetached();
    }

    @Override
    public void onMovieClick(int position, View v) {

    }

    @Override
    public void loadBannersList(List<BannerResponse> banners) {
        bannerList.clear();
        adapterView.notifyDataSetChanged();

        bannerList.addAll(banners);
        adapterView.notifyDataSetChanged();

    }

    @Override
    public void loadUpComingEventsList(List<UpComingEventsResponse> upComingEvents) {
        contactList.clear();
        contactListAdapter.notifyDataSetChanged();

        contactList.addAll(upComingEvents);
        contactListAdapter.notifyDataSetChanged();
    }

    private void playVideo(Uri mediaUri) {
        mediaSource = new ExtractorMediaSource(mediaUri, new DefaultDataSourceFactory(
                getActivity(), userAgent), new DefaultExtractorsFactory(), null, null);
        mExoPlayer.prepare(mediaSource);
        mExoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void loadGeneralEventsList(List<GeneralEventResponse> generalEvents) {
        eventList.clear();
        eventListAdapter.notifyDataSetChanged();

        eventList.addAll(generalEvents);
        eventListAdapter.notifyDataSetChanged();
    }
}