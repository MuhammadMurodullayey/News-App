package com.example.yangiliklardasturi.data.sourse.local.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yangiliklardasturi.data.sourse.local.dao.NewsDao

@Database(entities = [NewsEntity::class], version = 1)
abstract class MyDataBase : RoomDatabase() {
    abstract fun getNewsDao() :NewsDao

//    companion object {
//        private var INSTANCE: MyDataBase? = null
//
//        fun getDatabase(context: Context): MyDataBase {
//            val tempInstance = INSTANCE
//
//            if (tempInstance != null) {
//                return tempInstance
//            }
//
//            val instance = Room.databaseBuilder(context, MyDataBase::class.java, "NewsDatabase.db")
//                              .build()
//
//            INSTANCE = instance
//            return instance
//        }
//    }


}