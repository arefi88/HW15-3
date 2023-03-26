package com.example.hw15_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw15_3.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
const val TAG="MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var imageAdapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageAdapter= ImageAdapter(this)
        ImageClient.getClient().getImages().enqueue(object : Callback<Images>{
            override fun onResponse(call: Call<Images>, response: Response<Images>) {
                imageAdapter.differ.submitList(response.body()?.toList())
            }
a
            override fun onFailure(call: Call<Images>, t: Throwable) {
                Log.e(TAG,"onCreate: ${t.message}")
            }

        })
        binding.rvMain.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=imageAdapter
        }
    }
}