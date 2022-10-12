package com.example.gabbinete.followone.api

import com.example.gabbinete.followone.api.models.DriverStandingList
import com.example.gabbinete.followone.api.models.NetworkDriver
import com.example.gabbinete.followone.api.models.NetworkDriverStanding
import com.example.gabbinete.followone.entities.Driver
import com.example.gabbinete.followone.entities.DriverStandings
import com.example.gabbinete.followone.entities.SeasonStandings

fun List<NetworkDriver>.toDomainDriver(): List<Driver> {
    return map {
        Driver(
            driverId = it.driverId,
            permanentNumber = it.permanentNumber,
            code = it.code,
            url = it.url,
            givenName = it.givenName,
            familyName = it.familyName,
            dateOfBirth = it.dateOfBirth,
            nationality = it.nationality
        )
    }
}

fun List<NetworkDriverStanding>.toDomainDriverStandings(): List<DriverStandings> {
    return map {
        DriverStandings(
            position = it.position,
            positionText = it.positionText,
            points = it.points,
            wins = it.wins,
            driver = it.networkDriver,
            constructors = it.constructors
        )
    }
}

fun List<DriverStandingList>.toDomainDriverStandingList(): List<SeasonStandings> {
    return map {
        SeasonStandings(
            season = it.season,
            round = it.round,
            driverStandings = it.driverStandings.toDomainDriverStandings(),
            constructorStandings = null
        )
    }
}