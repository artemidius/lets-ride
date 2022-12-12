@file:Suppress("unused")

package com.s808.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.s808.data.database.dao.CivilianDao
import com.s808.data.database.enteties.CivilianEntity
import com.s808.data.database.type.converters.StringsListConverter

@Database(
    entities = [CivilianEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringsListConverter::class)
abstract class LetsRideDatabase: RoomDatabase() {
    abstract fun civilianDao(): CivilianDao
}
