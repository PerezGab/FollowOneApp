package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class QualifyingResult(
    val number: String,
    val position: String,
    @Json(name = "Driver") val networkDriver: NetworkDriver,
    @Json(name = "Constructor") val constructor: Constructor,
    @Json(name = "Q1") val q1: String,
    @Json(name = "Q2") val q2: String,
    @Json(name = "Q3") val q3: String
) : Parcelable
