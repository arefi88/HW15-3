package com.example.hw15_3.di

import com.example.hw15_3.data.RemoteDataSource
import com.example.hw15_3.data.network.Repository

object ServiceLocator {
    fun getRepository(): Repository {
        return Repository(RemoteDataSource())
    }
}