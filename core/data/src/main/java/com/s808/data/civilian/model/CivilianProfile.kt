package com.s808.data.civilian.model

import android.net.Uri
import android.os.Parcelable
import com.s808.data.database.enteties.CivilianEntity
import com.s808.data.user.model.UserGender
import com.s808.data.user.model.getUserGender
import kotlinx.parcelize.Parcelize

@Parcelize
data class CivilianProfile(
    val id: String,
    val icon: Uri?,
    val hasHelmet: Boolean,
    val pickMeUpWhereIam: Boolean,
    val gender: UserGender
): Parcelable

fun CivilianProfile.toEntity(): CivilianEntity =
    CivilianEntity(
        uid = 0,
        icon = icon.toString(),
        userId = id,
        hasHelmet = hasHelmet,
        pickMeUpWhereIam = pickMeUpWhereIam,
        gender = gender.text
    )

fun CivilianEntity.toProfile(): CivilianProfile =
    CivilianProfile(
        id = userId,
        icon = Uri.parse(icon),
        hasHelmet = hasHelmet,
        pickMeUpWhereIam = pickMeUpWhereIam,
        gender = gender.getUserGender()
    )
