package kz.example.weatherapprestapi

import kz.example.weatherapprestapi.models.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface wInterface {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") q_cityName:String,
        @Query("appid") app_id:String
    ):List<Weather>
}
/*
http://api.openweathermap.org/data/2.5/weather?q=Almaty&appid=5d453c04e003b69ead215a4dc0a3fd33
xasin11957@relumyx.com
qwer1234
 */