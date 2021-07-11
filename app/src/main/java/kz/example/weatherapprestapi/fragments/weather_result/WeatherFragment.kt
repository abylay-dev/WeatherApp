package kz.example.weatherapprestapi.fragments.weather_result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kz.example.weatherapprestapi.R
import kz.example.weatherapprestapi.models.Weather

class WeatherFragment(layoutId: Int) : Fragment(layoutId) {

    //region Companion
    companion object {
        private const val CITY = "CITY"

        fun newInstance(city: String): WeatherFragment {
//            val fragment = WeatherFragment(R.layout.fragment_weather)
//            val args = Bundle()
//            args.putString(CITY, city)
//            fragment.arguments = args
//            return fragment

            return WeatherFragment(R.layout.fragment_weather).apply {
                val args = Bundle()
                args.putString(CITY, city)
                arguments = args
            }
        }
    }
    //endregion

    private val viewModel: WeatherViewModel by viewModels() {
        WeatherViewModelFactory(arguments?.getString(CITY, "") ?: "")
    }
    private lateinit var progressBar: ProgressBar
    //private var binding =

    private fun bind(weather: Weather) {
        with(requireNotNull(view)) {
            val city_n: TextView? = findViewById(R.id.tvCityName)
            val country_name: TextView? = findViewById(R.id.tvCountryName)
            val temperature: TextView? = findViewById(R.id.tvTempDescription)
            val feels_like: TextView? = findViewById(R.id.tvFeelslike)
            val pressure: TextView? = findViewById(R.id.tvPressure)

            val temp1: Double = Math.round((weather.main_desc.temp - 273.15) * 100.0) / 100.0
            val temp_f: Double = Math.round((weather.main_desc.feels_like - 273.15) * 100.0) / 100.0

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

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        progressBar = view.findViewById(R.id.progressBar)
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