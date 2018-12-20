package com.ferreirarubens.accesscontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferreirarubens.accesscontrol.dao.IProfilePermissionDAO;
import com.ferreirarubens.accesscontrol.model.ProfilePermission;
import com.ferreirarubens.accesscontrol.services.interfaces.IProfilePermissionService;

/**
 * @author rubens.ferreira
 *
 */
@Service
@Transactional
public class ProfilePermissionServiceImpl extends ServiceImpl<ProfilePermission, IProfilePermissionDAO> implements IProfilePermissionService {

	@Autowired
	private IProfilePermissionDAO dao;

	@Override
	public List<ProfilePermission> getByProfile(Integer profileId) {
		return dao.getByProfile(profileId);
	}
	
}
