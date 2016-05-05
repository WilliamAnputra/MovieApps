package com.example.williamanputra.movieapp.RecyclerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.williamanputra.movieapp.INTERFACE.MovieApi;
import com.example.williamanputra.movieapp.R;
import com.example.williamanputra.movieapp.TopRatedPojo.Result;

import java.util.List;

/**
 * Created by williamanputra on 5/4/16.
 */
public class TopRatedMovieViewAdapter extends RecyclerView.Adapter<TopRatedMovieViewAdapter.TopRatedAdapter> {

    Context context;

    List<Result> movieResults;

    public TopRatedMovieViewAdapter(Context context, List<Result> movieResults){

        this.context=context;
        this.movieResults=movieResults;

    }

    @Override
    public TopRatedAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.top_fragment,parent,false);

        TopRatedAdapter topRatedAdapter= new TopRatedAdapter(view);

        return topRatedAdapter;
    }

    @Override
    public void onBindViewHolder(TopRatedAdapter holder, int position) {

        Glide.with(context)
                .load(MovieApi.BASE_URL_IMAGE+movieResults.get(position).getPosterPath())
                .into(holder.topRatedCustomView);

    }

    @Override
    public int getItemCount() {

        return movieResults.size();
    }

    public static class TopRatedAdapter extends RecyclerView.ViewHolder{

        ImageView topRatedCustomView;

        public TopRatedAdapter(View itemView) {
            super(itemView);

            topRatedCustomView=(ImageView)itemView.findViewById(R.id.topRatedCustomView);
        }
    }


}
