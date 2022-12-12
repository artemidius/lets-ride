package com.s808.network.api.civilian

import com.s808.model.ApiResponse
import com.s808.model.rider.RiderDTO

interface CivilianApi {
    suspend fun getRiders(params: RiderRequestParams): ApiResponse<List<RiderDTO>?>
}
