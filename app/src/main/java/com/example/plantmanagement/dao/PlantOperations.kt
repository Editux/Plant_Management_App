package com.example.plantmanagement.dao

import androidx.room.*
import com.example.plantmanagement.model.Plant
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantOperations {
    @Query("SELECT * FROM Plant")
    fun getAll(): Flow<List<Plant>>


    @Insert
    fun insertAll(vararg plant: Plant?)
    @Insert
    fun insertPlant(plant: Plant)

    @Delete
    fun delete(plant: Plant)

    @Update
    fun updatePlant(plant: Plant)}