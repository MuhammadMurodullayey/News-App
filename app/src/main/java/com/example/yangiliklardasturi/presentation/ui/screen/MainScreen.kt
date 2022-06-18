package com.example.yangiliklardasturi.presentation.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.yangiliklardasturi.R
import com.example.yangiliklardasturi.data.modul.NewsData
import com.example.yangiliklardasturi.databinding.ScreenMainNavBinding
import com.example.yangiliklardasturi.presentation.ui.adapter.NewsAdapter
import com.example.yangiliklardasturi.presentation.viewModel.MainViewModel
import com.example.yangiliklardasturi.presentation.viewModel.impl.MainViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main_nav) {
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val binding by viewBinding(ScreenMainNavBinding::bind)
    private val adapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setOnClickMoreListener { data ->
            findNavController().navigate(
                MainScreenDirections.actionMainScreenToDetailScreen(
                    data.title,
                    data.read_more
                )
            )
        }
        inner.recycler.adapter = adapter
        inner.recycler.layoutManager = LinearLayoutManager(requireContext())
        viewModel.loadData("all")
        inner.categoryTitle.text = "All news"
        inner.buttonHome.setOnClickListener {
            viewModel.openDraw()
        }

        all.setOnClickListener {
            viewModel.loadData("all")
            inner.categoryTitle.text = "All news"
            viewModel.closeDraw()
        }
        national.setOnClickListener {
            viewModel.loadData("national")
            inner.categoryTitle.text = "About national news"
            viewModel.closeDraw()
        }
        business.setOnClickListener {
            viewModel.loadData("business")
            inner.categoryTitle.text = "About business news"
            viewModel.closeDraw()
        }
        sports.setOnClickListener {
            viewModel.loadData("sports")
            inner.categoryTitle.text = "About sports news"
            viewModel.closeDraw()
        }
        world.setOnClickListener {
            viewModel.loadData("world")
            inner.categoryTitle.text = "About world news"
            viewModel.closeDraw()
        }
        politics.setOnClickListener {
            viewModel.loadData("politics")
            inner.categoryTitle.text = "About politics news"
            viewModel.closeDraw()
        }
        technology.setOnClickListener {
            viewModel.loadData("technology")
            inner.categoryTitle.text = "About technology news"
            viewModel.closeDraw()
        }
        startup.setOnClickListener {
            viewModel.loadData("startup")
            inner.categoryTitle.text = "About starts news"
            viewModel.closeDraw()
        }
        entertainment.setOnClickListener {
            viewModel.loadData("entertainment")
            inner.categoryTitle.text = "About entertainment news"
            viewModel.closeDraw()
        }
        science.setOnClickListener {
            viewModel.loadData("science")
            inner.categoryTitle.text = "About science news"
            viewModel.closeDraw()
        }
        automobile.setOnClickListener {
            viewModel.loadData("automobile")
            inner.categoryTitle.text = "About automobile news"
            viewModel.closeDraw()
        }
        viewModel.closeDrwLiveData.observe(viewLifecycleOwner, closeDrawObserver)
        viewModel.openDrwLiveData.observe(viewLifecycleOwner, openDrawObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.messageLiveData.observe(viewLifecycleOwner, messageObserver)
        viewModel.newsLiveData.observe(viewLifecycleOwner, newsObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner,progressLiveDataObserver)
//        viewModel.openNextScreenLiveData.observe(viewLifecycleOwner,openNextScreenObserver)

    }

    private val closeDrawObserver = Observer<Unit> {
        binding.drawer.closeDrawer(GravityCompat.START)
    }
    private val openDrawObserver = Observer<Unit> {
        binding.drawer.openDrawer(GravityCompat.START)
    }
    private val errorObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
    private val messageObserver = Observer<Int> {
        if (it == 1) {
            Toast.makeText(requireContext(), "Online", Toast.LENGTH_LONG)

        } else {
            Toast.makeText(requireContext(), "Offline", Toast.LENGTH_LONG)

        }
    }
    private val newsObserver = Observer<List<NewsData>> {
        adapter.submitList(it)
    }
    private val progressLiveDataObserver = Observer<Boolean>{
    }
    private val openNextScreenObserver = Observer<Unit> {

    }
}