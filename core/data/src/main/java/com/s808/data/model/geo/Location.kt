package com.s808.data.model.geo

import kotlinx.serialization.Serializable

@Serializable
data class Location (
    val density: Int,
    val measure: Measure,
    val latitude: Double,
    val longitude: Double
)