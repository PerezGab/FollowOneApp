package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AverageSpeed(val units: String, val speed: String) : Parcelable
