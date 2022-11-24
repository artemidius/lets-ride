package com.s808.start.ui.civilian

@Suppress("UNUSED_PARAMETER")
sealed class CivilianScreenViewState {
    object Loading : CivilianScreenViewState()
    class Error(message: String? = null, description: String? = null) : CivilianScreenViewState()
    class Success(val data: CivilianScreenData) : CivilianScreenViewState()
}
