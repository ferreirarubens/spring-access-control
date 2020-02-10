/**
 * 
 */
package com.ferreirarubens.accesscontrol.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ferreirarubens.accesscontrol.common.model.Profile;
import com.ferreirarubens.accesscontrol.services.interfaces.IProfileService;
import com.ferreirarubens.accesscontrol.web.validator.ProfileValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@RestController
@RequestMapping("api/v1/profile")
@PreAuthorize("hasRole('ROLE_PROFILE')")
@Api(tags = { "Profiles" })
public class ProfileController {

	@Autowired
	private IProfileService service;

	@Autowired
	private ProfileValidator validator;

	@InitBinder
	protected void initiBinder(WebDataBinder binder, HttpServletRequest request) {
		validator.setMethod(RequestMethod.valueOf(request.getMethod()));
		binder.addValidators(validator);
	}

	@PostMapping()
	@PreAuthorize("hasRole('ROLE_PROFILE_CREATE')")
	@ApiOperation(value = "Add an Profile")
	public Profile create(@RequestBody @Valid Profile profile, BindingResult result, HttpServletResponse response) {
		if (result.hasErrors()) {
			throw new ValidationException(result, "Error to Save Profile");
		}
		service.save(profile);
		return profile;
	}

	@PutMapping()
	@PreAuthorize("hasRole('ROLE_PROFILE_UPDATE')")
	@ApiOperation(value = "Update an Profile")
	public Profile update(@RequestBody @Valid Profile profile, BindingResult result, HttpServletResponse response) {
		if (result.hasErrors()) {
			throw new ValidationException(result, "Error to Update Profile");
		}
		service.save(profile);
		return profile;
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_PROFILE_READ')")
	@ApiOperation(value = "Find an Profile by ID")
	public Profile get(@PathVariable("id") long id) {
		return service.findById(id);
	}

	@GetMapping()
	@PreAuthorize("hasRole('ROLE_PROFILE_READ')")
	@ApiOperation(value = "Retrieve all Profiles")
	public List<Profile> getAll() {
		return service.findAll();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_PROFILE_DELETE')")
	@ApiOperation(value = "Delete an Profile by ID")
	public boolean delete(@PathVariable("id") long id) {
		return service.deleteById(id);
	}
}
