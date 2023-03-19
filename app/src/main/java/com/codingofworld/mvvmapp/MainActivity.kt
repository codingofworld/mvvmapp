package com.codingofworld.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.codingofworld.mvvmapp.adapter.MainAdapter
import com.codingofworld.mvvmapp.databinding.ActivityMainBinding
import com.codingofworld.mvvmapp.factory.MyViewModelFactory
import com.codingofworld.mvvmapp.repository.MainRepository
import com.codingofworld.mvvmapp.services.RetrofitService
import com.codingofworld.mvvmapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recyclerview.adapter = adapter
        viewModel.movieList.observe(this, Observer {
            Log.e(TAG, "onCreate:$it")
            adapter.setMovieList(it)

        })
        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()
    }
}