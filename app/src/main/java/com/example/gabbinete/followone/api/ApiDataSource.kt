package com.example.gabbinete.followone.api

import com.example.gabbinete.followone.entities.Driver
import com.example.gabbinete.followone.entities.GrandPrix
import com.example.gabbinete.followone.entities.SeasonStandings
import com.example.gabbinete.followone.repo.*

class ApiDataSource() : RemoteDataSource {

    override suspend fun getCurrentDrivers(): List<Driver> =
        ApiCall.retrofitService.getCurrentDrivers().mRData.driverTable.networkDrivers.toDomainDriver()

    override suspend fun getCurrentSeasonDriverStandings(): List<SeasonStandings> =
        ApiCall.retrofitService.getCurrentSeasonDriverStandings().mRDataDriver.standingsTable.standingsLists.toDomainDriverStandingList()

    override suspend fun getCurrentSeasonConstructorStandings(): List<SeasonStandings> =
        ApiCall.retrofitService.getCurrentSeasonConstructorStandings().mRDataDriver.standingsTable.standingsLists.toDomainConstructorStandingList()

    override suspend fun getCurrentSeasonRaces(): List<GrandPrix> =
            ApiCall.retrofitService.getCurrentSeasonRaces().mrData.raceTable.races.toDomainGrandPrixList()

    override suspend fun getLastRace(): GrandPrix =
        ApiCall.retrofitService.getLastRace().mrData.raceTable.races[0].toDomainGrandPrix()

    override suspend fun getRace(season: String, round: String): GrandPrix =
        ApiCall.retrofitService.getRace(season, round).mrData.raceTable.races[0].toDomainGrandPrix()
}
