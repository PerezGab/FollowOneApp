package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class RaceResult(
    val number: String,
    val position: String,
    val positionText: String,
    val points: String,
    @Json(name = "Driver") val networkDriver: NetworkDriver,
    @Json(name = "Constructor") val constructor: Constructor,
    val grid: String,
    val laps: String,
    val status: String,
    @Json(name = "Time") val time: Time,
    @Json(name = "FastestLap") val fastestLap: FastestLap
) : Parcelable
