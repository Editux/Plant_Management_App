package com.example.plantmanagement.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.model.Plant_Category

@Dao
interface PlantCategoryOperations {
  //  @Query("SELECT * FROM Plant_Category")
    //fun getAll(): LiveData<List<Plant_Category>>
}