package com.example.plantmanagement.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.repository.PlantRepository
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class PlantViewModel(
            application: Application
    ): AndroidViewModel(application) {

    private var repository = PlantRepository(application)


    val allPlants = repository.getAllPlants()
            .flowOn(Dispatchers.IO)
            .asLiveData()

 fun insertPlant(plant:Plant) =viewModelScope.launch {
      repository.insertPlant(plant)
 }

    fun updatePlant(plant:Plant)= viewModelScope.launch {
        repository.updatePlant(plant)
    }

    fun deletePlant(id:Long) =viewModelScope.launch {
        repository.deletePlantById(id)
    }
}



