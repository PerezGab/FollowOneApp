package com.example.gabbinete.followone.repo

import com.example.gabbinete.followone.entities.Driver
import com.example.gabbinete.followone.entities.SeasonStandings

class Repository(private val remoteDataSource: RemoteDataSource) {
//    private val repositoryScope = CoroutineScope(Dispatchers.IO)

    suspend fun getCurrentDrivers(): List<Driver> = remoteDataSource.getCurrentDrivers()
    suspend fun getCurrentSeasonDriverStandings(): List<SeasonStandings> = remoteDataSource.getCurrentSeasonDriverStandings()
    suspend fun getCurrentSeasonConstructorStandings(): List<SeasonStandings> = remoteDataSource.getCurrentSeasonConstructorStandings()

}

interface RemoteDataSource {
    suspend fun getCurrentDrivers(): List<Driver>
    suspend fun getCurrentSeasonDriverStandings(): List<SeasonStandings>
    suspend fun getCurrentSeasonConstructorStandings(): List<SeasonStandings>
}