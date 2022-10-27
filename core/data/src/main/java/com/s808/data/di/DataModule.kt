package com.s808.data.di

import com.s808.data.civilian.repo.CivilianRepository
import com.s808.data.civilian.repo.CivilianRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsTopicRepository(
        civilianRepositoryImpl: CivilianRepositoryImpl
    ): CivilianRepository
}
