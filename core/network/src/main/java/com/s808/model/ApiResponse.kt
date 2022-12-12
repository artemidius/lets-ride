package com.s808.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T> (
    val status: String,
    val error: String?,
    val data: T
)