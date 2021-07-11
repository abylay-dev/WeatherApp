package kz.example.weatherapprestapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kz.example.weatherapprestapi.models.Weather
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class wFragment(): Fragment() {
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var progressBar: ProgressBar
    //private var binding =

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)
        progressBar = view.findViewById(R.id.progressBar)
        return view
    }

    private fun bind(weather: Weather){
        val city_n : TextView? = null
        val country_name : TextView? = null
        val temperature : TextView? = null
        val feels_like : TextView? = null
        val pressure : TextView? = null
        val temp1 : Double = Math.round((weather.main_desc.temp - 273.15)*100.0)/100.0
        val temp_f : Double = Math.round((weather.main_desc.feels_like - 273.15)*100.0)/100.0

        city_n!!.text = weather.name
        country_name!!.text = weather.sys_desc.country
        /*       coord_lon!!.text = "Lon: ${weather.cord.lon}"
               coord_lat!!.text = "Lon: ${weather.cord.lat}"*/
        temperature!!.text = temp1.toString()
        feels_like!!.text = "Feels like: $temp_f"
        pressure!!.text = "Pressure: ${weather.main_desc.pressure}"
        /*wind_speed!!.text = "Speed: ${weather.wind_desc.speed}"
        wind_degree!!.text = "Degree: ${weather.wind_desc.degree}"
        desciption_weather!!.text = weather.weather_desc.get(0).descr*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.observeIsLoadingState()
            .observe(this.viewLifecycleOwner, {
                if (it == true) {
                    progressBar.visibility = View.VISIBLE
                } else {
                    progressBar.visibility = View.GONE
                }
            })

        viewModel.observeCurrentWeather().observe(this.viewLifecycleOwner, {
            bind(it)
        })
    }

}