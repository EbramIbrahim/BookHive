package com.example.bazar.feature.book_details.di

import com.example.bazar.core.di.SecondApiRetrofit
import com.example.bazar.feature.book_details.data.repository.remote.BookDetailsRemoteService
import com.example.bazar.feature.book_details.data.repository.remote.BookDetailsRepositoryImpl
import com.example.bazar.feature.book_details.domain.repository.remote.BookDetailsRepository
import com.example.bazar.feature.book_details.domain.usecase.BookDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object BookDetailsModule {

    @Provides
    @Singleton
    @SecondApiRetrofit
    fun provideRetrofit(
        okHttpClient: OkHttpClient.Builder,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient.build())
            .addConverterFactory(gsonConverterFactory)
            .baseUrl("https://www.googleapis.com/books/v1/")
            .build()
    }

    @Provides
    @Singleton
    fun provideAlReposApiService(@SecondApiRetrofit retrofit: Retrofit): BookDetailsRemoteService =
        retrofit.create(BookDetailsRemoteService::class.java)

    @Provides
    @Singleton
    fun provideBookDetailsRepository(remoteService: BookDetailsRemoteService):
            BookDetailsRepository {
        return BookDetailsRepositoryImpl(remoteService)
    }

    @Provides
    @Singleton
    fun provideBookDetailsUseCase(repository: BookDetailsRepository): BookDetailsUseCase {
        return BookDetailsUseCase(repository)
    }
}





