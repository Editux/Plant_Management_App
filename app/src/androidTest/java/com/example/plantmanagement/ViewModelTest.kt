package com.example.plantmanagement

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.plantmanagement.database.PlantDatabase
import com.example.plantmanagement.viewmodel.PlantViewModel
import junit.framework.TestCase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.shadows.ResourceHelper2.getValue

import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ViewModelTest: TestCase() {
    private lateinit var plantDatabase: PlantDatabase
    private lateinit var viewModel: PlantViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        plantDatabase = Room.inMemoryDatabaseBuilder(
            context, PlantDatabase::class.java
        ).allowMainThreadQueries().build()

    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        plantDatabase.close()
    }

}