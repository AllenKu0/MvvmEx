package com.example.mvvmkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel(private var infoRespority: InfoRespority): ViewModel() {
    private var userInfoLiveData = MutableLiveData<UserData>()
    fun callInfo():LiveData<UserData>{
       infoRespority.loadInfo(object : OnTaskFinish{
            override fun onFinish(data: UserData) {
                userInfoLiveData.postValue(data)
            }
        })
        return userInfoLiveData
    }
}