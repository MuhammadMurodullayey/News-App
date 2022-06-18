package com.example.yangiliklardasturi.presentation.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.yangiliklardasturi.R
import com.example.yangiliklardasturi.databinding.ScreenWebViewBinding
import com.example.yangiliklardasturi.presentation.viewModel.DetailViewModel
import com.example.yangiliklardasturi.presentation.viewModel.impl.DetailViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailScreen : Fragment(R.layout.screen_web_view) {
    private val viewModel: DetailViewModel by viewModels<DetailViewModelImpl>()
    private val viewBinding by viewBinding(ScreenWebViewBinding::bind)
    private val args: DetailScreenArgs by navArgs()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(viewBinding) {
        args.url?.let { webView.loadUrl(it) }
        webView.settings.javaScriptEnabled = true
        categoryName.text = args.title.trim()
    }
}