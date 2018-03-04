package com.example.qrdz4162.cvit.base.injection;

import android.content.Context;

import com.example.qrdz4162.cvit.home.model.NasiListRepo;
import com.example.qrdz4162.cvit.home.model.repo.remote.NasiListRemoteDataSource;

/**
 * Created by qrdz4162 on 2/8/2018.
 */

public class Injection {

    /**
     * Enables injection of mock implementations for
     * {@link NasiListRepo} at compile time. This is useful to isolate the dependencies.
     */
    public static NasiListRepo provideMovieListRepo(Context context) {
        return NasiListRepo.getInstance(NasiListRemoteDataSource.getInstance());
    }


}
