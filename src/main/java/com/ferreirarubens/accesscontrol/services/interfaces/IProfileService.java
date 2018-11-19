package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.model.Profile;

/**
 * @author Renatão
 *
 */
public interface IProfileService extends IService<Profile>{
	
	List<Profile> getByNameContainsIgnoreCase(String name);
	
}
