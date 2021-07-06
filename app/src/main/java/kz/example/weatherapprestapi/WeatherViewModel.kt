package kz.example.weatherapprestapi

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kz.example.weatherapprestapi.models.Weather
import kz.example.weatherapprestapi.network.API_KEY
import kz.example.weatherapprestapi.network.NetworkSetuper

class WeatherViewModel: ViewModel() {
    private var weather_api: wInterface = NetworkSetuper.weatherApi
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val dataOfWeather = mutableListOf<Weather>()

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
                Thread.sleep(500L)
                weather_api.getWeather(R.id.tvCityName.toString(), API_KEY)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                //TODO:
                //dataOfWeather.addAll(it)
                //currentWeather.postValue(it[0])
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