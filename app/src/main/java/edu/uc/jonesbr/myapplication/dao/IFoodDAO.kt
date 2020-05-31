package edu.uc.jonesbr.myapplication.dao

import edu.uc.jonesbr.myapplication.dto.FoodType
import retrofit2.http.GET

interface IFoodDAO {

    @GET("/discospiff/PlantPlacesKotlin/master/foodtypes.json")
    suspend fun getFoodTypes(): ArrayList<FoodType>
}