package edu.uc.jonesbr.myapplication.dto

data class FoodType (var type:String = "Undefined") {
    override fun toString() = type
}
