package com.example.plantmanagement.model

import androidx.room.*


@Entity(tableName = "Plant")
data class Plant(

        @PrimaryKey(autoGenerate = true) var plant_id:Long,
        @ColumnInfo (name="plant_name") var name: String,
        //@Embedded var type: Plant_Category,
        @ColumnInfo(name= "plant_image", typeAffinity = ColumnInfo.BLOB) var image: ByteArray,
        @ColumnInfo(name="plant_type_name") var type:String ="",
        @ColumnInfo(name="plant_type_water")var water_time: String ="",
        @ColumnInfo(name="plant_type_details")var details: String = "",


        ) {

}