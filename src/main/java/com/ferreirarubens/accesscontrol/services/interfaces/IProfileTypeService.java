package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.common.model.ProfileType;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface IProfileTypeService extends IService<ProfileType>{
	
	List<ProfileType> findAllByOrderByNameAsc();
	
}
