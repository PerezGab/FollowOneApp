package com.example.gabbinete.followone.entities

data class Driver(
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val dateOfBirth: String,
    val nationality: String
) {
//    companion object {
//        fun mapFlag(nationality: String) {
//            when (nationality) {
//                "Dutch" -> R.drawable.nedflag
//            }
//        }
//    }
}