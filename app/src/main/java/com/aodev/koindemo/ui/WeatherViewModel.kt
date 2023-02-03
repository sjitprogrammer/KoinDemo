package com.aodev.koindemo.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aodev.koindemo.domain.WeatherRepository
import com.aodev.koindemo.domain.request.WeatherBody
import com.aodev.koindemo.domain.response.Weather
import com.aodev.koindemo.utils.Constants
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _response = MutableLiveData<Weather>()
    val weatherResponse: LiveData<Weather>
        get() = _response

    init {
        getWeather("japan")
    }

    private fun getWeather(city: String) = viewModelScope.launch {
//        val weatherBody : WeatherBody = WeatherBody(city,Constants.API_KEY,Constants.UNIT)
//        Log.e("WeatherViewModel","${weatherBody.toString()}")
        repository.getWeather(city,Constants.API_KEY,Constants.UNIT).let { response ->
            _response.postValue(response.body())
        }
    }

}