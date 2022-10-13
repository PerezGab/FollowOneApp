package com.example.gabbinete.followone.ui.standings

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gabbinete.followone.databinding.StandingListItemBinding
import com.example.gabbinete.followone.entities.ConstructorStandings
import com.example.gabbinete.followone.entities.DriverStandings
import com.example.gabbinete.followone.entities.Standings

private const val TYPE_DRIVER = 1
private const val TYPE_CONSTRUCTOR = 2

class StandingsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<Standings>()

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DRIVER -> DriverStandingsViewHolder.from(parent)
            TYPE_CONSTRUCTOR -> ConstructorStandingsViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (holder) {
            is DriverStandingsViewHolder -> {
                holder.bind(item as DriverStandings)
            }
            is ConstructorStandingsViewHolder -> {
                holder.bind(item as ConstructorStandings)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is DriverStandings -> TYPE_DRIVER
            is ConstructorStandings -> TYPE_CONSTRUCTOR
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    class ConstructorStandingsViewHolder private constructor(private val binding: StandingListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ConstructorStandings) {
            binding.finalPositionText.text = item.positionText
            binding.nameText.text = item.constructor.name
            binding.pointsText.text = item.points
            binding.constructorText.visibility = View.INVISIBLE
        }

        companion object {
            fun from(parent: ViewGroup): ConstructorStandingsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = StandingListItemBinding.inflate(layoutInflater, parent, false)

                return ConstructorStandingsViewHolder(binding)
            }
        }
    }

    class DriverStandingsViewHolder private constructor(private val binding: StandingListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DriverStandings) {
            binding.finalPositionText.text = item.positionText
            binding.nameText.text = item.driver.familyName
            binding.constructorText.text = item.constructors[0].name
            binding.pointsText.text = item.points
        }

        companion object {
            fun from(parent: ViewGroup): DriverStandingsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = StandingListItemBinding.inflate(layoutInflater, parent, false)

                return DriverStandingsViewHolder(binding)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addStandings(standingsList: List<Standings>) {
        list.addAll(standingsList)
        notifyDataSetChanged()
    }
}