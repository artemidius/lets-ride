package com.s808.start.ui.civilian

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s808.common.result.OperationResult
import com.s808.data.civilian.repo.profile.CivilianProfileRepository
import com.s808.data.user.getUserGender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CivilianScreenViewModel @Inject constructor(
    private val civilianProfileRepository: CivilianProfileRepository
) : ViewModel() {
    private val initValue: CivilianScreenViewState
        get() {
            return runBlocking {
                when (val profileResult = civilianProfileRepository.getCivilianProfile()) {
                    is OperationResult.Success -> {
                        val profile = profileResult.data
                        CivilianScreenViewState.Success(
                            data = profile.getCivilianData()
                        )
                    }
                    is OperationResult.Error -> CivilianScreenViewState.Error()
                    is OperationResult.Loading -> CivilianScreenViewState.Loading
                }
            }
        }

    private val _uiState = MutableStateFlow(value = initValue)
    val uiState: StateFlow<CivilianScreenViewState> = _uiState

    init {
        viewModelScope.launch {
            val profileResult = civilianProfileRepository.getCivilianProfile()
            _uiState.value = when (profileResult) {
                is OperationResult.Success -> {
                    val profile = profileResult.data
                    CivilianScreenViewState.Success(
                        data = profile.getCivilianData()
                    )
                }
                is OperationResult.Error -> CivilianScreenViewState.Error()
                is OperationResult.Loading -> CivilianScreenViewState.Loading
            }
        }
    }

    fun hasHelmet(status: Boolean) {
        viewModelScope.launch {
            val profile = civilianProfileRepository.getCivilianProfile() as? OperationResult.Success
            profile?.let {
                val newData = it.data.copy(hasHelmet = status)
                civilianProfileRepository.persistCivilianProfile(newData)
                _uiState.value = CivilianScreenViewState.Success(
                    data = newData.getCivilianData()
                )
            }
        }
    }

    fun pickMeUp(status: Boolean) {
        viewModelScope.launch {
            val profile = civilianProfileRepository.getCivilianProfile() as? OperationResult.Success
            profile?.let {
                val newData = it.data.copy(pickMeUpWhereIam = status)
                civilianProfileRepository.persistCivilianProfile(newData)
                _uiState.value = CivilianScreenViewState.Success(
                    data = newData.getCivilianData()
                )
            }
        }
    }

    fun preferredGender(genderString: String) {
        viewModelScope.launch {
            val profile = civilianProfileRepository.getCivilianProfile() as? OperationResult.Success
            profile?.let {
                val gender = genderString.getUserGender()
                val currentGenders = it.data.preferredRiderGenders.toMutableList()
                if (gender in currentGenders) {
                    currentGenders.remove(gender)
                } else {
                    currentGenders.add(gender)
                }

                val newData = it.data.copy(preferredRiderGenders = currentGenders)
                civilianProfileRepository.persistCivilianProfile(newData)
                _uiState.value = CivilianScreenViewState.Success(
                    data = newData.getCivilianData()
                )
            }
        }
    }
}
