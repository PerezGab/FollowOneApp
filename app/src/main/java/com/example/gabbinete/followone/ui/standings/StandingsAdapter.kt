package com.example.gabbinete.followone.ui.standings

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gabbinete.followone.databinding.StandingListItemBinding
import com.example.gabbinete.followone.entities.ConstructorStandings
import com.example.gabbinete.followone.entities.DriverStandings
import com.example.gabbinete.followone.entities.SeasonStandings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TYPE_DRIVER = 1
private const val TYPE_CONSTRUCTOR = 2

class StandingsAdapter() : ListAdapter<DataItem, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DRIVER -> DriverStandingsViewHolder.from(parent)
            TYPE_CONSTRUCTOR -> ConstructorStandingsViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DriverStandingsViewHolder -> {
                val item = getItem(position) as DataItem.DriverStandingsItem
                holder.bind(item.driverStandings)
            }
            is ConstructorStandingsViewHolder -> {
                val item = getItem(position) as DataItem.ConstructorStandingsItem
                holder.bind(item.constructorStandings)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.DriverStandingsItem -> TYPE_DRIVER
            is DataItem.ConstructorStandingsItem -> TYPE_CONSTRUCTOR
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    fun showRecyclerData(standing: List<SeasonStandings>) {
        adapterScope.launch(Dispatchers.Default) {
            val data = standing[0].driverStandings?.map { DataItem.DriverStandingsItem(it) }
            withContext(Dispatchers.Main) {
                submitList(data)
            }
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
}

class ItemDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

sealed class DataItem {
    abstract val id: String

    data class DriverStandingsItem(val driverStandings: DriverStandings) : DataItem() {
        override val id: String
            get() = driverStandings.driver.driverId
    }

    data class ConstructorStandingsItem(val constructorStandings: ConstructorStandings) :
        DataItem() {
        override val id: String
            get() = constructorStandings.constructor.constructorId
    }
}
