package com.ferreirarubens.accesscontrol.common.handler.exceptions.validation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author rubens_ferreira
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldErrorResource {
	
    private String resource;
	private String field;
	private String code;
	private String message;

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}