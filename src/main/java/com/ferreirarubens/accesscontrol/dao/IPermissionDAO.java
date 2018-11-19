package com.ferreirarubens.accesscontrol.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreirarubens.accesscontrol.model.Permission;

/**
 * @author Renatão
 *
 */
public interface IPermissionDAO extends JpaRepository<Permission, Serializable> {

	Permission findByName(String name);

}
