package com.example.plantmanagement.model

data class Plant(
    var id:Long,
    var name: String,
    var type: Plant_Category,
    var image: Int,

    ) {

}