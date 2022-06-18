package com.example.yangiliklardasturi.presentation.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yangiliklardasturi.presentation.viewModel.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(

): ViewModel(), SplashViewModel {
    override val openNextScrenLiveData: MutableLiveData<Unit> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO) {
           delay(1000)
           openNextScrenLiveData.postValue(Unit)
        }
    }


}