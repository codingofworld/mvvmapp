package com.codingofworld.mvvmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingofworld.mvvmapp.model.Movie
import com.codingofworld.mvvmapp.repository.MainRepository
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()
    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : retrofit2.Callback<List<Movie>> {
            override fun onResponse(
                call: retrofit2.Call<List<Movie>>,
                response: Response<List<Movie>>
            ) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: retrofit2.Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}