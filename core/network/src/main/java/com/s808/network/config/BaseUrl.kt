package com.s808.network.config

internal sealed class BaseUrl(val url: String) {
    object Prod: BaseUrl("https://genericapizzz.com")
    object Debug: BaseUrl("https://genericapizzz.com")
}