package com.s808.data.civilian.repo.start

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StartScreenRepositoryImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    StartScreenRepository {

    private val tabIndex = intPreferencesKey("tab_index")

    override suspend fun getCurrentTab(): Int =
        dataStore.data.map { prefs ->
            prefs[tabIndex] ?: 0
        }.first()

    override suspend fun setCurrentTab(tab: Int) {
        dataStore.edit { settings ->
            settings[tabIndex] = tab
        }
    }
}