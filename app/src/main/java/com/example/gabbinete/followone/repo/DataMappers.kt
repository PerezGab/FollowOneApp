package com.example.gabbinete.followone.repo

import com.example.gabbinete.followone.api.models.*
import com.example.gabbinete.followone.entities.*

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

fun NetworkDriver.toDomainDriver(): Driver {
    return Driver(
        driverId = driverId,
        permanentNumber = permanentNumber,
        code = code,
        url = url,
        givenName = givenName,
        familyName = familyName,
        dateOfBirth = dateOfBirth,
        nationality = nationality
    )
}

fun List<NetworkConstructor>.toDomainConstructor(): List<Constructor> {
    return map {
        Constructor(
            constructorId = it.constructorId,
            url = it.url,
            name = it.name,
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

fun List<NetworkConstructorStanding>.toDomainConstructorStandings(): List<ConstructorStandings> {
    return map {
        ConstructorStandings(
            position = it.position,
            positionText = it.positionText,
            points = it.points,
            wins = it.wins,
            constructor = it.constructor
        )
    }
}

fun List<DriverStandingList>.toDomainDriverStandingList(): List<SeasonStandings> {
    return map {
        SeasonStandings(
            season = it.season,
            round = it.round,
            standings = it.driverStandings.toDomainDriverStandings()
        )
    }
}

fun List<ConstructorStandingList>.toDomainConstructorStandingList(): List<SeasonStandings> {
    return map {
        SeasonStandings(
            season = it.season,
            round = it.round,
            standings = it.constructorStandings.toDomainConstructorStandings()
        )
    }
}