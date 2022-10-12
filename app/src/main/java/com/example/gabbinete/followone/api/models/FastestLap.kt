package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class FastestLap(
    val rank: String,
    val lap: String,
    @Json(name = "Time") val time: Time_,
    @Json(name = "AverageSpeed") val averageSpeed: AverageSpeed
) : Parcelable
