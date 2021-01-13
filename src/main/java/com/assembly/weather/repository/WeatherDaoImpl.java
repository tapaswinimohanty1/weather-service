package com.assembly.weather.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.assembly.weather.model.response.WeatherDTO;
import com.assembly.weather.model.response.WeatherDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by OmiD.HaghighatgoO on 8/21/2019.
 */

@Repository
public class WeatherDaoImpl implements WeatherDao {
	
	private static final String KEY = "weather";

	
    @Autowired
    RedisTemplate<String,WeatherDTO> redisTemplate;

	@Override
	public WeatherDTO saveWeather(WeatherDetails weatherDetails) {
		WeatherDTO newWeatherData = new WeatherDTO(weatherDetails.getCurrent().getWind_speed(),
				weatherDetails.getCurrent().getTemperature(), weatherDetails.getLocation().getLocaltime());
		try {
			Map userHash = new ObjectMapper().convertValue(newWeatherData, Map.class);
			redisTemplate.opsForHash().put(KEY, weatherDetails.getLocation().getName(), userHash);

		} catch (Exception e) {
			return newWeatherData;
		}
		return newWeatherData;
	}

	@Override
	public WeatherDTO findWeatherByCityName(String cityName) {
		Map weatherMap = (Map) redisTemplate.opsForHash().get(KEY, cityName);
		WeatherDTO weatherData = new ObjectMapper().convertValue(weatherMap, WeatherDTO.class);
		return weatherData;
	}

}
