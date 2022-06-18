package com.example.yangiliklardasturi.data.sourse.remote.api

import com.example.yangiliklardasturi.data.sourse.remote.respons.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")
    suspend fun getNewsByCategory(@Query("category")category: String) : Response<NewsResponse.MainResponse>

}