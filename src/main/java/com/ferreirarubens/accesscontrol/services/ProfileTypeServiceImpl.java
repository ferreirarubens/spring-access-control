package com.ferreirarubens.accesscontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferreirarubens.accesscontrol.dao.IProfileTypeDAO;
import com.ferreirarubens.accesscontrol.model.ProfileType;
import com.ferreirarubens.accesscontrol.services.interfaces.IProfileTypeService;

/**
 * @author Renatão
 *
 */
@Service
@Transactional
public class ProfileTypeServiceImpl extends ServiceImpl<ProfileType, IProfileTypeDAO> implements IProfileTypeService {

	@Autowired
	private IProfileTypeDAO dao;

	@Override
	public List<ProfileType> findAllByOrderByNameAsc(){
		return dao.findAllByOrderByNameAsc();
	}

}
