package com.aodev.koindemo.di

import com.aodev.koindemo.data.WeatherRepositoryImpl
import com.aodev.koindemo.data.WeatherService
import com.aodev.koindemo.domain.WeatherRepository
import com.aodev.koindemo.ui.WeatherViewModel
import com.aodev.koindemo.utils.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }

    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    viewModel { WeatherViewModel(get()) }
}