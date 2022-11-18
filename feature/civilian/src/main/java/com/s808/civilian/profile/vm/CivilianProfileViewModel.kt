package com.s808.civilian.profile.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s808.civilian.profile.state.CivilianProfileUiData
import com.s808.civilian.profile.state.CivilianProfileViewState
import com.s808.common.result.OperationResult.*
import com.s808.data.civilian.repo.profile.CivilianProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CivilianProfileViewModel @Inject constructor(
    private val civilianProfileRepository: CivilianProfileRepository
) : ViewModel() {

    private val initValue: CivilianProfileViewState = CivilianProfileViewState.Success(
        CivilianProfileUiData(
            icon = null,
            hasHelmet = false,
            pickMeUp = false
        )
    )

    private val _uiState = MutableStateFlow(value = initValue)
    val uiState: StateFlow<CivilianProfileViewState> = _uiState

    init {
        viewModelScope.launch {
            val profileResult = civilianProfileRepository.getCivilianProfile()
            _uiState.value = when (profileResult) {
                is Success -> {
                    val profile = profileResult.data
                    CivilianProfileViewState.Success(
                        CivilianProfileUiData(
                            profile.icon,
                            profile.hasHelmet,
                            profile.pickMeUpWhereIam
                        )
                    )
                }
                is Error -> CivilianProfileViewState.Error
                is Loading -> CivilianProfileViewState.Loading
            }
        }
    }

    fun hasHelmet(status: Boolean) {
        viewModelScope.launch {
            val profile = civilianProfileRepository.getCivilianProfile() as? Success
            profile?.let {
                civilianProfileRepository.persistCivilianProfile(it.data.copy(hasHelmet = status))
                _uiState.value = CivilianProfileViewState.Success(
                    CivilianProfileUiData(
                        icon = it.data.icon,
                        hasHelmet = status,
                        pickMeUp = it.data.pickMeUpWhereIam
                    )
                )
            }
        }
    }

    fun pickMeUp(status: Boolean) {
        viewModelScope.launch {
            val profile = civilianProfileRepository.getCivilianProfile() as? Success
            profile?.let {
                civilianProfileRepository.persistCivilianProfile(it.data.copy(pickMeUpWhereIam = status))
                _uiState.value = CivilianProfileViewState.Success(
                    CivilianProfileUiData(
                        icon = it.data.icon,
                        hasHelmet = it.data.hasHelmet,
                        pickMeUp = status
                    )
                )
            }
        }
    }
}

