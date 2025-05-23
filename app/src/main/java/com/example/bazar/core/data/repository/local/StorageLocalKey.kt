package com.example.bazar.core.data.repository.local

import com.example.bazar.core.domain.local.repository.IStorageLocalKey


enum class StorageLocalKey(override val keyPreference: String): IStorageLocalKey {
    SKIP_ONBOARDING("skip_onboarding_key")
}