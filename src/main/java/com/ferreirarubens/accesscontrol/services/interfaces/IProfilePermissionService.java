package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.common.model.ProfilePermission;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface IProfilePermissionService extends IService<ProfilePermission>{
	
	List<ProfilePermission> getByProfile(Integer profileId);
	
}
