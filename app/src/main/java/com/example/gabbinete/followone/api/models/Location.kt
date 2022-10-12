package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val lat: String,
    @Json(name = "long") val _long: String,
    val locality: String,
    val country: String
) : Parcelable
