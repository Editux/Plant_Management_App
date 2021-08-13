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


}