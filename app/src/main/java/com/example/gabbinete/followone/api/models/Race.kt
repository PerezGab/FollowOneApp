package com.example.gabbinete.followone.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Race(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    @Json(name = "Circuit") val circuit: Circuit,
    val date: String,
    val time: String,
    @Json(name = "Results") val raceResults: List<RaceResult>,
    @Json(name = "QualifyingResults") val qualifyingResults: List<QualifyingResult>,
    @Json(name = "FirstPractice") val firstPractice: Session,
    @Json(name = "SecondPractice") val secondPractice: Session,
    @Json(name = "ThirdPractice") val thirdPractice: Session,
    @Json(name = "Qualifying") val qualifying: Session,
    @Json(name = "Sprint") val sprint: Session
): Parcelable
