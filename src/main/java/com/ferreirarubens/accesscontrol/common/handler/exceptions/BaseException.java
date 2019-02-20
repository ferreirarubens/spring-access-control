package com.ferreirarubens.accesscontrol.common.handler.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@JsonPropertyOrder({"errorType", "message", "exception"})
public class BaseException implements Serializable {
	
	public enum ERROR_TYPE {
		GENERIC, VALIDATION, WEB, ACCESS
	}

	private static final long serialVersionUID = 1L;
	private Throwable exception;
	private String message;
	private ERROR_TYPE errorType = ERROR_TYPE.GENERIC;

	public BaseException(Throwable exception, String message) {
		this.exception = exception;
		this.message = message;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ERROR_TYPE getErrorType() {
		return errorType;
	}

	public void setErrorType(ERROR_TYPE errorType) {
		this.errorType = errorType;
	}

}
