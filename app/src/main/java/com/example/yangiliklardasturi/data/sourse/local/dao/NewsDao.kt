package com.example.yangiliklardasturi.data.sourse.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yangiliklardasturi.data.sourse.local.entity.NewsEntity

@Dao
interface NewsDao {


    @Query("Select * from NewsEntity Where NewsEntity.category = :category")
    suspend fun getNewsByCategory(category: String): List<NewsEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNews(list: List<NewsEntity>)


    @Query("DELETE from NewsEntity Where category = :category")
    suspend fun delete(category: String)
}