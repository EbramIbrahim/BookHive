package com.example.bazar.feature.home_screen.di

import com.example.bazar.core.data.repository.remote.BooksApi
import com.example.bazar.feature.home_screen.data.repository.GetBooksRepositoryImpl
import com.example.bazar.feature.home_screen.domain.repository.GetBooksRepository
import com.example.bazar.feature.home_screen.domain.usecase.GetBooksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HomeModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient().newBuilder().apply {
            connectTimeout(30L, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            connectionPool(
                ConnectionPool(30L.toInt(), 500000, TimeUnit.MILLISECONDS)
            )
            readTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(30L, TimeUnit.SECONDS)
        }
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient.Builder,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient.build())
            .addConverterFactory(gsonConverterFactory)
            .baseUrl("https://myne.krsh.dev/")
            .build()
    }

    @Provides
    @Singleton
    fun provideAlReposApiService(retrofit: Retrofit): BooksApi =
        retrofit.create(BooksApi::class.java)

    @Provides
    @Singleton
    fun provideGetBooksRepository(api: BooksApi): GetBooksRepository {
        return GetBooksRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetBooksUseCase(repository: GetBooksRepository): GetBooksUseCase {
        return GetBooksUseCase(repository)
    }

}













