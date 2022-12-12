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
    override suspend fun getRiders(params: RiderRequestParams): ApiResponse<List<RiderDTO>?> {
        val networkConfig = factory.networkConfig
        val baseUrl = networkConfig.baseUrl
        val token = networkConfig.tokens[TokenType.BACKEND]?:throw IllegalStateException("No token found")
        return client.get("$baseUrl/civilian/riders") {
            headers {
                append(HttpHeaders.Authorization, token)
            }
        }
    }
}
