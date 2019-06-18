package com.ferreirarubens.accesscontrol.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreirarubens.accesscontrol.common.model.Permission;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface IPermissionDAO extends JpaRepository<Permission, Serializable> {

	Permission findByName(String name);

}
