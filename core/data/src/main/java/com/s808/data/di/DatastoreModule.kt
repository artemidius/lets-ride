package com.s808.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.s808.data.database.LetsRideDatabase
import com.s808.data.database.dao.CivilianDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "letsride_settings")

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {
    @Provides
    fun providesDatastorePrefs(@ApplicationContext appContext: Context): DataStore<Preferences> =
        appContext.dataStore

}
