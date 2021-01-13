package com.assembly.weather.model.request;

import java.io.Serializable;

public class Weather implements Serializable {

 
	private static final long serialVersionUID = 6581552497143218106L;
	private String unitOfMetrics;
	private String city;
	
	
	public Weather() {
		  
	}
    public Weather(String city, String unitOfMetrics) {
    	this.unitOfMetrics = unitOfMetrics;
    	this.city = city;
    }
	public String getUnitOfMetrics() {
		return unitOfMetrics;
	}
	public void setUnitOfMetrics(String unitOfMetrics) {
		this.unitOfMetrics = unitOfMetrics;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return "Weather [unitOfMetrics=" + unitOfMetrics + ", city=" + city + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((unitOfMetrics == null) ? 0 : unitOfMetrics.hashCode());
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
		Weather other = (Weather) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (unitOfMetrics == null) {
			if (other.unitOfMetrics != null)
				return false;
		} else if (!unitOfMetrics.equals(other.unitOfMetrics))
			return false;
		return true;
	}
  
  

  
}
