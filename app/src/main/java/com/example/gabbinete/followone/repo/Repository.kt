package com.example.gabbinete.followone.repo

import com.example.gabbinete.followone.entities.Driver
import com.example.gabbinete.followone.entities.GrandPrix
import com.example.gabbinete.followone.entities.SeasonStandings

class Repository(private val remoteDataSource: RemoteDataSource) {
//    private val repositoryScope = CoroutineScope(Dispatchers.IO)

    suspend fun getCurrentDrivers(): List<Driver> = remoteDataSource.getCurrentDrivers()
    suspend fun getCurrentSeasonDriverStandings(): List<SeasonStandings> = remoteDataSource.getCurrentSeasonDriverStandings()
    suspend fun getCurrentSeasonConstructorStandings(): List<SeasonStandings> = remoteDataSource.getCurrentSeasonConstructorStandings()
    suspend fun getCurrentSeasonRaces(): List<GrandPrix> = remoteDataSource.getCurrentSeasonRaces()
    suspend fun getLastRace(): GrandPrix = remoteDataSource.getLastRace()
    suspend fun getRace(season: String, round: String): GrandPrix = remoteDataSource.getRace(season, round)
}

interface RemoteDataSource {
    suspend fun getCurrentDrivers(): List<Driver>
    suspend fun getCurrentSeasonDriverStandings(): List<SeasonStandings>
    suspend fun getCurrentSeasonConstructorStandings(): List<SeasonStandings>
    suspend fun getCurrentSeasonRaces(): List<GrandPrix>
    suspend fun getLastRace(): GrandPrix
    suspend fun getRace(season: String, round: String): GrandPrix
}