package com.s808.di

import com.s808.network.api.civilian.CivilianApi
import com.s808.network.api.civilian.CivilianApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface ApisModule {
    @Binds
    fun bindsCivilianApi(civilianApiImpl: CivilianApiImpl): CivilianApi
}