package com.assembly.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assembly.weather.model.request.Weather;
import com.assembly.weather.model.response.WeatherDTO;
import com.assembly.weather.model.response.WeatherDetailsResponse;
import com.assembly.weather.service.WeatherService;

@RestController
@RequestMapping("/v1")
public class WeatherController {

  @Autowired	
  private WeatherService weatherService;

  @GetMapping("/weather")
  //@ResponseBody
  public ResponseEntity<WeatherDetailsResponse> weatherDetails(@RequestParam(defaultValue = "Melbourne​") String city,@RequestParam(defaultValue = "m") String unitOfMetrics) {
	  Weather weather = new Weather(city,unitOfMetrics);
	  WeatherDTO weatherDetails = weatherService.getWeatherDetails(weather);
    return ResponseEntity.ok(new WeatherDetailsResponse(weatherDetails.getWind_speed(),weatherDetails.getTemperature_degrees()));
  }

}
