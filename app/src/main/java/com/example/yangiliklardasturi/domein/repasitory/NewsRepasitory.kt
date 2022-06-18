package com.example.yangiliklardasturi.domein.repasitory

import com.example.yangiliklardasturi.data.modul.NewsData
import com.example.yangiliklardasturi.data.sourse.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsRepasitory {
    fun getNewsFromNetwork(category : String) : Flow<Result<List<NewsData>>>
    fun getNewsFromRoom(category : String) :  Flow<Result<List<NewsData>>>
}