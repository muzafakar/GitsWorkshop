package com.muzafakar.workshop.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muzafakar.workshop.R
import com.muzafakar.workshop.adapter.AdapterMovie
import com.muzafakar.workshop.model.MovieResponse
import com.muzafakar.workshop.network.API
import com.muzafakar.workshop.network.IMovie
import com.muzafakar.workshop.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var adapterMovie: AdapterMovie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        adapterMovie = AdapterMovie()

        rvMovie.adapter = adapterMovie
        // layoutmanager
        rvMovie.layoutManager = LinearLayoutManager(this) // vertical

        getData()

    }

    private fun getData() {
        Log.d("BASE_URL", API.BASE_URL)
        val iMovie = Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMovie::class.java)

        // Threading
        iMovie.getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(
                    this@HomeActivity,
                    "Request gagal: ${t.localizedMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val body = response.body()
                if (body != null) {
                    adapterMovie.addData(body.results)
                }
            }
        })
    }
}
