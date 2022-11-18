package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DriverStandingList(
    val season: String,
    val round: String,
    @SerializedName("DriverStandings") val driverStandings: List<NetworkDriverStanding>
) : Parcelable

@Parcelize
data class ConstructorStandingList(
    val season: String,
    val round: String,
    @SerializedName("ConstructorStandings") val constructorStandings: List<NetworkConstructorStanding>
) : Parcelable