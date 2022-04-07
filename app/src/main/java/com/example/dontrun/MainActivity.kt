package com.example.dontrun

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dontrun.Repository.MainRepository
import com.example.dontrun.adapter.MainAdapter
import com.example.dontrun.api.RetrofitService
import com.example.dontrun.viewmodel.MainViewModel
import com.example.dontrun.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter()
    private lateinit var rv:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this,MainViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        rv=findViewById(R.id.recycler_view)
        rv.adapter=adapter
        rv.layoutManager=LinearLayoutManager(this)

        viewModel.userList.observe(this) {
            Log.d(TAG, "userList:$it")
            adapter.setUserList(it)
        }
        viewModel.errorMessage.observe(this) {
            Log.d(TAG, "ErrorMessage:$it")
        }
        viewModel.getAllUsers()
    }
}