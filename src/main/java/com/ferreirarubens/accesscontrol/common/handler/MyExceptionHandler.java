package com.ferreirarubens.accesscontrol.common.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ferreirarubens.accesscontrol.common.handler.exceptions.AccessException;
import com.ferreirarubens.accesscontrol.common.handler.exceptions.AccessException.ERROR_CODE;
import com.ferreirarubens.accesscontrol.common.handler.exceptions.BaseException;
import com.ferreirarubens.accesscontrol.common.handler.exceptions.ValidationException;
import com.ferreirarubens.accesscontrol.common.handler.exceptions.validation.ErrorValidationException;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	protected ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {
		ErrorValidationException error = new ErrorValidationException("InvalidRequest", e.getMessage(),
				(ValidationException) e);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<Object> accessDeniedException(RuntimeException e, WebRequest request) {
		BaseException error = new AccessException("Forbidden", "Access Denied", HttpStatus.FORBIDDEN.value(), ERROR_CODE.FORBIDEN);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(e, error, headers, HttpStatus.FORBIDDEN, request);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseException exception(Exception e) {
		e.printStackTrace();
		return new BaseException(e, e.toString());
	}
	
}