/**
 * 
 */
package com.ferreirarubens.accesscontrol.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreirarubens.accesscontrol.model.User;
import com.ferreirarubens.accesscontrol.model.enums.ProfileCategoryEnum;

/**
 * @author rubens.ferreira
 *
 */
public interface IUserDAO extends JpaRepository<User, Serializable> {

	User findByLoginAndPassword(String login, String password);
	
	User findByLogin(String login);
	
	List<User> findByLoginContainsIgnoreCaseAndProfileProfileTypeCategory(String login, ProfileCategoryEnum type);
	
	List<User> findAllByOrderByNameAsc();
	
}
