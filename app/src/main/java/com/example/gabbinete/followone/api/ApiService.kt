package com.example.gabbinete.followone.api

import com.example.gabbinete.followone.api.models.DriverResponse
import com.example.gabbinete.followone.api.models.DriverStandingsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("current/drivers")
    suspend fun getCurrentDrivers(): DriverResponse

    @GET("current/driverStandings")
    suspend fun getCurrentSeasonDriverStandings(): DriverStandingsResponse
}