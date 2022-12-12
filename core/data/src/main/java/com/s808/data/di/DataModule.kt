package com.s808.data.di

import com.s808.data.civilian.repo.profile.CivilianProfileRepository
import com.s808.data.civilian.repo.profile.CivilianProfileRepositoryImpl
import com.s808.data.civilian.repo.start.StartScreenRepository
import com.s808.data.civilian.repo.start.StartScreenRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsTopicRepository(
        civilianProfileRepositoryImpl: CivilianProfileRepositoryImpl
    ): CivilianProfileRepository

    @Binds
    fun bindsStartScreenRepo(
        startScreenRepositoryImpl: StartScreenRepositoryImpl
    ): StartScreenRepository
}
