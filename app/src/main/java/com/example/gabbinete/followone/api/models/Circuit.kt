package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Circuit(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    @Json(name = "Location") val location: Location
) : Parcelable