package com.example.myapplication.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Animal
import com.example.myapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    val animalResponse:MutableLiveData<List<Animal>> = MutableLiveData()

    fun getAnimal(){
        viewModelScope.launch {
            try {
                animalResponse.value = repository.getAnimal().body()

            }catch (e:Exception){

            }
        }
    }

    fun postAnimal(animal: Animal){
        viewModelScope.launch {
            try {
                repository.postAnimal(animal)
            }catch (e:Exception){
                Log.d("postAnimal:",e.message.toString())
            }
        }
    }

}