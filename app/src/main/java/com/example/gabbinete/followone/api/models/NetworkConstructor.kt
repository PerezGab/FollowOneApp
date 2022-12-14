package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkConstructor(
    val constructorId: String,
    val url: String,
    val name: String,
    val nationality: String
) : Parcelable
