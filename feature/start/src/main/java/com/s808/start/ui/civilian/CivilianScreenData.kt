package com.s808.start.ui.civilian

import android.net.Uri
import com.s808.data.civilian.model.CivilianProfile
import com.s808.data.user.UserGender

data class CivilianScreenData(
    val icon: Uri?,
    val hasHelmet: Boolean,
    val pickMeUp: Boolean,
    val preferredRiderGenders: List<UserGender>
)

fun CivilianProfile.getCivilianData(): CivilianScreenData =
    CivilianScreenData(
        icon = this.icon,
        hasHelmet = this.hasHelmet,
        pickMeUp = this.pickMeUpWhereIam,
        preferredRiderGenders =this.preferredRiderGenders
    )