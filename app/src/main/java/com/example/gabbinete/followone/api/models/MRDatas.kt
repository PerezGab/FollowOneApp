package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MRDataDrivers(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @Json(name = "DriverTable") val driverTable: DriverTable
) : Parcelable

@Parcelize
data class MRDataManufacturers(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @Json(name = "ConstructorTable") val constructorTable: ConstructorTable
) : Parcelable

@Parcelize
data class MRDataRaces(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @Json(name = "RaceTable") val raceTable: RaceTable
) : Parcelable

@Parcelize
data class MRDataDriverStandings(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @Json(name = "StandingsTable") val standingsTable: DriverStandingsTable
) : Parcelable

@Parcelize
data class MRDataConstructorStandings(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @Json(name = "StandingsTable") val standingsTable: ConstructorStandingsTable
) : Parcelable