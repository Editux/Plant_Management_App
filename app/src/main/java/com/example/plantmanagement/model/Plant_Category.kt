package com.example.plantmanagement.model

data class Plant_Category(
        var id: Int =0,
        var type:String ="" ,
        var water_time: String ="",
        var details: String = ""){

    override fun toString(): String {
        return type
    }
}