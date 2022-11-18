package com.s808.data.civilian.model

import com.s808.common.result.OperationResult
import com.s808.data.civilian.repo.profile.CivilianProfileRepositoryImpl
import com.s808.data.database.dao.CivilianDao
import com.s808.data.user.UserGender
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class CivilianProfileRepositoryImplTest {

    private val dispatcher = UnconfinedTestDispatcher()
    private val civilianDao: CivilianDao = mock(CivilianDao::class.java)
    private val repo = CivilianProfileRepositoryImpl(civilianDao)

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getCivilianProfile() return Error type if Dao throws an exception`() = runTest {
        whenever(civilianDao.getAll()).thenThrow(Error())
        assertThat(repo.getCivilianProfile(), instanceOf(OperationResult.Error::class.java))
    }

    @Test
    fun `getCivilianProfile() creates and returns initial profile in case in any exists yet`() =
        runTest {
            whenever(civilianDao.getAll()).thenReturn(emptyList())
            assertThat(repo.getCivilianProfile(), instanceOf(OperationResult.Success::class.java))
        }

    @Test
    fun `persistCivilianProfile() cleans up invalid data before new data is inserted`() = runTest {
        repo.persistCivilianProfile(
            CivilianProfile(
                id = "",
                icon = null,
                hasHelmet = true,
                pickMeUpWhereIam = true,
                gender = UserGender.Female
            )
        )
        verify(civilianDao, times(1)).deleteAll()
    }
}