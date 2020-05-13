package com.muzafakar.workshop.network

import com.muzafakar.workshop.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface IMovie {
    @GET("now_playing?api_key=${API.API_KEY}")
    fun getMovies() : Call<MovieResponse>
}