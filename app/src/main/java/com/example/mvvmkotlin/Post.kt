package com.example.mvvmkotlin

data class Post(private var userId : Int,private var Id : Int,
                private var title : String){

    fun getUserId():Int{
        return userId
    }

    fun getId():Int{
        return userId
    }

    fun gettitle():String{
        return title
    }


}
