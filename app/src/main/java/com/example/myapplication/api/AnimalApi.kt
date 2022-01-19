package com.example.myapplication.api

import com.example.myapplication.model.Animal
import com.example.myapplication.utils.Constants.GET_ANIMAL
import retrofit2.Response
import retrofit2.http.*

interface AnimalApi {

    @GET(GET_ANIMAL)
    suspend fun getAnimal():Response<List<Animal>>

    @POST(GET_ANIMAL)
    suspend fun postAnimal(
        @Body animal: Animal
    )
}