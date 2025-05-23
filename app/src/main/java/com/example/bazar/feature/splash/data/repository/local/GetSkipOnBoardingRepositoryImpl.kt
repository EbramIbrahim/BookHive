package com.example.bazar.feature.splash.data.repository.local

import com.example.bazar.core.data.repository.local.StorageLocalKey
import com.example.bazar.core.domain.local.repository.IKeyValueStorageProvider
import com.example.bazar.feature.splash.domain.local.repository.GetSkipOnBoardingRepository
import javax.inject.Inject

class GetSkipOnBoardingRepositoryImpl @Inject constructor(
    private val datastore: IKeyValueStorageProvider
): GetSkipOnBoardingRepository {

    override suspend fun getKey(): Boolean {
        return datastore.get(
            StorageLocalKey.SKIP_ONBOARDING,
            true,
            Boolean::class.java
        )
    }
}