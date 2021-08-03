package com.example.plantmanagement.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.plantmanagement.R

class PlantDetails : AppCompatActivity() {
    var detail_name:TextView?=null
    var detail_image:ImageView?=null
    var detail_type:TextView?=null
    var detail_water:TextView?=null
    var detail_notes:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_details)
        detail_name=findViewById<View>(R.id.PlantName) as TextView
        detail_image=findViewById<View>(R.id.imageView3)as ImageView
        detail_type=findViewById<View>(R.id.PlantType)as TextView
        detail_water=findViewById<View>(R.id.PlantWater)as TextView
        detail_notes=findViewById<View>(R.id.Plant_Notes)as TextView
        val intent = intent
        val name =intent.getStringExtra("plant_name")
        val image = intent.getIntExtra("plant_image",0)
        val type = intent.getStringExtra("plant_type")
        val water = intent.getStringExtra("plant_water")
        val notes = intent.getStringExtra("plant_details")

        detail_name!!.text=name
        detail_image!!.setImageResource(image)
        detail_type!!.text=type
        detail_water!!.text=water
        detail_notes!!.text=notes
    }

}


