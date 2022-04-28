package com.example.mvvmkotlin

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiServer {
    @GET("posts")
    fun getPost(): Observable<List<Post>>
}