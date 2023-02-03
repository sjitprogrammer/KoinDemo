package com.aodev.koindemo.data

import com.aodev.koindemo.domain.WeatherRepository
import com.aodev.koindemo.domain.request.WeatherBody
import com.aodev.koindemo.domain.response.Weather
import retrofit2.Response

class WeatherRepositoryImpl constructor(private val service: WeatherService) : WeatherRepository {
    override suspend fun getWeather(cityName: String, appid: String, units: String) : Response<Weather> {
       return service.getCurrentWeather(cityName, appid, units)
    }
}