package com.example.qrdz4162.cvit.application;

import android.app.Application;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public class CvitApp extends Application{
    // API key needed for making requests
    public static final String API_KEY = "2696829a81b1b5827d515ff121700838";
    // image url
    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w92";

    private static CvitApp cvitApp;

    public static CvitApp getInstance(){

        if (cvitApp == null){
            throw new IllegalStateException("something went wrong !!, no application attched");
        }
        return cvitApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        cvitApp = this;
    }
}
