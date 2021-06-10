package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class wind(
    @SerializedName("speed")val speed:Double,
    @SerializedName("deg")val degree:Double
)