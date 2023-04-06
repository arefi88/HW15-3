package com.example.hw15_3

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw15_3.data.network.Repository
import com.example.hw15_3.di.ServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repository = ServiceLocator.getRepository()
//    private val _imagesLiveData = MutableLiveData<List<ImageItem>>()
//    val imagesLiveData: LiveData<List<ImageItem>> = _imagesLiveData

    private val _images = MutableLiveData<Images>()
    val images: LiveData<Images> = _images

    fun getImages(){
        _images.value=repository.getImages()
    }

    init {
//        ImageClient.getClient().getImages().enqueue(object : Callback<Images> {
//            override fun onResponse(call: Call<Images>, response: Response<Images>) {
//
//                _imagesLiveData.value=response.body()?.toList()
//            }
//
//            override fun onFailure(call: Call<Images>, t: Throwable) {
//                Log.e(TAG,"onCreate: ${t.message}") }
//        })
    }


}