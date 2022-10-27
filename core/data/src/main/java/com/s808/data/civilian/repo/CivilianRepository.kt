package com.s808.data.civilian.repo

import com.s808.common.result.OperationResult
import com.s808.data.civilian.model.CivilianProfile

interface CivilianRepository {
    suspend fun getCivilianProfile(): OperationResult<CivilianProfile>
    suspend fun persistCivilianProfile(civilianProfile: CivilianProfile)
}