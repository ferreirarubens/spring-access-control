package com.ferreirarubens.accesscontrol.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreirarubens.accesscontrol.common.model.ProfileType;

/**
 * @author rubens.ferreira
 *
 */
public interface IProfileTypeDAO extends JpaRepository<ProfileType, Serializable> {
	
	List<ProfileType> findAllByOrderByNameAsc();

}
