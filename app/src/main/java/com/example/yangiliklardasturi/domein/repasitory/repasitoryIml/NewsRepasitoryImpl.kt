package com.example.yangiliklardasturi.domein.repasitory.repasitoryIml

import android.util.Log
import com.example.yangiliklardasturi.data.modul.NewsData
import com.example.yangiliklardasturi.data.sourse.local.dao.NewsDao
import com.example.yangiliklardasturi.data.sourse.local.entity.toNewsData
import com.example.yangiliklardasturi.data.sourse.remote.api.NewsApi
import com.example.yangiliklardasturi.data.sourse.remote.respons.toNewsData
import com.example.yangiliklardasturi.data.sourse.remote.respons.toNewsEntity
import com.example.yangiliklardasturi.domein.repasitory.NewsRepasitory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

class NewsRepasitoryImpl @Inject constructor(
    private val api: NewsApi,
    private val database: NewsDao

) : NewsRepasitory {
    override fun getNewsFromNetwork(category: String): Flow<Result<List<NewsData>>> =
        flow<Result<List<NewsData>>> {
            val response = api.getNewsByCategory(category)
            if (response.isSuccessful) response.body()?.let {
                Timber.d(it.articles.toString())
                database.delete(category)
                database.insertAllNews(it.articles.map { data -> data.toNewsEntity(category) })
                emit(Result.success(it.articles.map { data -> data.toNewsData() }))
            } else emit(Result.failure(Exception("Error")))

        }.catch {
            emit(Result.failure(Exception(it)))
        }.flowOn(Dispatchers.IO)


    override fun getNewsFromRoom(category: String): Flow<Result<List<NewsData>>> =
        flow<Result<List<NewsData>>> {
            emit(
                Result.success(
                    database.getNewsByCategory(category).map { data -> data.toNewsData() })
            )
        }.catch {
            emit(Result.failure(Exception(it)))
        }.flowOn(Dispatchers.IO)
}