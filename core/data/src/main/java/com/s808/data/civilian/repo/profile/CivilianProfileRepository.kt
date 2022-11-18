package com.s808.data.civilian.repo.profile

import com.s808.common.result.OperationResult
import com.s808.data.civilian.model.CivilianProfile

interface CivilianProfileRepository {
    suspend fun getCivilianProfile(): OperationResult<CivilianProfile>
    suspend fun persistCivilianProfile(civilianProfile: CivilianProfile)
}