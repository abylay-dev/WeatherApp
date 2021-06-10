package kz.example.weatherapprestapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kz.example.weatherapprestapi.models.Weather
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class wFragment(
    var city_name:String?
): Fragment() {
    private var retrofit:Retrofit? = null
    private var interf:wInterface? = null
    private val apiKey = "5d453c04e003b69ead215a4dc0a3fd33"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        retrofit = Retrofit
            .Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create()).
            .build()

        interf = retrofit?.create(wInterface::class.java)
        getWeather()
    }

    fun bind(weather: Weather){
        val city_n = view?.findViewById<TextView>(R.id.tvCityName)
        val country_name = view?.findViewById<TextView>(R.id.tvCountryName)
        val coord_lon = view?.findViewById<TextView>(R.id.tvLon)
        val coord_lat = view?.findViewById<TextView>(R.id.tvLat)
        val temperature = view?.findViewById<TextView>(R.id.tvTempDescription)
        val feels_like = view?.findViewById<TextView>(R.id.tvFeelslike)
        val pressure = view?.findViewById<TextView>(R.id.tvPressure)
        val wind_speed = view?.findViewById<TextView>(R.id.tvWind_speed)
        val wind_degree = view?.findViewById<TextView>(R.id.tvWind_degree)
        val desciption_weather = view?.findViewById<TextView>(R.id.tvdescr)

        city_n!!.text = weather.name
        country_name!!.text = weather.sys_desc.country
        coord_lon!!.text = "Lon: ${weather.cord.lon}"
        coord_lat!!.text = "Lon: ${weather.cord.lat}"
        temperature!!.text = "Temperature: ${weather.main_desc.temp - 273.15}"
        feels_like!!.text = "Feels like: ${weather.main_desc.feels_like - 273.15}"
        pressure!!.text = "Pressure: ${weather.main_desc.pressure}"
        wind_speed!!.text = "Speed: ${weather.wind_desc.speed}"
        wind_degree!!.text = "Degree: ${weather.wind_desc.degree}"
        desciption_weather!!.text = "${weather.weather_desc}"
    }
    fun getWeather(){
        val call=interf?.getWeather(
            city_name,
            apiKey
        )
        call?.enqueue(object: Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                response.body().let {
                    bind(it as Weather)
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(requireContext(), "Error: $t", Toast.LENGTH_LONG).show()
            }

        })

    }
}