package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DriverResponse(@SerializedName("MRData") val mRData: MRDataDrivers) : Parcelable

@Parcelize
data class ManufacturerResponse(@SerializedName("MRData") val mrData: MRDataManufacturers) : Parcelable

@Parcelize
data class RaceResponse(@SerializedName("MRData") val mrData: MRDataRaces) : Parcelable

@Parcelize
data class DriverStandingsResponse(@SerializedName("MRData") val mRDataDriver: MRDataDriverStandings) :
    Parcelable

@Parcelize
data class ConstructorStandingsResponse(@SerializedName("MRData") val mRDataDriver: MRDataConstructorStandings) :
    Parcelable

