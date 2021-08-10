package com.example.plantmanagement.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.plantmanagement.dao.PlantCategoryOperations
import com.example.plantmanagement.dao.PlantOperations
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.model.Plant_Category

@Database(entities = [Plant::class, Plant_Category::class], version = 1)
abstract class PlantDatabase:RoomDatabase() {
    abstract fun plantDao(): PlantOperations
    abstract fun plantCategoryDao(): PlantCategoryOperations

    companion object {
        private var INSTANCE: PlantDatabase? = null
        private const val DB_NAME = "C:\\Users\\edita\\plants.db"

        fun getDatabase(context: Context): PlantDatabase {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDatabase::class.java, DB_NAME
                ) 
                    .fallbackToDestructiveMigration()
                    .build()
            }


            return INSTANCE!!
        }
    }
}