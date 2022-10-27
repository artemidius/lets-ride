package com.s808.data.database.enteties

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CivilianEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "icon") val icon: String?,
    @ColumnInfo(name = "user_id") val userId: String,
    @ColumnInfo(name = "has_helmet") val hasHelmet: Boolean,
    @ColumnInfo(name = "pick_up") val pickMeUpWhereIam: Boolean,
    @ColumnInfo(name = "gender") val gender: String
)
