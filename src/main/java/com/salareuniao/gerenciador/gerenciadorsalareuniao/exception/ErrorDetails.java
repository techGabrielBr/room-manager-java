package com.salareuniao.gerenciador.gerenciadorsalareuniao.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String details;
	private String message;
	
	public ErrorDetails(Date timestamp, String details, String message) {
		super();
		this.details=details;
		this.message=message;
		this.timestamp=timestamp;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getDetails() {
		return details;
	}
	
	public String getMessage() {
		return message;
	}
	
}
