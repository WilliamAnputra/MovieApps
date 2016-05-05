package com.example.williamanputra.movieapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.williamanputra.movieapp.DetailActivity;
import com.example.williamanputra.movieapp.INTERFACE.Communicator;
import com.example.williamanputra.movieapp.INTERFACE.MovieApi;
import com.example.williamanputra.movieapp.MainActivity;
import com.example.williamanputra.movieapp.PopularMoviePOJO.MovieModel;
import com.example.williamanputra.movieapp.PopularMoviePOJO.Result;
import com.example.williamanputra.movieapp.R;
import com.example.williamanputra.movieapp.RecyclerViewAdapter.PopularMovieViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment implements Communicator {

    RecyclerView mRecyclerView;
    PopularMovieViewAdapter adapter;
    Communicator comm;
    List<Result> movieList;


    public PopularFragment() {

    // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_popular,container,false);

        MovieApi.Factory.getInstance().getMovies().enqueue(new Callback<MovieModel>() {

            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                movieList=response.body().getResults();

                mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                adapter= new PopularMovieViewAdapter(getActivity(),movieList,PopularFragment.this);
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

                Log.i("error", t + " ");
            }

        });

        mRecyclerView=(RecyclerView)view.findViewById(R.id.popularRecyclerView);

        return view;

    }


    @Override
    public void communicate(Result pos) {

//        Bundle bundle= new Bundle();
//        bundle.putParcelableArrayList("result_list",pos);

        Intent intent= new Intent(getActivity(),DetailActivity.class);

        intent.putExtra("DATA", pos);
//        intent.putExtras(bundle);
        startActivity(intent);


    }
}
