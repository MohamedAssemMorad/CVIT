package com.example.qrdz4162.cvit.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qrdz4162.cvit.R;
import com.example.qrdz4162.cvit.application.CvitApp;
import com.example.qrdz4162.cvit.home.model.entitiy.BannerResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qrdz4162 on 3/1/2018.
 */

public class MyViewPagerAdapter extends PagerAdapter {
    Context mContext;
    private ArrayList<BannerResponse> mDataSet;

    int pos;

    public MyViewPagerAdapter(Context context, ArrayList<BannerResponse> mDataSet) {
        this.mContext = context;
        this.mDataSet = mDataSet;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }



    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == ((View) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.view_pager_item, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.imageViewPager);
        ImageButton imageButton =(ImageButton) view.findViewById(R.id.playButton);
        pos = i;
        Picasso.with(mContext)
                .load(mDataSet.get(i).getImgLink())
                .error(R.drawable.ic_product_placeholder)
                .fit()
                .into(image);
        container.addView(view);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mDataSet.get(pos).getVideoLink())));

            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        container.removeView((View) obj);
    }
}