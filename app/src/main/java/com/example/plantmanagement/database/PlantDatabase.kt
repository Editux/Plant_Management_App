package com.example.plantmanagement.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.plantmanagement.R
import com.example.plantmanagement.dao.PlantCategoryOperations
import com.example.plantmanagement.dao.PlantOperations
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.model.Plant_Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@Database(entities = [Plant::class], version = 1,exportSchema = false)
abstract class PlantDatabase:RoomDatabase() {
    abstract fun plantDao(): PlantOperations
    abstract fun plantCategoryDao(): PlantCategoryOperations

    companion object {
        private var INSTANCE: PlantDatabase? = null
        private const val DB_NAME = "plant"


        fun getDatabase(context: Context): PlantDatabase {
            if (INSTANCE == null) {


                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDatabase::class.java, DB_NAME
                )   .createFromAsset("database/plant.sql")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    //.addCallback(object : Callback() {
                       // override fun onCreate(db: SupportSQLiteDatabase) {
                           // super.onCreate(db)
                           // Executors.newSingleThreadScheduledExecutor()
                            //   .execute(Runnable {
                                 //   INSTANCE?.plantDao()!!
                                       //.insertAll(Plant(1,"Aloe", "content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F74/ORIGINAL/NONE/80597715","Aloe","1 per week","Dangerous for pets"))
                               // })

                       // }
                   // })
                    .build()
            }


            return INSTANCE!!

        }

    }
    }


