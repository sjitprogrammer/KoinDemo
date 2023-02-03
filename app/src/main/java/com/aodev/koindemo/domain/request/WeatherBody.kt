package com.aodev.koindemo.domain.request

data class WeatherBody(
    val cityName: String,
    val appid: String,
    val units: String
)
