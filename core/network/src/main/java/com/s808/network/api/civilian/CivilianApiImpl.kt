package com.s808.network.api.civilian

import com.s808.model.ApiResponse
import com.s808.model.rider.RiderDTO
import com.s808.network.config.NetworkConfigFactory
import com.s808.network.config.TokenType
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

internal class CivilianApiImpl @Inject constructor(
    private val client: HttpClient,
    private val factory: NetworkConfigFactory
) : CivilianApi {
    override suspend fun getRiders(config: RiderRequestConfig): ApiResponse<List<RiderDTO>?> {
        val config = factory.networkConfig
        val baseUrl = config.baseUrl
        val token = config.tokens[TokenType.BACKEND]?:throw IllegalStateException("No token found")
        return client.get("$baseUrl/civilian/riders") {
            headers {
                append(HttpHeaders.Authorization, token)
            }
        }
    }
}
