package com.s808.civilian.rides.state

import com.s808.model.rider.RiderDTO

data class RiderItem (
    val id: String,
    val name: String,
    val description: String?,
    val bike: String,
    val iconUrl: String,
    val rating: Int,
    val speed: Int,
    val age: Int,
    val distance: Double,
    val gender: String
)

fun RiderDTO.toRiderItem(): RiderItem =
    RiderItem(
        id = this.id,
        name = this.name,
        description = this.description,
        bike = this.bike,
        iconUrl = this.icon?.large?:"", //TODO: Implement size based on device profile
        rating = this.rating,
        speed = this.speed,
        age = this.age,
        distance = this.distance,
        gender = this.gender
    )

