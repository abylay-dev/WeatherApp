package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class Sys(
    @SerializedName("country")val country: String
)