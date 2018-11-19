package com.ferreirarubens.accesscontrol.services.interfaces;

import com.ferreirarubens.accesscontrol.model.Permission;

/**
 * @author Renatão
 *
 */
public interface IPermissionService extends IService<Permission>{
	
	Permission findByName(String name);
	
	boolean nameIsUnique(long id, String name);
	
}
