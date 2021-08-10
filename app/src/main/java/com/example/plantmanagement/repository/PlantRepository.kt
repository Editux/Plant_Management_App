package com.example.plantmanagement.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.plantmanagement.dao.PlantOperations
import com.example.plantmanagement.database.PlantDatabase
import com.example.plantmanagement.model.Plant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


class PlantRepository(application:Application){
    private var allPlants = MutableLiveData<List<Plant>>()

    private val plantDAO = PlantDatabase.getDatabase(application).plantDao()

    fun getAllPlants(): Flow<List<Plant>> = plantDAO.getAll()


}