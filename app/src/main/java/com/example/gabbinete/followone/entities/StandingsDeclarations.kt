package com.example.gabbinete.followone.entities

import com.example.gabbinete.followone.api.models.NetworkConstructor
import com.example.gabbinete.followone.api.models.NetworkDriver

abstract class Standings(
    open val position: String,
    open val positionText: String,
    open val points: String,
    open val wins: String,
)

class DriverStandings(
    position: String,
    positionText: String,
    points: String,
    wins: String,
    val driver: NetworkDriver,
    val constructors: List<NetworkConstructor>
) :
    Standings(
        position, positionText,
        points,
        wins
    ) {
    override val position: String
        get() = super.position
    override val positionText: String
        get() = super.positionText
    override val points: String
        get() = super.points
    override val wins: String
        get() = super.wins
}

class ConstructorStandings(
    position: String,
    positionText: String,
    points: String,
    wins: String,
    val constructor: NetworkConstructor
) : Standings(
    position, positionText,
    points, wins
) {
    override val position: String
        get() = super.position
    override val positionText: String
        get() = super.positionText
    override val points: String
        get() = super.points
    override val wins: String
        get() = super.wins
}