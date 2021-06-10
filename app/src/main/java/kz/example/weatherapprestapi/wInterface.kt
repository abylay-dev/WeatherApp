package kz.example.weatherapprestapi

import kz.example.weatherapprestapi.models.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface wInterface {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q")q_cityName: String?,
        @Query("appid")app_id:String
    ):Call<Weather>
}