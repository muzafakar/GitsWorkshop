package com.muzafakar.workshop.model

data class Movie(
    val title: String,
    val overview: String,
    val release_date: String,
    val backdrop_path: String,
    val poster_path: String,
    val vote_average: Float // 7.8
)

data class MovieResponse(
    val results: List<Movie>
)