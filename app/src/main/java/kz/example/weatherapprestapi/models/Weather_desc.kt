package kz.example.weatherapprestapi.models

import com.google.gson.annotations.SerializedName

class Weather_desc(
    @SerializedName("description")val descr:String,
    ) {
    /*fun getString():String{
        return "$main, $descr"
    }*/
}