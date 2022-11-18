package com.s808.network.config

import com.s808.common.app.variant.AppVariant

interface NetworkConfigFactory {
    val networkConfig: NetworkConfig
    fun setAppVariant(appVariant: AppVariant)
}
