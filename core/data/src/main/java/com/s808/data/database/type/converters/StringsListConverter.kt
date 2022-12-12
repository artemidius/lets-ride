package com.s808.data.database.type.converters

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class StringsListConverter {
    @TypeConverter
    fun toList(jsonString: String): List<String> {
        return try {
            Json.decodeFromString(jsonString)
        } catch (e: Throwable) {
            emptyList()
        }
    }

    @TypeConverter
    fun fromList(stringsList: List<String>): String {
        return Json.encodeToString(stringsList)
    }
}