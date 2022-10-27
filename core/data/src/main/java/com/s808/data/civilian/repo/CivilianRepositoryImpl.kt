package com.s808.data.civilian.repo

import com.s808.common.result.OperationResult
import com.s808.data.civilian.model.CivilianProfile
import com.s808.data.civilian.model.toEntity
import com.s808.data.civilian.model.toProfile
import com.s808.data.database.dao.CivilianDao
import com.s808.data.user.model.Else
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class CivilianRepositoryImpl @Inject constructor(
    private val civilianDao: CivilianDao
) : CivilianRepository {

    private val initialCivilianProfile by lazy {
        CivilianProfile(
            id = UUID.randomUUID().toString(),
            icon = null,
            hasHelmet = false,
            pickMeUpWhereIam = false,
            gender = Else()
        )
    }

    override suspend fun getCivilianProfile(): OperationResult<CivilianProfile> = withContext(Dispatchers.IO) {
        try {
            val civiliansList = civilianDao.getAll()
            if (civiliansList.isEmpty()) {
                civilianDao.insert(initialCivilianProfile.toEntity())
                return@withContext OperationResult.Success(initialCivilianProfile)
            }
            OperationResult.Success(civiliansList.first().toProfile())
        } catch (e: Throwable) {
            return@withContext OperationResult.Error(e)
        }
    }

    override suspend fun persistCivilianProfile(civilianProfile: CivilianProfile) = withContext(Dispatchers.IO) {
        civilianDao.deleteAll()
        civilianDao.insert(civilianProfile.toEntity())
    }
}
