/**
 * 
 */
package com.ferreirarubens.accesscontrol.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ferreirarubens.accesscontrol.common.handler.exceptions.ValidationException;
import com.ferreirarubens.accesscontrol.common.model.User;
import com.ferreirarubens.accesscontrol.services.interfaces.IUserService;
import com.ferreirarubens.accesscontrol.web.validator.UserValidator;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('ROLE_CARRO')")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private UserValidator validator;
	
	@InitBinder
	protected void initiBinder(WebDataBinder binder, HttpServletRequest request) {
		validator.setMethod(RequestMethod.valueOf(request.getMethod()));
		binder.addValidators(validator);
	}

	@PostMapping({ "", "/" })
	@PreAuthorize("hasRole('ROLE_USER_CREATE_OI')")
	public ResponseEntity<User> create(@RequestBody @Valid User user, BindingResult result,
			HttpServletResponse response) {
		if (result.hasErrors()) {
			throw new ValidationException(result, "Error to Save User");
		}
		service.save(user);
		return ResponseEntity.ok(user);
	}

	@PutMapping({ "", "/" })
	public void update(@RequestBody User user) {

	}

	@GetMapping("/{id}")
	public User get(@PathVariable("id") long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") long id) {
		return service.deleteById(id);
	}
}
