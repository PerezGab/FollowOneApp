package com.example.gabbinete.followone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gabbinete.followone.entities.DriverStandings
import com.example.gabbinete.followone.repo.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val repo: Repository): ViewModel() {

    private val _driver = MutableStateFlow<DriverStandings?>(null)
    val driver: StateFlow<DriverStandings?> = _driver

    init {
        setLeaderName()
    }

    private fun setLeaderName() {
        viewModelScope.launch {
            val driversList = repo.getCurrentSeasonDriverStandings()[0].driverStandings
            _driver.value = driversList?.get(0)
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