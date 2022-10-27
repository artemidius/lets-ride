package com.s808.civilian

import com.s808.civilian.profile.vm.CivilianProfileViewModel
import com.s808.common.result.OperationResult
import com.s808.data.civilian.model.CivilianProfile
import com.s808.data.civilian.repo.CivilianRepository
import com.s808.data.user.model.Female
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
internal class CivilianProfileViewModelTest {

    private val dispatcher = UnconfinedTestDispatcher()
    private lateinit var civilianProfileViewModel: CivilianProfileViewModel
    private val civilianRepository: CivilianRepository = mock(CivilianRepository::class.java)

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `ViewModel hasHelmet() passes correct state to repository`() = runTest {
        val currentProfile = CivilianProfile(
            id = "id",
            icon = null,
            hasHelmet = false,
            pickMeUpWhereIam = false,
            gender = Female(),
        )
        whenever(civilianRepository.getCivilianProfile()).thenReturn(OperationResult.Success(currentProfile))
        civilianProfileViewModel = CivilianProfileViewModel(civilianRepository)
        civilianProfileViewModel.hasHelmet(true)
        verify(civilianRepository).persistCivilianProfile(currentProfile.copy(hasHelmet = true))
    }

    @Test
    fun `ViewModel pickMeUp() passes correct state to repository`() = runTest {
        val currentProfile = CivilianProfile(
            id = "id",
            icon = null,
            hasHelmet = false,
            pickMeUpWhereIam = false,
            gender = Female(),
        )
        whenever(civilianRepository.getCivilianProfile()).thenReturn(OperationResult.Success(currentProfile))
        civilianProfileViewModel = CivilianProfileViewModel(civilianRepository)
        civilianProfileViewModel.pickMeUp(true)
        verify(civilianRepository).persistCivilianProfile(currentProfile.copy(pickMeUpWhereIam = true))
    }
}
