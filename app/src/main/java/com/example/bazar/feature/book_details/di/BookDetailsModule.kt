package com.example.bazar.feature.book_details.di

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
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object BookDetailsModule {

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
            .baseUrl("https://www.googleapis.com/books/v1/")
            .build()
    }

    @Provides
    @Singleton
    fun provideAlReposApiService(retrofit: Retrofit): BookDetailsRemoteService =
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





