package com.example.yangiliklardasturi.di

import com.example.yangiliklardasturi.domein.repasitory.NewsRepasitory
import com.example.yangiliklardasturi.domein.repasitory.repasitoryIml.NewsRepasitoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NewsRepasitoryModul {

    @[Binds Singleton]
    fun getRepasitory(repasitoryImpl: NewsRepasitoryImpl) : NewsRepasitory

}