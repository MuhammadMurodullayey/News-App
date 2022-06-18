package com.example.yangiliklardasturi.di

import android.content.Context
import com.example.yangiliklardasturi.BuildConfig.BASE_URL
import com.example.yangiliklardasturi.data.sourse.remote.api.NewsApi
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @[Singleton Provides]
    fun getOkhttpClient(@ApplicationContext context: Context) : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(context))
        .build()

    @[Singleton Provides]
    fun getRetrofit(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @[Singleton Provides]
    fun getNewsApi (retrofit: Retrofit) : NewsApi = retrofit.create(NewsApi::class.java)
}