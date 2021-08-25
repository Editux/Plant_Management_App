package com.example.plantmanagement.activity

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.plantmanagement.R
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.viewmodel.PlantViewModel

class PlantDetails : AppCompatActivity() {
    var detail_name:TextView?=null
    var detail_image:ImageView?=null
    var detail_type:TextView?=null
    var detail_water:TextView?=null
    var detail_notes:TextView?=null
    lateinit var delete_Button:Button
    lateinit var plantViewModel: PlantViewModel
    lateinit var edit_Button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_details)
        detail_name=findViewById<View>(R.id.PlantName) as TextView
        detail_image=findViewById<View>(R.id.imageView3)as ImageView
        detail_type=findViewById<View>(R.id.PlantType)as TextView
        detail_water=findViewById<View>(R.id.PlantWater)as TextView
        detail_notes=findViewById<View>(R.id.Plant_Notes)as TextView
        delete_Button=findViewById<View>(R.id.delete_Button)as Button
        edit_Button= findViewById<View>(R.id.edit_Button)as Button
        //Receive data
        val intent = intent
        val plant_id =intent.getLongExtra("plant_id",0)
        val name =intent.getStringExtra("plant_name")
        val image = intent.getByteArrayExtra("plant_image")
        val type = intent.getStringExtra("plant_type")
        val water = intent.getStringExtra("plant_water")
        val notes = intent.getStringExtra("plant_details")


        detail_name!!.text=name
        val bitmap = BitmapFactory.decodeByteArray(image,0, image!!.size)
        detail_image!!.setImageBitmap(bitmap)
        detail_type!!.text=type
        detail_water!!.text=water
        detail_notes!!.text=notes
        plantViewModel = ViewModelProvider(this).get(PlantViewModel::class.java)
        //Delete button
        delete_Button.setOnClickListener {
            plantViewModel.deletePlant(plant_id)
        }

        //Edit button
        edit_Button.setOnClickListener {
            val intent = Intent(this, Edit_Plant::class.java)
            intent.putExtra("plant_id", plant_id)
            intent.putExtra("plant_name", name)
            intent.putExtra("plant_image", image)
            intent.putExtra("plant_type", type)
            intent.putExtra("plant_water", water)
            intent.putExtra("plant_details", notes)
            startActivity(intent)
        }
    }

}


