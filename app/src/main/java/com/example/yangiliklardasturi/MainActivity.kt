package com.example.yangiliklardasturi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yangiliklardasturi.presentation.ui.screen.MainScreen
import com.example.yangiliklardasturi.presentation.ui.screen.SplashScreen
import com.example.yangiliklardasturi.presentation.viewModel.impl.SplashViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}