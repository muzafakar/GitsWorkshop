package com.muzafakar.workshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muzafakar.workshop.R
import com.muzafakar.workshop.model.Movie
import com.muzafakar.workshop.network.API
import kotlinx.android.synthetic.main.item_movie.view.*

class AdapterMovie : RecyclerView.Adapter<AdapterMovie.ViewHolder>() {
    // list penampung data <Movie>
    private val listMovie = mutableListOf<Movie>()

    // method untuk mengisi penampung
    fun addData(data: List<Movie>) {
        listMovie.addAll(data)
        notifyDataSetChanged()
    }

    // method untuk membuat objek dari class ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))


    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.tvTitle.text = movie.title
            itemView.tvOverview.text = movie.overview
            itemView.tvReleaseDate.text = movie.release_date

            // TODO load image
            val imageUrl = API.IMAGE + movie.poster_path
            Glide.with(itemView).load(imageUrl).centerCrop().into(itemView.imgPoster)

            itemView.setOnClickListener {
                // TODO handle click
            }
        }
    }

}