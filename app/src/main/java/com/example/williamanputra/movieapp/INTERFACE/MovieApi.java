package com.example.williamanputra.movieapp.INTERFACE;

import com.example.williamanputra.movieapp.PopularMoviePOJO.MovieModel;
import com.example.williamanputra.movieapp.TopRatedPojo.TopRatedMovie;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by williamanputra on 4/26/16.
 */
public interface MovieApi {

     String BASE_URL ="http://api.themoviedb.org/3/";
        String BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w396";
         String API_KEY = "7c0b6d6d89816148299532a915c160f4";



//    String BASE_URL = "http://api.themoviedb.org";
//    http://api.themoviedb.org/3/movie/latest?api_key=7c0b6d6d89816148299532a915c160f4


    @GET("movie/popular?api_key=" + API_KEY)
   Call<MovieModel> getMovies();

    @GET("movie/top_rated?api_key=" + API_KEY)
    Call<TopRatedMovie> getTopRated();

    class Factory {

        static MovieApi service;

        public static MovieApi getInstance() {

            if (service == null) {
//                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();

                service = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(MovieApi.class);
            }

           return  service;
        }



    }

}

