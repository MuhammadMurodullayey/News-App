package com.example.yangiliklardasturi.presentation.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yangiliklardasturi.presentation.viewModel.DetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModelImpl @Inject constructor(

) : ViewModel(),DetailViewModel{
    override val openNextScreenLiveData =  MutableLiveData<Unit>()

    override fun openNextScreen() {
        openNextScreenLiveData.value = Unit
    }


}