package com.muzafakar.workshop.network

import com.muzafakar.workshop.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface IMovie {
    @GET("now_playing?api_key=280af572647b3e8153b144e478ba7a36")
    fun getMovies() : Call<MovieResponse>
}