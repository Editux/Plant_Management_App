package com.example.plantmanagement.dao

import androidx.room.*
import com.example.plantmanagement.model.Plant
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantOperations {
    @Query("SELECT * FROM Plant")
    fun getAll(): Flow<List<Plant>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg plant: Plant?)
    @Insert
    fun insertPlant(plant: Plant)
    @Query("DELETE  FROM Plant WHERE plant_id = :id")
    fun delete(id: Long)

   @Update
    fun updatePlant(plant: Plant)}