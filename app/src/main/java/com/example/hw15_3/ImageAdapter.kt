package com.example.hw15_3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw15_3.databinding.ItemImageBinding

class ImageAdapter(val context:Context) : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){
    private lateinit var binding:ItemImageBinding
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){
        fun setData(item: ImageItem){
           Glide.with(context).apply {
               load(item.download_url)
                   .into(binding.img)
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding=ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }
    private val differCallback= object : DiffUtil.ItemCallback<ImageItem>() {
        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
           return oldItem==newItem
        }


    }
    val differ=AsyncListDiffer(this,differCallback)
}