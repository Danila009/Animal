package com.example.myapplication.di

import com.example.myapplication.api.AnimalApi
import com.example.myapplication.repository.Repository
import com.example.myapplication.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnimalModule {

    @Provides
    @Singleton
    fun providerAnimalApi(
        animalApi: AnimalApi
    ) = Repository(animalApi)

    @Provides
    @Singleton
    fun providerAnimalRetrofit():AnimalApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AnimalApi::class.java)
}