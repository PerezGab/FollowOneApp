package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkDriverStanding(
    val position: String,
    val positionText: String,
    val points: String,
    val wins: String,
    @Json(name = "Driver") val networkDriver: NetworkDriver,
    @Json(name = "Constructors") val constructors: List<NetworkConstructor>
) : Parcelable
