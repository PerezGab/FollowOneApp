package com.example.gabbinete.followone.entities

import com.example.gabbinete.followone.api.models.Constructor
import com.example.gabbinete.followone.api.models.NetworkDriver


data class DriverStandings(
    val position: String,
    val positionText: String,
    val points: String,
    val wins: String,
    val driver: NetworkDriver,
    val constructors: List<Constructor>
)