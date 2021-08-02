package com.example.plantmanagement.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.plantmanagement.R
import com.example.plantmanagement.model.Plant_Category

class Edit_Form : AppCompatActivity() {
    private lateinit var mySpinner: Spinner
    private lateinit var adapter: ArrayAdapter<Plant_Category>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit__form)
        mySpinner = findViewById(R.id.spinner3)

        val customObjects = getCustomObjects()
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, customObjects)

        mySpinner.adapter = adapter
    }

    private fun getCustomObjects(): ArrayList<Plant_Category> {
        val customObjects = ArrayList<Plant_Category>()
        customObjects.apply {
            add(Plant_Category(1, "Strawberry","2 times a day","Water more in summer, Can cause irritation to cats"))
            add(Plant_Category(2, "Aloe","2 times a week","Water more in summer, Is not safe to digest for pets"))
            add(Plant_Category(3, "Money tree", "1-2 times a week","Needs medium to bright indirect light, Safe for pets"))

        }
        return customObjects
    }
}

