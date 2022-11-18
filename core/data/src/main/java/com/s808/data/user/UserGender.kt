@file:Suppress("ParcelCreator")
package com.s808.data.user

import android.os.Parcelable
import com.s808.data.user.UserGender.*
import kotlinx.parcelize.Parcelize
@Parcelize
sealed class UserGender(val text: String): Parcelable {
    object Male: UserGender("male")
    object Female: UserGender("female")
    object Else: UserGender("else")
}



fun String.getUserGender(): UserGender =
    when(this) {
        "male" -> Male
        "female" -> Female
        else -> Else
    }
