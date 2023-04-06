package com.example.hw15_3.data

import com.example.hw15_3.ApiImage
import com.example.hw15_3.ImageClient
import com.example.hw15_3.ImageItem
import com.example.hw15_3.Images
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class RemoteDataSource : DataSource {
    private val executors=Executors.newSingleThreadExecutor()
    override fun getImages(): Images {
        val callable=object : Callable<Images>{
            override fun call(): Images {
                val images=ImageClient.getClient().getImages().execute()
                //return (images?: emptyList()) as Images
                return (images.body() ?: emptyList()) as Images
            }

        }
       val future:Future<Images> = executors.submit(callable)
       return future.get()

    }
}
