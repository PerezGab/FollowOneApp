package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkLocation(
    val lat: String,
    @SerializedName("long") val _long: String,
    val locality: String,
    val country: String
) : Parcelable
