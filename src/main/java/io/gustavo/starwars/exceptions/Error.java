package io.gustavo.starwars.exceptions;

import java.io.Serializable;

public class Error implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2234557702178066039L;
	private String message;

	public Error(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
