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

class MainActivity : AppCompatActivity() {
    //延遲初始化
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var infoRespority: InfoRespority
    private lateinit var infoFactory: InfoFactory
    private lateinit var btn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(com.example.mvvmkotlin.R.id.button)
        infoRespority = InfoRespority()
        infoFactory = InfoFactory(infoRespority)
        infoViewModel = ViewModelProviders.of(this,infoFactory).get(InfoViewModel::class.java)

        btn.setOnClickListener{
            val dialog = ProgressDialog.show(
                this,"",
                "Loading Please wait ..."
            )
            dialog.show()
            infoViewModel.callInfo().observe(this, Observer {
                dialog.dismiss()
                Toast.makeText(this,"user name :${it.userNamed} user age ${it.userAge}",Toast.LENGTH_SHORT).show()
            })
        }
    }
}