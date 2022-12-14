package com.s808.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Icon(
    val thumbnail: String,
    val small: String,
    val medium: String,
    val large: String,
)