package com.s808.di

import com.s808.common.app.variant.AppVariant
import com.s808.letsride.core.network.BuildConfig
import com.s808.network.config.NetworkConfigFactory
import com.s808.network.config.NetworkConfigFactoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesNetworkConfigFactory(): NetworkConfigFactory = NetworkConfigFactoryImpl().apply {
        setAppVariant(
            if (BuildConfig.DEBUG) {
                AppVariant.DEBUG
            } else {
                AppVariant.RELEASE
            }
        )
    }
}
