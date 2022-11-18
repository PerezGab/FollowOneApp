package com.example.gabbinete.followone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gabbinete.followone.api.ApiDataSource
import com.example.gabbinete.followone.databinding.FragmentHomeBinding
import com.example.gabbinete.followone.repo.Repository

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        val repo = Repository(ApiDataSource())
        val vmFactory = HomeFragmentViewModelFactory(repo)
        val viewModel: HomeFragmentViewModel by viewModels { vmFactory }

        lifecycleScope.launchWhenStarted {
            viewModel.lastGP.collect { binding.lastGpName.text = it?.raceName }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.nextGP.collect {
                it?.let {
                    binding.nextGpName.text = it.raceName
                    binding.nextGpDate.text = it.date
                    binding.nextGpCircuitName.text = it.circuit.circuitName
                    binding.nextRaceRound.text = it.round
                }
            }
        }

//        val localTime = LocalDateTime.now()
//        binding.textView.text = localTime.toString()


        return binding.root
    }
}