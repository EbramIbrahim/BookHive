package com.example.bazar.feature.onboarding.di

import com.example.bazar.core.domain.local.repository.IKeyValueStorageProvider
import com.example.bazar.feature.onboarding.data.local.repository.SaveSkipOnBoardingValueImpl
import com.example.bazar.feature.onboarding.domain.local.repository.SaveSkipOnBoardingValue
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OnBoardingModule {

    @Provides
    @Singleton
    fun provideOnBoardingUseCase(datastore: IKeyValueStorageProvider): SaveSkipOnBoardingValue {
        return SaveSkipOnBoardingValueImpl(datastore)
    }
}