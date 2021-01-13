package com.assembly.payments.service.remote;

import com.assembly.payments.model.response.WeatherDTO;
import com.assembly.payments.model.response.WeatherDetails;


public interface WeatherDao {

    public WeatherDTO findWeatherByCityName(String cityName) ;
	public WeatherDTO saveWeather(WeatherDetails weatherDetails);


}
