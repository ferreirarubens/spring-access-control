package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.model.ProfilePermission;

/**
 * @author Renatão
 *
 */
public interface IProfilePermissionService extends IService<ProfilePermission>{
	
	List<ProfilePermission> getByProfile(Integer profileId);
	
}