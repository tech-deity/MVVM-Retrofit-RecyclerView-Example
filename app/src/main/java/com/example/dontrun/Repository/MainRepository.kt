package com.example.dontrun.Repository

import com.example.dontrun.api.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllUsers()=retrofitService.getAllUsers()
}