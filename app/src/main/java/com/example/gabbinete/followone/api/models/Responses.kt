package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class DriverResponse(@Json(name = "MRData") val mRData: MRDataDrivers) : Parcelable

@Parcelize
data class ManufacturerResponse(@Json(name = "MRData") val mrData: MRDataManufacturers) : Parcelable

@Parcelize
data class RaceResponse(@Json(name = "MRData") val mrData: MRDataRaces) : Parcelable

@Parcelize
data class DriverStandingsResponse(@Json(name = "MRData") val mRDataDriver: MRDataDriverStandings) :
    Parcelable

@Parcelize
data class ConstructorStandingsResponse(@Json(name = "MRData") val mRDataDriver: MRDataConstructorStandings) :
    Parcelable

