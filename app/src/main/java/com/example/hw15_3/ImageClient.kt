package com.example.hw15_3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ImageClient {
    private const val BASE_URL="https://picsum.photos/"
    fun getClient():ApiImage {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiImage::class.java)
    }
}