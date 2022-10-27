@file:Suppress("unused")

package com.s808.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.s808.data.database.dao.CivilianDao
import com.s808.data.database.enteties.CivilianEntity

@Database(entities = [CivilianEntity::class], version = 1, exportSchema = false)
abstract class LetsRideDatabase: RoomDatabase() {
    abstract fun civilianDao(): CivilianDao
}
