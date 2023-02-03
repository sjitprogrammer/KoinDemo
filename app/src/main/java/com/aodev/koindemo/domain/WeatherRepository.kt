package com.aodev.koindemo.domain

import com.aodev.koindemo.domain.request.WeatherBody
import com.aodev.koindemo.domain.response.Weather
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeather(cityName: String, appid: String, units: String):Response<Weather>
}