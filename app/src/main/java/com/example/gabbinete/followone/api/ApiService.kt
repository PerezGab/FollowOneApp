package com.example.gabbinete.followone.api

import com.example.gabbinete.followone.api.models.ConstructorStandingsResponse
import com.example.gabbinete.followone.api.models.DriverResponse
import com.example.gabbinete.followone.api.models.DriverStandingsResponse
import com.example.gabbinete.followone.api.models.RaceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("current/drivers")
    suspend fun getCurrentDrivers(): DriverResponse

    @GET("current/driverStandings")
    suspend fun getCurrentSeasonDriverStandings(): DriverStandingsResponse

    @GET("current/constructorStandings")
    suspend fun getCurrentSeasonConstructorStandings(): ConstructorStandingsResponse

    @GET("current")
    suspend fun getCurrentSeasonRaces(): RaceResponse

    @GET("current/last/results")
    suspend fun getLastRace(): RaceResponse

    @GET("{season}/{round}")
    suspend fun getRace(@Path("season") season: String, @Path("round") round: String): RaceResponse
}