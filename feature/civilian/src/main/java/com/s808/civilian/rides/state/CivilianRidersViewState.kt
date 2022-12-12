package com.s808.civilian.rides.state

sealed class CivilianRidersViewState {
    object Loading : CivilianRidersViewState()
    object Error : CivilianRidersViewState()
    class Success(val data: List<RiderItem>) : CivilianRidersViewState()
}
