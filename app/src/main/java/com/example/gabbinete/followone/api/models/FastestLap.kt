package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FastestLap(
    val rank: String,
    val lap: String,
    @SerializedName("Time") val time: Time_,
    @SerializedName("AverageSpeed") val averageSpeed: AverageSpeed
) : Parcelable
