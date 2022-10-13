package com.example.gabbinete.followone.api

import com.example.gabbinete.followone.entities.Driver
import com.example.gabbinete.followone.entities.SeasonStandings
import com.example.gabbinete.followone.repo.RemoteDataSource
import com.example.gabbinete.followone.repo.toDomainConstructorStandingList
import com.example.gabbinete.followone.repo.toDomainDriver
import com.example.gabbinete.followone.repo.toDomainDriverStandingList

class ApiDataSource() : RemoteDataSource {

    override suspend fun getCurrentDrivers(): List<Driver> =
        ApiCall.retrofitService.getCurrentDrivers().mRData.driverTable.networkDrivers.toDomainDriver()

    override suspend fun getCurrentSeasonDriverStandings(): List<SeasonStandings> =
        ApiCall.retrofitService.getCurrentSeasonDriverStandings().mRDataDriver.standingsTable.standingsLists.toDomainDriverStandingList()

    override suspend fun getCurrentSeasonConstructorStandings(): List<SeasonStandings> =
        ApiCall.retrofitService.getCurrentSeasonConstructorStandings().mRDataDriver.standingsTable.standingsLists.toDomainConstructorStandingList()
}
