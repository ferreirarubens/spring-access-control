package com.ferreirarubens.accesscontrol.common.handler.exceptions.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ferreirarubens.accesscontrol.common.handler.exceptions.BaseException;
import com.ferreirarubens.accesscontrol.common.handler.exceptions.ValidationException;

/**
 * Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@JsonPropertyOrder({"errorType", "message", "code", "fieldErrors"})
public class ErrorValidationException extends BaseException {

	private static final long serialVersionUID = -8770041816606906450L;
	private String code;
	private List<FieldErrorResource> fieldErrors;

	@SuppressWarnings("unchecked")
	public ErrorValidationException(String code, String message, ValidationException exception) {
		super(null, message);
		this.code = code;
		setErrorType(ERROR_TYPE.VALIDATION);

		List<FieldErrorResource> fieldErrorResources = new ArrayList<FieldErrorResource>();
		List<FieldError> listErrors = (List<FieldError>)(List<?>) exception.getErrors().getAllErrors();
		listErrors.forEach(fieldError -> {
			FieldErrorResource fieldErrorResource = new FieldErrorResource();
			fieldErrorResource.setResource(fieldError.getObjectName());
			fieldErrorResource.setField(fieldError.getField());
			fieldErrorResource.setCode(fieldError.getCode());
			fieldErrorResource.setMessage(fieldError.getDefaultMessage());
			fieldErrorResources.add(fieldErrorResource);
		});
		setFieldErrors(fieldErrorResources);
	}
	
	@JsonIgnore
	@Override
	public Throwable getException() {
		return super.getException();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<FieldErrorResource> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}