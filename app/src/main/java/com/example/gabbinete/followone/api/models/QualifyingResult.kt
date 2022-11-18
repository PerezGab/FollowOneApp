package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class QualifyingResult(
    val number: String,
    val position: String,
    @SerializedName("Driver") val networkDriver: NetworkDriver,
    @SerializedName("Constructor") val constructor: NetworkConstructor,
    @SerializedName("Q1") val q1: String,
    @SerializedName("Q2") val q2: String,
    @SerializedName("Q3") val q3: String
) : Parcelable