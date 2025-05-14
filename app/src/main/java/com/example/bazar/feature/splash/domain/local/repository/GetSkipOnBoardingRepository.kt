package com.example.bazar.feature.splash.domain.local.repository

interface GetSkipOnBoardingRepository {
    suspend fun getKey(): Boolean
}