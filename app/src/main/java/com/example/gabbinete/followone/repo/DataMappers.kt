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

fun Race.toDomainGrandPrix(): GrandPrix {
    return GrandPrix(
        season = season,
        round = round,
        url = url,
        raceName = raceName,
        circuit = circuit.toDomainCircuit(),
        date = date,
        time = time,
        raceResults = raceResults,
        qualifyingResults = qualifyingResults,
        firstPractice = firstPractice,
        secondPractice = secondPractice,
        thirdPractice = thirdPractice,
        qualifying = qualifying,
        sprint = sprint
    )
}

fun List<Race>.toDomainGrandPrixList(): List<GrandPrix> {
    return map {
        GrandPrix(
            season = it.season,
            round = it.round,
            url = it.url,
            raceName = it.raceName,
            circuit = it.circuit.toDomainCircuit(),
            date = it.date,
            time = it.time,
            raceResults = it.raceResults,
            qualifyingResults = it.qualifyingResults,
            firstPractice = it.firstPractice,
            secondPractice = it.secondPractice,
            thirdPractice = it.thirdPractice,
            qualifying = it.qualifying,
            sprint = it.sprint
        )
    }
}

fun NetworkCircuit.toDomainCircuit(): Circuit {
    return Circuit(
        circuitId = circuitId,
        url = url,
        circuitName = circuitName,
        location = location.toDomainLocation()
    )
}

fun NetworkLocation.toDomainLocation(): Location {
    return Location(
        lat = lat,
        _long = _long,
        locality = locality,
        country = country
    )
}