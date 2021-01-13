package com.assembly.weather.model.response;

public class CurrentWeather {

    private String observation_time;
    private int temperature;
    private String weather_code;
    private int wind_speed;
    private String wind_degree;
    private String  wind_dir;
    private int pressure;
    
	public String getObservation_time() {
		return observation_time;
	}
	public void setObservation_time(String observation_time) {
		this.observation_time = observation_time;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getWeather_code() {
		return weather_code;
	}
	public void setWeather_code(String weather_code) {
		this.weather_code = weather_code;
	}
	public int getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(int wind_speed) {
		this.wind_speed = wind_speed;
	}
	public String getWind_degree() {
		return wind_degree;
	}
	public void setWind_degree(String wind_degree) {
		this.wind_degree = wind_degree;
	}
	public String getWind_dir() {
		return wind_dir;
	}
	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

    
}

