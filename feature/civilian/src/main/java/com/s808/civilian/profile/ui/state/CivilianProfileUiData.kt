package com.s808.civilian.profile.ui.state

import android.net.Uri

data class CivilianProfileUiData (
    val icon: Uri?,
    var hasHelmet: Boolean,
    var pickMeUp: Boolean
)