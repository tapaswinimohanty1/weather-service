package com.assembly.payments.model.response;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Weather")
public class WeatherDTO implements Serializable {

	private static final long serialVersionUID = 1567307654214654447L;
	private int wind_speed;
	private int temperature_degrees;
	private String localtime;

	

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

	public String getLocaltime() {
		return localtime;
	}

	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}

	public WeatherDTO() {
		super();
	}
	
	public WeatherDTO(int wind_speed, int temperature_degrees,String localtime) {
		super();
		this.wind_speed = wind_speed;
		this.temperature_degrees = temperature_degrees;
		this.localtime = localtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localtime == null) ? 0 : localtime.hashCode());
		result = prime * result + temperature_degrees;
		result = prime * result + wind_speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherDTO other = (WeatherDTO) obj;
		if (localtime == null) {
			if (other.localtime != null)
				return false;
		} else if (!localtime.equals(other.localtime))
			return false;
		if (temperature_degrees != other.temperature_degrees)
			return false;
		if (wind_speed != other.wind_speed)
			return false;
		return true;
	}

	

}
