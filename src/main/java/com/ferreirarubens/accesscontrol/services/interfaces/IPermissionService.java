package com.ferreirarubens.accesscontrol.services.interfaces;

import com.ferreirarubens.accesscontrol.common.model.Permission;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface IPermissionService extends IService<Permission>{
	
	Permission findByName(String name);
	
	boolean nameIsUnique(long id, String name);
	
}
