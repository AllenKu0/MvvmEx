package com.example.mvvmkotlin

import java.lang.Thread.sleep
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class InfoRespority{
    fun loadInfo(task: OnTaskFinish) {
        Executors.newSingleThreadExecutor().submit{
            val userData = UserData();
            userData.userNamed = "joke"
            userData.userAge = 30
            sleep(3000)
            task.onFinish(userData)
        }
    }
}

interface OnTaskFinish{
    fun onFinish(data: UserData)
}