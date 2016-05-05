package com.example.williamanputra.movieapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.williamanputra.movieapp.INTERFACE.MovieApi;
import com.example.williamanputra.movieapp.R;
import com.example.williamanputra.movieapp.RecyclerViewAdapter.TopRatedMovieViewAdapter;
import com.example.williamanputra.movieapp.TopRatedPojo.Result;
import com.example.williamanputra.movieapp.TopRatedPojo.TopRatedMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRateFragment extends Fragment {


    RecyclerView mRecyclerView;
    TopRatedMovieViewAdapter mTopRatedMovieAdapter;

    List<Result> topRatedList;


    public TopRateFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_toprated, container, false);

        MovieApi.Factory.getInstance().getTopRated().enqueue(new Callback<TopRatedMovie>() {
            @Override
            public void onResponse(Call<TopRatedMovie> call, Response<TopRatedMovie> response) {

                topRatedList= response.body().getResults();

                mTopRatedMovieAdapter= new TopRatedMovieViewAdapter(getActivity(),topRatedList);
                mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                mRecyclerView.setAdapter(mTopRatedMovieAdapter);


            }

            @Override
            public void onFailure(Call<TopRatedMovie> call, Throwable t) {

                Log.e("ERROR MAN", t + " ");
            }
        });


        mRecyclerView=(RecyclerView)view.findViewById(R.id.topRatedRecyclerView);

        return view;


    }


}
