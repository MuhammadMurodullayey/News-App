package com.example.yangiliklardasturi.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.yangiliklardasturi.data.sourse.local.dao.NewsDao
import com.example.yangiliklardasturi.data.sourse.local.entity.MyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @[Provides Singleton]
    fun getDatabase(@ApplicationContext context : Context) : MyDataBase
            = Room.databaseBuilder(context, MyDataBase::class.java, "NewsDatabase.db")
        .build()

    @[Provides Singleton]
    fun getNewsDao(database : MyDataBase) : NewsDao = database.getNewsDao()
}

