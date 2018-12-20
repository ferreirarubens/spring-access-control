package com.ferreirarubens.accesscontrol.common.handler.exceptions;

import org.springframework.validation.Errors;

/**
 * @author rubens_ferreira
 *
 */
@SuppressWarnings("serial")
public class ValidationException extends RuntimeException {

	private Errors result;

	public ValidationException(Errors result, String message) {
		super(message);
		this.result = result;
	}

	public Errors getErrors() {
		return result;
	}

}