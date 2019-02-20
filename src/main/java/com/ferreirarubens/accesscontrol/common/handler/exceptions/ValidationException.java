package com.ferreirarubens.accesscontrol.common.handler.exceptions;

import org.springframework.validation.Errors;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
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