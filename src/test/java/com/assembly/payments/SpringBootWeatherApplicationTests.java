package com.assembly.payments;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.assembly.payments.model.response.WeatherDTO;
import com.assembly.payments.model.response.WeatherDetails;
import com.assembly.payments.service.remote.WeatherDao;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootWeatherApplicationTests {

//  @Autowired
//  TestRestTemplate restTemplate;
//
//  
//  @Autowired
//  WeatherDao weatherDao;
//
//  @Autowired
//  CacheManager cm;
//
//  private WeatherDTO weather;
//
//  @Before
//  public void init() {
//	weather = weatherDao.saveWeather(new WeatherDetails());
//    clearAllCaches();
//  }
//
//  @Test
//  public void cacheTest() {
//
//    weather = weatherDao.findWeatherByCityName("melboune");
//    assertNotNull("temperature should be present for a city", weather.getTemperature_degrees());
//    assertNotNull("wind speed should be present for a city", weather.getWind_speed());
//   
//  }
//
//  private void clearAllCaches() {
//    Optional.of(cm.getCache("weather")).ifPresent(Cache::clear);
//  }

}

