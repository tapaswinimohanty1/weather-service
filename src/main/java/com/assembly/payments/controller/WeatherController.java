package com.assembly.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assembly.payments.model.request.Weather;
import com.assembly.payments.model.response.WeatherDTO;
import com.assembly.payments.service.WeatherService;

@RestController
@RequestMapping("/v1")
public class WeatherController {

  @Autowired	
  private WeatherService weatherService;

  @GetMapping("/weather")
  //@ResponseBody
  public ResponseEntity<WeatherDTO> weatherDetails(@RequestParam(defaultValue = "melboune") String city,@RequestParam(defaultValue = "m") String unitOfMetrics) {
	  Weather weather = new Weather(city,unitOfMetrics);
	  WeatherDTO weatherDetails = weatherService.getWeatherDetails(weather);
    return ResponseEntity.ok(weatherDetails);
  }

}
