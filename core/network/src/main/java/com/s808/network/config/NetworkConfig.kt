package com.s808.network.config

import java.util.*

data class NetworkConfig(
    val baseUrl: String,
    val tokens: EnumMap<TokenType, String> = EnumMap(TokenType::class.java),
)
