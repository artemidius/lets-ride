package com.s808.civilian.profile.ui.state

sealed class CivilianProfileViewState {
    object Loading : CivilianProfileViewState()
    object Error : CivilianProfileViewState()
    class Success(val data: CivilianProfileUiData) : CivilianProfileViewState()
}
