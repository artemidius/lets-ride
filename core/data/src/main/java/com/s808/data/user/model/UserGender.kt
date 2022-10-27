@file:Suppress("ParcelCreator")
package com.s808.data.user.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
sealed class UserGender(val text: String): Parcelable

class Male: UserGender("male")
class Female: UserGender("female")
class Else: UserGender("else")

fun String.getUserGender(): UserGender =
    when(this) {
        "male" -> Male()
        "female" -> Female()
        else -> Else()
    }
