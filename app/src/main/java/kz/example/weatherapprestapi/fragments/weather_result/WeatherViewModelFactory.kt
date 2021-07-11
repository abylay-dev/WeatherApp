package kz.example.weatherapprestapi.fragments.weather_result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 7/11/21
 */

class WeatherViewModelFactory(
    private val cityName: String
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(cityName) as T
    }
}