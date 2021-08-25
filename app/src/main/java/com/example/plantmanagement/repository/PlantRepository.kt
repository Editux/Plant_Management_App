package com.example.plantmanagement.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.plantmanagement.database.PlantDatabase
import com.example.plantmanagement.model.Plant
import kotlinx.coroutines.flow.Flow


class PlantRepository(application:Application){
    private var allPlants = MutableLiveData<List<Plant>>()

    private val plantDAO = PlantDatabase.getDatabase(application).plantDao()

    fun getAllPlants(): Flow<List<Plant>> = plantDAO.getAll()
     fun insertPlant(plant: Plant){
         return plantDAO.insertPlant(plant)
     }
     fun updatePlant(plant: Plant){
         return plantDAO.updatePlant(plant)
     }
     fun deletePlantById(id: Long){
         return plantDAO.delete(id)
     }


}