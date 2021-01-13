package com.assembly.weather.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assembly.weather.exception.ResourceNotFoundException;
import com.assembly.weather.model.request.Weather;
import com.assembly.weather.model.response.WeatherDTO;
import com.assembly.weather.model.response.WeatherDetails;
import com.assembly.weather.repository.WeatherDao;

@Service
@ComponentScan(basePackages = { "com.assembly.weather.*" })
public class WeatherService {

	@Autowired
	private WeatherDao weatherDao;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${spring.redis.host}")
	String hostName;

	@Value("${spring.redis.port}")
	Integer port;

	@Value("${weatherURI}")
	private String weatherURI;

	@Value("${fallbackWeatherURI}")
	private String fallbackWeatherURI;

	@Value("${cacheTimeLimit}")
	private Integer ttl;

	@Value("${accessKey}")
	private String accessKey;

	public WeatherDTO getWeatherDetails(Weather weather) {
		WeatherDTO newWeatherData = null;
		WeatherDTO cachedWeather = weatherDao.findWeatherByCityName(weather.getCity());
		if (cachedWeather == null) {
			return invokeWeatherStack(weather);
		}
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dateTime = LocalDateTime.parse(cachedWeather.getLocaltime());
		if (Duration.between(dateTime, now).toMinutes() > ttl) {
			newWeatherData = invokeWeatherStack(weather);
			// check response
			if (newWeatherData != null) {
				return newWeatherData;
			} else {
				return cachedWeather;
			}
		}

		return cachedWeather;
	}

	private WeatherDTO invokeWeatherStack(Weather weather) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = weatherURI + "?access_key={accessKey}&query={city}&units={units}";

		// create headers
		HttpHeaders headers = new HttpHeaders();

		// set `Content-Type` and `Accept` headers
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// build the request
		HttpEntity request = new HttpEntity(headers);

		// make an HTTP GET request with headers
		ResponseEntity<WeatherDetails> response = restTemplate.exchange(uri, HttpMethod.GET, request,
				WeatherDetails.class, accessKey, weather.getCity(), weather.getUnitOfMetrics());
		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			WeatherDetails weatherDetails = response.getBody();
			WeatherDTO newWeatherData = weatherDao.saveWeather(weatherDetails);
			return newWeatherData;
		} else {
			throw new ResourceNotFoundException(WeatherDTO.class, weather.getCity());
		}
	}

}
