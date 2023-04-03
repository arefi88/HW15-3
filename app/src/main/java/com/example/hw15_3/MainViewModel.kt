package com.example.hw15_3

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _imagesLiveData = MutableLiveData<List<ImageItem>>()
    val imagesLiveData: LiveData<List<ImageItem>> = _imagesLiveData

    init {
        ImageClient.getClient().getImages().enqueue(object : Callback<Images> {
            override fun onResponse(call: Call<Images>, response: Response<Images>) {

                _imagesLiveData.value=response.body()?.toList()
            }

            override fun onFailure(call: Call<Images>, t: Throwable) {
                Log.e(TAG,"onCreate: ${t.message}") }
        })
    }


}