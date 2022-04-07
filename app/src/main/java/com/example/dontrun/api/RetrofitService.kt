package com.example.dontrun.api

import com.example.dontrun.model.UserList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {
    @GET("fetchuser.php")
    fun getAllUsers(): Call<UserList>

    companion object{
        var retrofitService:RetrofitService?=null

        fun getInstance():RetrofitService{
            if(retrofitService==null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://gwebapi.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}