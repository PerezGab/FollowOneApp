package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MRDataDrivers(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("DriverTable") val driverTable: DriverTable
) : Parcelable

@Parcelize
data class MRDataManufacturers(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("ConstructorTable") val constructorTable: ConstructorTable
) : Parcelable

@Parcelize
data class MRDataRaces(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("RaceTable") val raceTable: RaceTable
) : Parcelable

@Parcelize
data class MRDataDriverStandings(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("StandingsTable") val standingsTable: DriverStandingsTable
) : Parcelable

@Parcelize
data class MRDataConstructorStandings(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("StandingsTable") val standingsTable: ConstructorStandingsTable
) : Parcelable