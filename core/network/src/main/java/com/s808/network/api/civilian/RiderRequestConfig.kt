package com.s808.network.api.civilian

import com.s808.data.model.geo.Location
import com.s808.data.user.UserGender

data class RiderRequestConfig (
    val location: Location,
    val passingerGender: UserGender,
    val riderGender: UserGender,
    val helmetRequired: Boolean,
    val pickMeUp: Boolean
)