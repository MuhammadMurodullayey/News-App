package com.example.yangiliklardasturi.data.sourse.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.yangiliklardasturi.data.modul.NewsData
@Entity
data class NewsEntity(
    val image: String,
    val read_more: String?,
    val author: String,
    val description: String,
    val inshorts_link: String,
    @PrimaryKey
    val title: String,
    val timestamp: String,
    val category : String
)

fun NewsEntity.toNewsData() : NewsData = NewsData(
    this.image,
    this.read_more,
    this.author,
    this.description,
    this.title
)