package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class DriverTable(
    val season: String,
    @Json(name = "Drivers") val networkDrivers: List<NetworkDriver>
) :
    Parcelable

@Parcelize
data class ConstructorTable(
    val season: String,
    @Json(name = "Constructors") val constructors: List<Constructor>
) : Parcelable

@Parcelize
data class RaceTable(
    val season: String,
    @Json(name = "Races") val races: List<Race>
) : Parcelable

@Parcelize
data class DriverStandingsTable(
    val season: String,
    @Json(name = "StandingsLists") val standingsLists: List<DriverStandingList>
) : Parcelable

@Parcelize
data class ConstructorStandingsTable(
    val season: String,
    @Json(name = "StandingsLists") val standingsLists: List<ConstructorStandingList>
) : Parcelable