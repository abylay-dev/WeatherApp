package kz.example.weatherapprestapi.fragments.weather_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kz.example.weatherapprestapi.R
import kz.example.weatherapprestapi.models.Weather
import kz.example.weatherapprestapi.network.API_KEY
import kz.example.weatherapprestapi.network.NetworkSetuper
import kz.example.weatherapprestapi.network.WeatherApi

class WeatherViewModel(
    private val city: String
): ViewModel() {

    private var weather_api: WeatherApi = NetworkSetuper.weatherApi
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val currentWeather: MutableLiveData<Weather> = MutableLiveData()
    fun observeCurrentWeather(): LiveData<Weather> = currentWeather

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun observeIsLoadingState(): LiveData<Boolean> = isLoading

    init {
        getWeather()
    }

    private fun getWeather(){
        isLoading.postValue(true)
        val disposable = Single.fromCallable {
                weather_api.getWeather(city, API_KEY)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                //TODO:
                currentWeather.postValue(it)
                isLoading.postValue(false)
            }, {
                isLoading.postValue(false)
            })
        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}