package com.ferreirarubens.accesscontrol.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreirarubens.accesscontrol.common.model.ProfileType;
import com.ferreirarubens.accesscontrol.services.interfaces.IProfileTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@RestController
@RequestMapping("api/v1/profile-type")
@PreAuthorize("hasRole('ROLE_PROFILE')")
@Api(tags = { "Profile Types" })
public class ProfileTypeController {

	@Autowired
	private IProfileTypeService service;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_PROFILE_TYPE_READ')")
	@ApiOperation(value = "Find an Profile by ID")
	public ProfileType get(@PathVariable("id") long id) {
		return service.findById(id);
	}

	@GetMapping()
	@PreAuthorize("hasRole('ROLE_PROFILE_TYPE_READ')")
	@ApiOperation(value = "Retrieve all Profiles")
	public List<ProfileType> getAll() {
		return service.findAll();
	}
}
