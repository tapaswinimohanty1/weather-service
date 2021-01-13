package com.assembly.payments.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
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

import com.assembly.payments.model.request.Weather;
import com.assembly.payments.model.response.WeatherDTO;
import com.assembly.payments.model.response.WeatherDetails;
import com.assembly.payments.service.remote.WeatherDao;

@Service
@ComponentScan(basePackages = { "com.assembly.payments.*" })
@PropertySource("classpath:config.properties")
public class WeatherService {


	@Autowired
	private WeatherDao weatherDao;

	@Autowired
	private RestTemplate restTemplate;

	@Value(value = "weatherURI")
	private String weatherURI;

	@Value(value = "fallbackWeatherURI")
	private String fallbackWeatherURI;

	@Value(value = "cacheTimeLimit")
	private int ttl;

	@Value(value = "accessKey")
	private String accessKey;

	@Cacheable(value = "weatherDetailsCache", key = "#weather.getCity()+weather.getUnitOfMetrics()", unless = "#result.followers < 12000")
	public WeatherDTO getWeatherDetails(Weather weather) {

		WeatherDTO cachedWeather = weatherDao.findWeatherByCityName(weather.getCity());
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dateTime = LocalDateTime.parse(cachedWeather.getLocaltime());
		if (Duration.between(dateTime, now).toMinutes() > ttl) {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "http://api.weatherstack.com/current" + "?access_key={accessKey}&query={city}&units={units}";

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
				return cachedWeather;
			}
		}

		return cachedWeather;
	}

}
