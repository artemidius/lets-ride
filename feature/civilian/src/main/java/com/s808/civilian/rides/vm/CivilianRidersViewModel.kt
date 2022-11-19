package com.s808.civilian.rides.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s808.civilian.rides.state.CivilianRidersViewState
import com.s808.civilian.rides.state.toRiderItem
import com.s808.common.result.OperationResult
import com.s808.data.civilian.repo.profile.CivilianProfileRepository
import com.s808.data.model.geo.Location
import com.s808.data.model.geo.Measure
import com.s808.data.user.UserGender
import com.s808.network.api.civilian.RiderRequestConfig
import com.s808.repo.riders.RidersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CivilianRidersViewModel @Inject constructor(
    private val profileRepo: CivilianProfileRepository,
    private val ridersRepository: RidersRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<CivilianRidersViewState>(value = CivilianRidersViewState.Loading)
    val uiState: StateFlow<CivilianRidersViewState> = _uiState

    init {
        loadRiders()
    }

    fun loadRiders() {
        _uiState.value = CivilianRidersViewState.Loading
        viewModelScope.launch {
            val profile = (profileRepo.getCivilianProfile() as? OperationResult.Success)?.data

            val result = ridersRepository.getRidersList(
                //TODO: Prepare config in a UseCase outside VM
                RiderRequestConfig(
                    location = Location(1, Measure.KILOMETERS, 0.0, 0.0),//TODO: Get location
                    passingerGender = profile?.gender?:UserGender.Else,
                    riderGender = UserGender.Female,
                    helmetRequired = profile?.hasHelmet?:false,
                    pickMeUp = profile?.pickMeUpWhereIam?:true
                )
            )
            when(result) {
                is OperationResult.Error -> {}
                is OperationResult.Loading -> _uiState.value = CivilianRidersViewState.Loading
                is OperationResult.Success -> {
                    _uiState.value = CivilianRidersViewState.Success(result.data.map { it.toRiderItem() })
                }
            }
        }
    }
}
