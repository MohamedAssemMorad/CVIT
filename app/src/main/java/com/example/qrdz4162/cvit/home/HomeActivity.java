package com.example.qrdz4162.cvit.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.qrdz4162.cvit.R;
import com.example.qrdz4162.cvit.base.view.BaseActivity;
import com.example.qrdz4162.cvit.home.view.HomeFragment;
import com.example.qrdz4162.cvit.utils.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public class HomeActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FragmentUtils.replaceFragment(this, new HomeFragment(),R.id.fragment_movie_container , false, "");
    }
}
