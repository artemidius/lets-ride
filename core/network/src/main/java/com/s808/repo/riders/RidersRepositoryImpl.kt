package com.s808.repo.riders

import com.s808.common.result.OperationResult
import com.s808.model.rider.RiderDTO
import com.s808.network.api.civilian.CivilianApi
import com.s808.network.api.civilian.RiderRequestConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RidersRepositoryImpl @Inject constructor(private val civilianApi: CivilianApi) :
    RidersRepository {
    override suspend fun getRidersList(config: RiderRequestConfig): OperationResult<List<RiderDTO>> =
        withContext(Dispatchers.IO) {
            try {
                val resp = civilianApi.getRiders(config)
                if (resp.data == null) {
                    val error = resp.error ?: "Error fetching Riders list from server"
                    OperationResult.Error(message = error)
                } else {
                    OperationResult.Success(data = resp.data)
                }
            } catch (e: Throwable) {
                OperationResult.Error(message = e.message)
            }
        }
}
