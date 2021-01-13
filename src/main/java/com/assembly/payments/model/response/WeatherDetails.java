package com.assembly.payments.model.response;

import java.io.Serializable;

public class WeatherDetails implements Serializable {

	private static final long serialVersionUID = 1567307654214654447L;

	private Location location;
	private CurrentWeather current;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CurrentWeather getCurrent() {
		return current;
	}

	public void setCurrent(CurrentWeather current) {
		this.current = current;
	}
	
	

}
