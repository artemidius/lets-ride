package com.s808.repo.riders

import com.s808.common.result.OperationResult
import com.s808.model.rider.RiderDTO
import com.s808.network.api.civilian.RiderRequestParams

interface RidersRepository {
    suspend fun getRidersList(config: RiderRequestParams):OperationResult<List<RiderDTO>>
}
