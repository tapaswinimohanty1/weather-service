package com.assembly.weather.repository;

import com.assembly.weather.model.response.WeatherDTO;
import com.assembly.weather.model.response.WeatherDetails;


public interface WeatherDao {

    public WeatherDTO findWeatherByCityName(String cityName) ;
	public WeatherDTO saveWeather(WeatherDetails weatherDetails);


}
