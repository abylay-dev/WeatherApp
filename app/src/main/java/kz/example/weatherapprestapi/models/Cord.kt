package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class Cord(
    @SerializedName("lon")val lon:Double,
    @SerializedName("lat")val lat:Double
)
/*
http://api.openweathermap.org/data/2.5/weather?q=Almaty&appid=5d453c04e003b69ead215a4dc0a3fd33
xasin11957@relumyx.com
qwer1234
 */