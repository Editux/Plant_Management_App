package com.example.plantmanagement.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.plantmanagement.R
import com.example.plantmanagement.database.PlantDatabase
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.model.Plant_Category

import java.io.ByteArrayOutputStream


class Edit_Form : AppCompatActivity() {
    private lateinit var mySpinner: Spinner
    private lateinit var loadButton: Button
    private lateinit var saveButton: Button
    private lateinit var plant_name : EditText
    lateinit var imageView: ImageView
    private val pickImage = 100
    private var imageUri: Uri? = null
    private lateinit var bitmap:Bitmap
    private lateinit var adapter: ArrayAdapter<Plant_Category>
    var selectedText = getCustomObjects()[1]
    var p_type =getCustomObjects()[1].type
    var p_water=getCustomObjects()[1].water_time
    var p_details=getCustomObjects()[1].details

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit__form)
        mySpinner = findViewById(R.id.spinner3)
        imageView = findViewById(R.id.imageView2)
        loadButton = findViewById(R.id.Loadbutton)
        saveButton = findViewById(R.id.saveButton)
        plant_name =findViewById(R.id.plant_name)


        loadButton.setOnClickListener {
            val gallery = Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
        val customObjects = getCustomObjects()
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, customObjects)

        mySpinner.adapter = adapter

        saveButton.setOnClickListener {

            //Id
            var rand_plant_id = Math.random()
            //Title
            var name=plant_name.text.toString()
            if(name!!.isEmpty())
            {
                Toast.makeText(applicationContext, "Please enter plant name", Toast.LENGTH_SHORT).show()

            }
            //Image


            val image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri)
            val stream = ByteArrayOutputStream()
            image.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val imageInByte: ByteArray = stream.toByteArray()
            //Spinner
            mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    selectedText = customObjects[position]
                     p_type = customObjects[position].type
                     p_water = customObjects[position].water_time
                     p_details= customObjects[position].details

                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }

            }
            PlantDatabase.getDatabase(this).plantDao().insertPlant(Plant(rand_plant_id.toLong(), name, imageInByte, p_type, p_water, p_details))
            Toast.makeText(this, "Data Inserted Successfully into  Database", Toast.LENGTH_LONG).show()

            val list_activity =Intent(this ,MainActivity::class.java );
            startActivity(list_activity);
        }
    }

    private fun getCustomObjects(): ArrayList<Plant_Category> {
        val customObjects = ArrayList<Plant_Category>()
        customObjects.apply {
            add(Plant_Category(1, "Strawberry", "2 times a day", "Water more in summer, Can cause irritation to cats"))
            add(Plant_Category(2, "Aloe", "2 times a week", "Water more in summer, Is not safe to digest for pets"))
            add(Plant_Category(3, "Money tree", "1-2 times a week", "Needs medium to bright indirect light, Safe for pets"))

        }
        return customObjects
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
             bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri)
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
            val image = stream.toByteArray()

            imageView.setImageBitmap(bitmap)
            Log.d("Image uri:", imageUri.toString())

        }
    }
}

