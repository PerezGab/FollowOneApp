package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RaceResult(
    val number: String,
    val position: String,
    val positionText: String,
    val points: String,
    @SerializedName("Driver") val networkDriver: NetworkDriver,
    @SerializedName("Constructor") val constructor: NetworkConstructor,
    val grid: String,
    val laps: String,
    val status: String,
    @SerializedName("Time") val time: Time,
    @SerializedName("FastestLap") val fastestLap: FastestLap
) : Parcelable
