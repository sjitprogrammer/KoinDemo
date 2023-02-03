package com.aodev.koindemo.data

import com.aodev.koindemo.domain.request.WeatherBody
import com.aodev.koindemo.domain.response.Weather
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") appid: String,
        @Query("units") units: String): Response<Weather>
}