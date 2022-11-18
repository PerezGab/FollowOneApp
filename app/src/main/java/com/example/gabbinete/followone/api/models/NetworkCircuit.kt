package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkCircuit(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    @SerializedName("Location") val location: NetworkLocation
) : Parcelable