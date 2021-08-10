package com.example.plantmanagement.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.plantmanagement.model.Plant
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantOperations {
    @Query("SELECT * FROM Plant")
    fun getAll(): Flow<List<Plant>>



    @Insert
    fun insertPlant( plant: Plant)

    @Delete
    fun delete(plant:Plant)

    @Update
    fun updatePlant(plant:Plant)}