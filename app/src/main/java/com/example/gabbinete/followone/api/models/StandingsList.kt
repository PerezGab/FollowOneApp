package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class DriverStandingList(
    val season: String,
    val round: String,
    @Json(name = "DriverStandings") val driverStandings: List<NetworkDriverStanding>
) : Parcelable

@Parcelize
data class ConstructorStandingList(
    val season: String,
    val round: String,
    @Json(name = "ConstructorStandings") val constructorStandings: List<NetworkConstructorStanding>
) : Parcelable