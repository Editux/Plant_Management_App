package com.example.plantmanagement

import android.R
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.plantmanagement.dao.PlantOperations
import com.example.plantmanagement.database.PlantDatabase
import com.example.plantmanagement.model.Plant
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.ByteArrayOutputStream


@RunWith(AndroidJUnit4::class)
class DatabaseTest :TestCase() {
    private lateinit var db:PlantDatabase
    private lateinit var dao:PlantOperations

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, PlantDatabase::class.java).build()
        dao = db.plantDao()
    }
    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun WriteAndReadPlant()=runBlocking(){






        val plant = Plant(
            Math.random().toLong(),
            "Vera",
            null,
            "Aloe",
            "2 times a week ,Water more in summer",
            "Is not safe to digest for pets"
        )
        dao.insertPlant(plant);

        val plants=dao.getAll().first()
        assertEquals(plants[0].name, plant.name)


    }

}


