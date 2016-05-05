package com.example.williamanputra.movieapp.RecyclerViewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.williamanputra.movieapp.Fragments.PopularFragment;
import com.example.williamanputra.movieapp.INTERFACE.Communicator;
import com.example.williamanputra.movieapp.INTERFACE.MovieApi;
import com.example.williamanputra.movieapp.PopularMoviePOJO.Result;
import com.example.williamanputra.movieapp.R;

import java.util.List;

/**
 * Created by williamanputra on 5/3/16.
 */
public class PopularMovieViewAdapter extends RecyclerView.Adapter<PopularMovieViewAdapter.CustomViewHolder> {

    Context context;
    List<Result> movieModelList;
    Communicator comm;

    public void addMovies(List<Result> newResult) {
        movieModelList.addAll(newResult);
        notifyDataSetChanged();
    }
    public PopularMovieViewAdapter(Context context, List<Result> movieModelList,Communicator comm){

        //add something later
        this.context=context;

//        MovieModel movieModel = new MovieModel();

        this.movieModelList= movieModelList;

//       this.movieModelList= movieModel.getResults();

        this.comm=comm;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.popular_movie_custom_layout,parent,false);

        CustomViewHolder customViewHolder= new CustomViewHolder(view);

        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Glide.with(context)
                .load(MovieApi.BASE_URL_IMAGE+movieModelList.get(position).getPosterPath())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {

        return movieModelList.size();

    }


    public  class CustomViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;

        public CustomViewHolder(View itemView) {
            super(itemView);

            mImageView=(ImageView)itemView.findViewById(R.id.popularImageView);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    comm.communicate(movieModelList.get(getLayoutPosition()));

                }
            });

        }
    }
}
