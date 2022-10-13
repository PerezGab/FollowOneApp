package com.example.gabbinete.followone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gabbinete.followone.entities.Driver
import com.example.gabbinete.followone.entities.DriverStandings
import com.example.gabbinete.followone.repo.Repository
import com.example.gabbinete.followone.repo.toDomainDriver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val repo: Repository): ViewModel() {

    private val _driver = MutableStateFlow<Driver?>(null)
    val driver= _driver.asStateFlow()

    init {
        setLeaderName()
    }

    private fun setLeaderName() {
        viewModelScope.launch {
            _driver.value = (repo.getCurrentSeasonDriverStandings()[0].standings[0] as DriverStandings).driver.toDomainDriver()
        }
    }
}

@Suppress("UNCHECKED_CAST")
class HomeFragmentViewModelFactory(private val repo: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            return HomeFragmentViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}