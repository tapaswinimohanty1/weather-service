package com.assembly.weather.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "No such resource")
public class RepositoryException extends RuntimeException {

	private static final long serialVersionUID = 4723486783571238367L;

	public RepositoryException(String message) {
		super(message);
	}
}
