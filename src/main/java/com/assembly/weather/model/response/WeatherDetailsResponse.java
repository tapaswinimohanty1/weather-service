package com.assembly.weather.model.response;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

public class WeatherDetailsResponse implements Serializable {

	private static final long serialVersionUID = 1567307654214654447L;
	private int wind_speed;
	private int temperature_degrees;

	

	public int getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(int wind_speed) {
		this.wind_speed = wind_speed;
	}

	public int getTemperature_degrees() {
		return temperature_degrees;
	}

	public void setTemperature_degrees(int temperature_degrees) {
		this.temperature_degrees = temperature_degrees;
	}

	

	public WeatherDetailsResponse() {
		super();
	}
	
	public WeatherDetailsResponse(int wind_speed, int temperature_degrees) {
		super();
		this.wind_speed = wind_speed;
		this.temperature_degrees = temperature_degrees;
	}

	

}
