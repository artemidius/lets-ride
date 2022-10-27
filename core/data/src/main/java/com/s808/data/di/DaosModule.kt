package com.s808.data.di

import com.s808.data.database.LetsRideDatabase
import com.s808.data.database.dao.CivilianDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesCivilianDao(
        database: LetsRideDatabase,
    ): CivilianDao = database.civilianDao()
}
