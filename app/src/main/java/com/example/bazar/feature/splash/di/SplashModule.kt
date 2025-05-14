package com.example.bazar.feature.splash.di

import com.example.bazar.core.domain.local.repository.IKeyValueStorageProvider
import com.example.bazar.feature.splash.data.repository.local.GetSkipOnBoardingRepositoryImpl
import com.example.bazar.feature.splash.domain.local.repository.GetSkipOnBoardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SplashModule {

    @Provides
    @Singleton
    fun provideSplashUseCase(datastore: IKeyValueStorageProvider): GetSkipOnBoardingRepository {
        return GetSkipOnBoardingRepositoryImpl(datastore)
    }
}