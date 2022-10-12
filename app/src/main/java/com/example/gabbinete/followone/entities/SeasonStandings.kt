package com.example.gabbinete.followone.entities

data class SeasonStandings(
    val season: String,
    val round: String,
    val driverStandings: List<DriverStandings>?,
    val constructorStandings: List<ConstructorStandings>?
)