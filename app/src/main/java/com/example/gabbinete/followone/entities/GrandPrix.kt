package com.example.gabbinete.followone.entities

import com.example.gabbinete.followone.api.models.QualifyingResult
import com.example.gabbinete.followone.api.models.RaceResult
import com.example.gabbinete.followone.api.models.Session

data class GrandPrix(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    val circuit: Circuit,
    val date: String,
    val time: String,
    val raceResults: List<RaceResult>?,
    val qualifyingResults: List<QualifyingResult>?,
    val firstPractice: Session?,
    val secondPractice: Session?,
    val thirdPractice: Session?,
    val qualifying: Session?,
    val sprint: Session?
)