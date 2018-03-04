package com.example.qrdz4162.cvit.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.qrdz4162.cvit.R;
import com.example.qrdz4162.cvit.application.CvitApp;
import com.example.qrdz4162.cvit.home.model.entitiy.GeneralEventResponse;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

/**
 * MovieListAdapter create adapter for movieList holds movieListItem to display in recycler view
 */
public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.DataObjectHolder> {

    private ArrayList<GeneralEventResponse> mDataSet;
    private Context context;
    private static MovieClickListener mMovieClickListener;

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_general_event, parent, false);
        context = parent.getContext();

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        GeneralEventResponse generalEventResponse = mDataSet.get(position);

        holder.textView_event_name.setText(generalEventResponse.getTitle());
        Picasso.with(context)
                .load(generalEventResponse.getImage())
                .error(R.drawable.ic_product_placeholder)
                .fit()
                .into(holder.profile_image);

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.profile_image)
        CircleImageView profile_image;

        @BindView(R.id.textView_event_name)
        TextView textView_event_name;

        public DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            //adding listener...
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mMovieClickListener.onMovieClick(getAdapterPosition(), v);
        }
    }


    public EventsListAdapter(ArrayList<GeneralEventResponse> mDataSet, MovieClickListener mMovieClickListener) {
        this.mDataSet = mDataSet;
        this.mMovieClickListener = mMovieClickListener;
    }

    public interface MovieClickListener {
        void onMovieClick(int position, View v);
    }
}
