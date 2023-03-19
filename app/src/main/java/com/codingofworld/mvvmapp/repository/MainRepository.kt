package com.codingofworld.mvvmapp.repository

import com.codingofworld.mvvmapp.services.RetrofitService

class MainRepository constructor(private  val retrofitService: RetrofitService) {
    fun getAllMovies()=retrofitService.getAllMovies()
}