package com.s808.model.rider

import com.s808.data.model.Icon
import com.s808.data.model.geo.Location
import kotlinx.serialization.Serializable

@Serializable
data class RiderDTO(
    val id: String,
    val name: String,
    val description: String?,
    val bike: String,
    val icon: Icon?,
    val rating: Int,
    val speed: Int,
    val age: Int,
    val distance: Double,
    val location: Location?,
    val gender: String
)