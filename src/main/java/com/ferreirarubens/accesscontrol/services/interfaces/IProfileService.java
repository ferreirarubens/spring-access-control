package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.common.model.Profile;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface IProfileService extends IService<Profile>{
	
	List<Profile> getByNameContainsIgnoreCase(String name);
	
}
