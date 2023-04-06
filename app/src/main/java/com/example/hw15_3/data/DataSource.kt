package com.example.hw15_3.data

import com.example.hw15_3.ImageItem
import com.example.hw15_3.Images

interface DataSource {
    fun getImages():Images
}