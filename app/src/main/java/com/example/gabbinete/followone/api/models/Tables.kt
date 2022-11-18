package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DriverTable(
    val season: String,
    @SerializedName("Drivers") val networkDrivers: List<NetworkDriver>
) :
    Parcelable

@Parcelize
data class ConstructorTable(
    val season: String,
    @SerializedName("Constructors") val constructors: List<NetworkConstructor>
) : Parcelable

@Parcelize
data class RaceTable(
    val season: String,
    val round: String,
    @SerializedName("Races") val races: List<Race>
) : Parcelable

@Parcelize
data class DriverStandingsTable(
    val season: String,
    @SerializedName("StandingsLists") val standingsLists: List<DriverStandingList>
) : Parcelable

@Parcelize
data class ConstructorStandingsTable(
    val season: String,
    @SerializedName("StandingsLists") val standingsLists: List<ConstructorStandingList>
) : Parcelable