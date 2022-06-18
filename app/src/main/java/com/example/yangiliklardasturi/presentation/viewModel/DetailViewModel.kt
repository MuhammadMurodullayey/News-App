package com.example.yangiliklardasturi.presentation.viewModel

import androidx.lifecycle.LiveData

interface DetailViewModel {
 val openNextScreenLiveData : LiveData<Unit>

    fun openNextScreen()
}