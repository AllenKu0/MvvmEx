package com.example.mvvmkotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

class InfoRespority {
    fun loadInfo(task: OnTaskFinish) {
        Log.e("dsadasd", "loadInfo: aaaaaaa" )

        RetrofitManager.myAPIService.getPost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Post>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<Post>) {
                    Log.e("loadInfo", "onNext: $t" )
                    task.onFinish(t)
                }

                override fun onError(e: Throwable) {
                    Log.e("loadInfo", "onError: $e" )
                }

                override fun onComplete() {
                    Log.e("loadInfo", "onComplete:" )
                }
            })

    }



    fun loadInfoLive() :LiveData<List<Post>>{
        Log.e("dsadasd", "loadInfo: aaaaaaa" )
        val liveData=MutableLiveData<List<Post>>()
        RetrofitManager.myAPIService.getPost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Post>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<Post>) {
                    Log.e("loadInfo", "onNext: $t" )
                    liveData.postValue(t)
                }

                override fun onError(e: Throwable) {
                    Log.e("loadInfo", "onError: $e" )
                }

                override fun onComplete() {
                    Log.e("loadInfo", "onComplete:" )
                }
            })
        return liveData

    }

    interface OnTaskFinish{
        fun onFinish(data: List<Post>)
    }
}