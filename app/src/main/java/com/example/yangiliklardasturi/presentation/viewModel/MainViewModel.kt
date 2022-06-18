package com.example.yangiliklardasturi.presentation.viewModel

import androidx.lifecycle.LiveData
import com.example.yangiliklardasturi.data.modul.NewsData

interface MainViewModel {
    val openDrwLiveData : LiveData<Unit>
    val closeDrwLiveData : LiveData<Unit>
    val messageLiveData : LiveData<Int>
    val errorLiveData : LiveData<String>
    val progressLiveData : LiveData<Boolean>
    val newsLiveData : LiveData<List<NewsData>>
    val openNextScreenLiveData : LiveData<NewsData>

fun openDraw()
fun closeDraw()
fun loadData(category : String)
fun openNextScreen(data: NewsData)
}