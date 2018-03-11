package com.konradszewczuk.weatherapp.ui

import android.arch.lifecycle.ViewModel
import com.konradszewczuk.weatherapp.data.repository.WeatherRepository

import javax.inject.Inject


class WeatherViewModel @Inject constructor(val weatherRepository: WeatherRepository) : ViewModel() {

    fun getWeather(cityName: String) = weatherRepository.getWeather(cityName)

    fun getCities() = weatherRepository.getCities()

    fun addCity(cityName: String) = weatherRepository.addCity(cityName)

}