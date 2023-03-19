package com.codingofworld.mvvmapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingofworld.mvvmapp.databinding.AdapterMovieBinding
import com.codingofworld.mvvmapp.model.Movie

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var movies= mutableListOf<Movie>()
    fun  setMovieList(movie: List<Movie>){
        this.movies=movie.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflator=LayoutInflater.from(parent.context)
        val binding=AdapterMovieBinding.inflate(inflator,parent,false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return  movies.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie=movies[position]
        holder.binding.name.text=movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }
}
class  MainViewHolder(val binding:AdapterMovieBinding):RecyclerView.ViewHolder(binding.root)