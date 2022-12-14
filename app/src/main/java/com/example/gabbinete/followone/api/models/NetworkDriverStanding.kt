package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkDriverStanding(
    val position: String,
    val positionText: String,
    val points: String,
    val wins: String,
    @SerializedName("Driver") val networkDriver: NetworkDriver,
    @SerializedName("Constructors") val constructors: List<NetworkConstructor>
) : Parcelable
