package com.s808.network.config

import com.s808.common.app.variant.AppVariant
import com.s808.common.app.variant.AppVariant.RELEASE
import com.s808.common.app.variant.AppVariant.DEBUG
import com.s808.letsride.core.network.BuildConfig

internal class NetworkConfigFactoryImpl: NetworkConfigFactory {
    override val networkConfig: NetworkConfig
        get() = getConfig()

    override fun setAppVariant(appVariant: AppVariant) {
        _appVariant = appVariant
    }

    private var _appVariant: AppVariant? = null

    private fun getConfig(): NetworkConfig {
        return when (_appVariant) {
            RELEASE -> NetworkConfig(BaseUrl.Prod.url).apply {
                tokens[TokenType.BACKEND] = BuildConfig.BACKEND_TOKEN
            }
            DEBUG -> NetworkConfig(BaseUrl.Debug.url).apply {
                tokens[TokenType.BACKEND] = BuildConfig.BACKEND_TOKEN
            }
            else -> NetworkConfig(BaseUrl.Prod.url).apply {
                tokens[TokenType.BACKEND] = BuildConfig.BACKEND_TOKEN
            }
        }
    }
}
