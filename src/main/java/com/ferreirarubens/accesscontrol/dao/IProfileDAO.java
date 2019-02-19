package com.ferreirarubens.accesscontrol.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreirarubens.accesscontrol.common.model.Profile;

/**
 * @author rubens.ferreira
 *
 */
public interface IProfileDAO extends JpaRepository<Profile, Serializable> {

	List<Profile> getByNameContainsIgnoreCase(String name);

}
