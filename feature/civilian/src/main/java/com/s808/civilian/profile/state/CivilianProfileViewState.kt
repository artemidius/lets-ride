package com.s808.civilian.profile.state

sealed class CivilianProfileViewState {
    object Loading : CivilianProfileViewState()
    object Error : CivilianProfileViewState()
    class Success(val data: CivilianProfileUiData) : CivilianProfileViewState()
}
