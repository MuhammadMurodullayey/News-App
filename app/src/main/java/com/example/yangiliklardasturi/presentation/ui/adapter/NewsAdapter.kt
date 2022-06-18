package com.example.yangiliklardasturi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yangiliklardasturi.R
import com.example.yangiliklardasturi.data.modul.NewsData
import com.example.yangiliklardasturi.databinding.ItemNewsBinding

class NewsAdapter : ListAdapter<NewsData, NewsAdapter.NewsViewHolder>(MyDiffutil) {
    private var onClickMoreListener: ((NewsData) -> Unit)? = null

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.clickItem.setOnClickListener {
                onClickMoreListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind() {
            getItem(absoluteAdapterPosition).apply {
                Glide.with(binding.imageNews)
                    .load(image)
                    .placeholder(R.drawable.ic_place_holder)
                    .error(R.drawable.ic_error)
                    .into(binding.imageNews)
                binding.authorNews.text = author
                binding.descriptionNews.text = description
                binding.titleNews.text = title
            }

        }

    }

    private object MyDiffutil : DiffUtil.ItemCallback<NewsData>() {
        override fun areItemsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(ItemNewsBinding.bind(view))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnClickMoreListener(block: (NewsData) -> Unit) {
        onClickMoreListener = block
    }

}