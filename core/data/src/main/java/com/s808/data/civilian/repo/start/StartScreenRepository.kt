package com.s808.data.civilian.repo.start

interface StartScreenRepository {
    suspend fun getCurrentTab(): Int
    suspend fun setCurrentTab(tab: Int)
}
