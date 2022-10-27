package com.s808.data.di

import android.content.Context
import androidx.room.Room
import com.s808.data.database.LetsRideDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesLetsRideDatabase(
        @ApplicationContext context: Context,
    ): LetsRideDatabase = Room.databaseBuilder(
        context,
        LetsRideDatabase::class.java,
        "letsride-database"
    ).build()
}
