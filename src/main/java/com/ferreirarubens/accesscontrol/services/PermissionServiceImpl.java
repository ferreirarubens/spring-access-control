package com.ferreirarubens.accesscontrol.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferreirarubens.accesscontrol.dao.IPermissionDAO;
import com.ferreirarubens.accesscontrol.model.Permission;
import com.ferreirarubens.accesscontrol.services.interfaces.IPermissionService;

/**
 * @author Renatão
 *
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<Permission, IPermissionDAO> implements IPermissionService {

	@Autowired
	private IPermissionDAO dao;

	@Override
	public Permission findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public boolean nameIsUnique(long id, String name) {
		Permission permission = this.findByName(name);

		return Objects.nonNull(permission) ? (id == permission.getId()) : true;
	}

}
