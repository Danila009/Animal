package com.example.myapplication.repository

import com.example.myapplication.api.AnimalApi
import com.example.myapplication.model.Animal
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val animalApi: AnimalApi
) {

    suspend fun getAnimal():Response<List<Animal>> = animalApi.getAnimal()

    suspend fun postAnimal(animal: Animal) = animalApi.postAnimal(animal)


}