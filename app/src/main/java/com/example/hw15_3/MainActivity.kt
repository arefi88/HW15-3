package com.example.hw15_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw15_3.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
const val TAG="MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var imageAdapter: ImageAdapter
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageAdapter= ImageAdapter(this)
//        viewModel.imagesLiveData.observe(this){images->
//            imageAdapter.differ.submitList(images)
//        }
        binding.rvMain.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=imageAdapter
        }
        viewModel.getImages()
        viewModel.images.observe(this){
            imageAdapter.differ.submitList(it)
        }

    }
}