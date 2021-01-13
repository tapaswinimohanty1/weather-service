package com.assembly.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assembly.weather.model.response.WeatherDTO;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such resource")
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Class<WeatherDTO> clazz, String resourceId) {
		super(String.format("Resource '%s' with id '%s' does not exists", clazz.getSimpleName(), resourceId));
	}
}
