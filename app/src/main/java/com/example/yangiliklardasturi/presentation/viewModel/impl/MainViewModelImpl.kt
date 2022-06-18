package com.example.yangiliklardasturi.presentation.viewModel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yangiliklardasturi.data.modul.NewsData
import com.example.yangiliklardasturi.domein.repasitory.NewsRepasitory
import com.example.yangiliklardasturi.presentation.viewModel.MainViewModel
import com.example.yangiliklardasturi.utils.isConnected
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    val repasitory: NewsRepasitory

) : ViewModel(), MainViewModel {

    override val closeDrwLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val openDrwLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val messageLiveData: MutableLiveData<Int> = MutableLiveData()
    override val errorLiveData: MutableLiveData<String> = MutableLiveData()
    override val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()
    override val newsLiveData: MutableLiveData<List<NewsData>> = MutableLiveData()
    override val openNextScreenLiveData: MutableLiveData<NewsData> = MutableLiveData()

    override fun openDraw() {
        openDrwLiveData.value = Unit
    }

    override fun closeDraw() {
        closeDrwLiveData.value = Unit
    }

    override fun loadData(category: String) {
        progressLiveData.value = true
        if (isConnected()) loadNetwork(category)
        else loadLocate(category)
    }

    private fun loadNetwork(category: String) {
        messageLiveData.value = 1
        repasitory.getNewsFromNetwork(category).onEach {
            progressLiveData.value = false
            it.onSuccess { data ->
                newsLiveData.value = data
            }
            it.onFailure { throwable ->
                errorLiveData.value = throwable.message
            }
        }.launchIn(viewModelScope)

    }

    private fun loadLocate(category: String) {
        messageLiveData.value = 2
        repasitory.getNewsFromRoom(category).onEach {
            progressLiveData.value = false
            it.onSuccess { data ->
                newsLiveData.value = data
            }
            it.onFailure { throwable ->
                errorLiveData.value = throwable.message
            }

        }.launchIn(viewModelScope)
    }

    override fun openNextScreen(data: NewsData) {
        openNextScreenLiveData.value = data
    }
}