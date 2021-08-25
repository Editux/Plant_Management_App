package com.example.plantmanagement.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.plantmanagement.R
import com.example.plantmanagement.database.PlantDatabase
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.model.Plant_Category
import com.example.plantmanagement.viewmodel.PlantViewModel
import java.io.ByteArrayOutputStream

class Edit_Plant : AppCompatActivity() {
    private lateinit var mySpinner: Spinner
    private lateinit var loadButton: Button
    private lateinit var saveButton: Button
    private lateinit var plant_name : EditText
    lateinit var imageView: ImageView
    private val pickImage = 100
    private var imageUri: Uri? = null
    private lateinit var bitmap: Bitmap
    private lateinit var adapter: ArrayAdapter<Plant_Category>
    var selectedText = getCustomObjects()[1]
    var p_type =getCustomObjects()[1].type
    var p_water=getCustomObjects()[1].water_time
    var p_details=getCustomObjects()[1].details
    lateinit var plantViewModel: PlantViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit__plant)
        mySpinner = findViewById(R.id.edit_spinner)
        imageView = findViewById(R.id.image_edit)
        loadButton = findViewById(R.id.edit_Loadbutton)
        saveButton = findViewById(R.id.edit_saveButton)
        plant_name =findViewById(R.id.plant_edit_name)

        //Receive intent
        val intent = intent
        val plant_id =intent.getLongExtra("plant_id",0)
        val name =intent.getStringExtra("plant_name")
        val plant_image = intent.getByteArrayExtra("plant_image")
        val type = intent.getStringExtra("plant_type")


        val bitmap = BitmapFactory.decodeByteArray(plant_image,0, plant_image!!.size)
        imageView!!.setImageBitmap(bitmap)
        plant_name!!.setText(name)
        loadButton.setOnClickListener {
            val gallery = Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
        val customObjects = getCustomObjects()
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, customObjects)

        mySpinner.adapter = adapter
        plantViewModel = ViewModelProvider(this).get(PlantViewModel::class.java)
        saveButton.setOnClickListener {



            //Title
            var name=plant_name.text.toString()
            if(name!!.isEmpty())
            {
                Toast.makeText(applicationContext, "Please enter plant name", Toast.LENGTH_SHORT).show()

            }
            //Image
            var imageInByte: ByteArray = plant_image
            val image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri)
            val stream = ByteArrayOutputStream()
            image.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            imageInByte = stream.toByteArray()
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
            plantViewModel.updatePlant(Plant(plant_id, name, imageInByte, p_type, p_water, p_details))
            Toast.makeText(this, "Data Updated Successfully into  Database", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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

