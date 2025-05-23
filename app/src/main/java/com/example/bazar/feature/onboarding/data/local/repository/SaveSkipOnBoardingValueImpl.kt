package com.example.bazar.feature.onboarding.data.local.repository

import com.example.bazar.core.data.repository.local.StorageLocalKey
import com.example.bazar.core.domain.local.repository.IKeyValueStorageProvider
import com.example.bazar.feature.onboarding.domain.local.repository.SaveSkipOnBoardingValue
import javax.inject.Inject

class SaveSkipOnBoardingValueImpl @Inject constructor(
    private val datastore: IKeyValueStorageProvider
) : SaveSkipOnBoardingValue {

    override suspend fun saveSkipOnBoarding() {
        datastore.save(
            StorageLocalKey.SKIP_ONBOARDING,
            true,
            Boolean::class.java
        )
    }

}