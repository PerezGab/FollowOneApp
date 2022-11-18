package com.example.gabbinete.followone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gabbinete.followone.entities.GrandPrix
import com.example.gabbinete.followone.repo.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val CURRENT_SEASON = "current"

class HomeFragmentViewModel(private val repo: Repository) : ViewModel() {

    private val _lastGP = MutableStateFlow<GrandPrix?>(null)
    val lastGP = _lastGP.asStateFlow()

    private val _nextGP = MutableStateFlow<GrandPrix?>(null)
    val nextGP = _nextGP.asStateFlow()

    init {
        setNextRace()
        setLastRace()
    }

    private fun setLastRace() {
        viewModelScope.launch {
//            _lastGP.value = (repo.getCurrentSeasonDriverStandings()[0].standings[0] as DriverStandings).driver.toDomainDriver()
            _lastGP.value = repo.getLastRace()
        }
    }

    private fun setNextRace() {
        viewModelScope.launch {
            val nextGpItem = repo.getLastRace().round.toInt()+1
            _nextGP.value = repo.getRace(CURRENT_SEASON, nextGpItem.toString())
        }
    }
}

@Suppress("UNCHECKED_CAST")
class HomeFragmentViewModelFactory(private val repo: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            return HomeFragmentViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}