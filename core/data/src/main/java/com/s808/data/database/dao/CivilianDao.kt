package com.s808.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.s808.data.database.enteties.CivilianEntity

/**
 * Okay. Using a whole database to persist a single object is a massive overkill. I know.
 * Besides, it leads for some ugly solutions with current Dao. This part is more proof-of-concept.
 * And the Dao is implemented for mostly learn and practice purposes
 */
@Dao
interface CivilianDao {

    @Query("SELECT * FROM civilianentity")
    fun getAll(): List<CivilianEntity>

    @Insert
    fun insert(civilianEntity: CivilianEntity)

    @Query("DELETE FROM civilianentity")
    fun deleteAll()
}
