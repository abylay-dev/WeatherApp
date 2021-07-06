package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class Main(
    @SerializedName("temp")val temp:Double,
    @SerializedName("feels_like")val feels_like:Double,
    @SerializedName("pressure")val pressure:Double
) {
}