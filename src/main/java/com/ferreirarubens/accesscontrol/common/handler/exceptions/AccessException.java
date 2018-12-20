package com.ferreirarubens.accesscontrol.common.handler.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author rubens_ferreira
 *
 */
@JsonPropertyOrder({ "status", "error", "message", "code" })
public class AccessException extends BaseException {

	public enum ERROR_CODE {
		INVALID_TOKEN, INVALID_REFRESH_TOKEN, UNAUTHORIZED, FORBIDEN
	}

	private static final long serialVersionUID = -8770041816606906450L;
	private String error;
	private int status;
	private ERROR_CODE code;

	public AccessException(String error, String message, int status, ERROR_CODE code) {
		super(null, message);
		this.error = error;
		this.status = status;
		setErrorType(ERROR_TYPE.ACCESS);
		this.code = code;
	}

	@JsonIgnore
	@Override
	public Throwable getException() {
		return super.getException();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ERROR_CODE getCode() {
		return code;
	}

	public void setCode(ERROR_CODE code) {
		this.code = code;
	}

}