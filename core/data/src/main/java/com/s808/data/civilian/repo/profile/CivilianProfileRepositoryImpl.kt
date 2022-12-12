package com.s808.data.civilian.repo.profile

import com.s808.common.result.OperationResult
import com.s808.data.civilian.model.CivilianProfile
import com.s808.data.civilian.model.toEntity
import com.s808.data.civilian.model.toProfile
import com.s808.data.database.dao.CivilianDao
import com.s808.data.user.UserGender
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class CivilianProfileRepositoryImpl @Inject constructor(
    private val civilianDao: CivilianDao
) : CivilianProfileRepository {

    private val initialCivilianProfile by lazy {
        CivilianProfile(
            id = UUID.randomUUID().toString(),
            icon = null,
            hasHelmet = false,
            pickMeUpWhereIam = false,
            civilianGender = UserGender.Other,
            preferredRiderGenders = listOf(UserGender.Female, UserGender.Male, UserGender.Other)
        )
    }

    override suspend fun getCivilianProfile(): OperationResult<CivilianProfile> =
        withContext(Dispatchers.IO) {
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

    override suspend fun persistCivilianProfile(civilianProfile: CivilianProfile) =
        withContext(Dispatchers.IO) {
            civilianDao.deleteAll()
            civilianDao.insert(civilianProfile.toEntity())
        }
}
