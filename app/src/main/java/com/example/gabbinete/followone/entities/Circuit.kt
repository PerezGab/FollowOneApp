package com.example.gabbinete.followone.entities

data class Circuit(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    val location: Location
)

data class Location(
    val lat: String,
    val _long: String,
    val locality: String,
    val country: String
)