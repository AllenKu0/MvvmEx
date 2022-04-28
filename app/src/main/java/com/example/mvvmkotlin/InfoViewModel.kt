package com.example.mvvmkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class InfoViewModel(private var infoRespority: InfoRespority): ViewModel() {
var userInfoLiveData = MutableLiveData<List<Post>>()

    private var a=MutableLiveData<Int>()

    fun callInfo():LiveData<List<Post>>{
       infoRespority.loadInfo(object : InfoRespority.OnTaskFinish {
           override fun onFinish(data: List<Post>) {
               userInfoLiveData.postValue(data)
           }
       })
        return userInfoLiveData
    }



//    val live=Transformations.switchMap(a,
//        object :F)
    fun callLive(){
//        a.postValue(1)
//        return infoRespority.loadInfoLive()
    }
}