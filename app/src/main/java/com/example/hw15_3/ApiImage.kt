package com.example.hw15_3

import android.media.Image
import retrofit2.Call
import retrofit2.http.GET

interface ApiImage {

    @GET("v2/list")
    fun getImages():Call<Images>
}