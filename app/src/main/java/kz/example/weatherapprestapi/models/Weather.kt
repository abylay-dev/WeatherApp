package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class Weather(
    @SerializedName("coord")val cord: Cord,
    @SerializedName("weather")val weather_desc:List<Weather_desc>,
    @SerializedName("main")val main_desc:Main,
    @SerializedName("sys")val sys_desc: Sys,
    @SerializedName("name")val name:String,
    @SerializedName("wind")val wind_desc:Wind
)