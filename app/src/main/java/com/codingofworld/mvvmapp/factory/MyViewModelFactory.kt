package com.codingofworld.mvvmapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingofworld.mvvmapp.repository.MainRepository
import com.codingofworld.mvvmapp.viewmodel.MainViewModel

class MyViewModelFactory constructor(private val repository: MainRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository) as T
        }else{
            throw  java.lang.IllegalArgumentException("ViewModel Not Found")
        }
    }

}