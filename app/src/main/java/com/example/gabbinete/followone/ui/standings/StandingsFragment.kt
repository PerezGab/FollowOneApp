package com.example.gabbinete.followone.ui.standings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gabbinete.followone.api.ApiDataSource
import com.example.gabbinete.followone.databinding.FragmentStandingsBinding
import com.example.gabbinete.followone.repo.Repository
import kotlinx.coroutines.launch


class StandingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentStandingsBinding.inflate(inflater, container, false)

        val repo = Repository(ApiDataSource())
        val vmFactory = StandingsFragmentViewModelFactory(repo)
        val viewModel: StandingsFragmentViewModel by viewModels { vmFactory }
        val adapter = StandingsAdapter()


        lifecycleScope.launch {
            viewModel.driverStandings.collect { standing ->
                standing?.let {
                    val data = it[0]
                    adapter.showRecyclerData(it)
                    binding.roundsText.text = data.round
                    binding.seasonText.text = data.season
                    viewModel.getStandingsCompleted()
                }
            }
        }



        binding.standingsList.adapter = adapter


        return binding.root
    }

}