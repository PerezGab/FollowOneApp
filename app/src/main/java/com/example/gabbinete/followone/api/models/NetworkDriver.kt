package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkDriver (
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val dateOfBirth: String,
    val nationality: String
) : Parcelable


