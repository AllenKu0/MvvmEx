package com.example.mvvmkotlin

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.reactivex.internal.schedulers.RxThreadFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var infoViewModel: InfoViewModel
    private lateinit var infoRespority: InfoRespority
    //用到才會進(實例)
    private val infoFactory: InfoFactory by lazy {
        InfoFactory(infoRespority)
    }
    private lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(com.example.mvvmkotlin.R.id.button)
        infoRespority = InfoRespority()
        val dialog = ProgressDialog(this)

        infoViewModel = ViewModelProviders.of(this, infoFactory).get(InfoViewModel::class.java)
//        infoViewModel.userInfoLiveData.observe(this, Observer {
//            dialog.dismiss()
//            Toast.makeText(this,"user UserId :${it.get(0).getUserId()} user title ${it.get(0).gettitle()}",Toast.LENGTH_SHORT).show()
//        })
        btn.setOnClickListener {

            dialog.show()

            infoViewModel.callInfo().observe(this, Observer {
                dialog.dismiss()
                Toast.makeText(
                    this,
                    "user UserId :${it.get(0).getUserId()} user title ${it.get(0).gettitle()}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        }
    }
}