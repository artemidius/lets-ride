package com.s808.di

import com.s808.repo.riders.RidersRepository
import com.s808.repo.riders.RidersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface ReposModule {
    @Binds
    fun bindsRidersRepo(ridersRepositoryImpl: RidersRepositoryImpl): RidersRepository
}