package com.example.mvvmkotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class InfoFactory (var infoRespority: InfoRespority) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(InfoViewModel::class.java)){
            return InfoViewModel(infoRespority) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class");
    }
}