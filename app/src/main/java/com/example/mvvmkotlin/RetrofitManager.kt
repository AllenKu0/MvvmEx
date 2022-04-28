package com.example.mvvmkotlin

import com.example.mvvmkotlin.RetrofitManager.Companion.retrofitManager
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {




    companion object {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        private val retrofitManager = RetrofitManager()
        private val loginClient: Retrofit = retrofit;
        val myAPIService get() = loginClient.create(ApiServer::class.java)
//        val myAPIService = retrofit.create(ApiServer::class.java)
    }


}