package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.common.model.ProfileType;

/**
 * @author rubens.ferreira
 *
 */
public interface IProfileTypeService extends IService<ProfileType>{
	
	List<ProfileType> findAllByOrderByNameAsc();
	
}
