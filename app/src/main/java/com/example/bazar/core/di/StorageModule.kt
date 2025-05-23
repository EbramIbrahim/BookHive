package com.example.bazar.core.di

import android.content.Context
import com.example.bazar.core.data.repository.local.KeyValueStorageProvider
import com.example.bazar.core.domain.local.repository.IKeyValueStorageProvider

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object StorageModule {


    @Provides
    @Singleton
    fun provideKeyValueStorageProvider(@ApplicationContext context: Context): IKeyValueStorageProvider =
        KeyValueStorageProvider(context)
}