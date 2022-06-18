package com.example.yangiliklardasturi.presentation.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.yangiliklardasturi.R
import com.example.yangiliklardasturi.databinding.ScreenSplashBinding
import com.example.yangiliklardasturi.presentation.viewModel.SplashViewModel
import com.example.yangiliklardasturi.presentation.viewModel.impl.SplashViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen :Fragment(R.layout.screen_splash) {
    private val viewModel : SplashViewModel by viewModels<SplashViewModelImpl>()
    private val binding by viewBinding(ScreenSplashBinding ::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TTT", "MESSAGE--")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)
        viewModel.openNextScrenLiveData.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(R.id.action_splashScreen_to_mainScreen)
        })
    }
}