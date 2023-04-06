package com.example.hw15_3.data.network

import com.example.hw15_3.ImageItem
import com.example.hw15_3.Images
import com.example.hw15_3.data.DataSource
import com.example.hw15_3.data.RemoteDataSource

class Repository(private val remoteDataSource: RemoteDataSource) {
    fun getImages():Images{
        return remoteDataSource.getImages()
    }

}