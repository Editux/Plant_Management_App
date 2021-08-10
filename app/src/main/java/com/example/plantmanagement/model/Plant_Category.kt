package com.example.plantmanagement.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Plant_Category")
data class Plant_Category(

        @PrimaryKey var plant_type_id: Int =0,
        @ColumnInfo(name="plant_type_name") var type:String ="",
        @ColumnInfo(name="plant_type_water")var water_time: String ="",
        @ColumnInfo(name="plant_type_details")var details: String = "",){
    

     override fun toString(): String {
        return type
    }




}