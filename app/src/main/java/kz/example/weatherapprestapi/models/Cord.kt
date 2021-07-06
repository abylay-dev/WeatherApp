package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class Cord(
    @SerializedName("lon")val lon:Double,
    @SerializedName("lat")val lat:Double
)
