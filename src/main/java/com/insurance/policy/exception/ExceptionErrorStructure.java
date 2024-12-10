package com.insurance.policy.exception;

import org.springframework.http.HttpStatus;

public class ExceptionErrorStructure {
	
	private HttpStatus status;
	private String message;
	private String details;

	public ExceptionErrorStructure(HttpStatus status, String message, String details) {
		this.setStatus(status);
		this.setMessage(message);
		this.setDetails(details);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
