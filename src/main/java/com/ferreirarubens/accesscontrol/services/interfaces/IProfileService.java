package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.common.model.Profile;

/**
 * @author rubens.ferreira
 *
 */
public interface IProfileService extends IService<Profile>{
	
	List<Profile> getByNameContainsIgnoreCase(String name);
	
}
