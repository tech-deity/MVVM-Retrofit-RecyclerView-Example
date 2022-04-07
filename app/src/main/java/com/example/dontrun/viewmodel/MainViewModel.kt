package com.example.dontrun.viewmodel

import android.net.DnsResolver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dontrun.Repository.MainRepository
import com.example.dontrun.model.User
import com.example.dontrun.model.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository):ViewModel() {

    val userList = MutableLiveData<List<User>>()
    val errorMessage=MutableLiveData<String>()

    fun getAllUsers(){
        val response = repository.getAllUsers()
        response.enqueue(
            object: Callback<UserList> {
                override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                    userList.postValue(response.body()?.users)
                }

                override fun onFailure(call: Call<UserList>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            }
        )
    }
}