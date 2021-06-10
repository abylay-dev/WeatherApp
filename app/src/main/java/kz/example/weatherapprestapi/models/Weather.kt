package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class Weather(
    @SerializedName("coord")val cord: Cord,
    @SerializedName("weather")val weather_desc:List<Weather_desc>,
    @SerializedName("main")val main_desc:main,
    @SerializedName("sys")val sys_desc: sys,
    @SerializedName("name")val name:String,
    @SerializedName("wind")val wind_desc:wind
) {
}