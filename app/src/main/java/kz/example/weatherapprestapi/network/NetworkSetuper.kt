package kz.example.weatherapprestapi.network

import com.jaredsburrows.retrofit2.adapter.synchronous.SynchronousCallAdapterFactory
import kz.example.weatherapprestapi.wInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkSetuper {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org/")
        .client(
            OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(SynchronousCallAdapterFactory.create())
        .build()

    val weatherApi: wInterface = retrofit.create(wInterface::class.java)
}