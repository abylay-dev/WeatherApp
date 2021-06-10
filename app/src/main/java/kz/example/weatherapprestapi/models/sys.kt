package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class sys(
    @SerializedName("country")val country: String
)