package com.example.bazar.core.di

import javax.inject.Qualifier

// Qualifiers.kt
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FirstApiRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondApiRetrofit


