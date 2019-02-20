package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.common.model.User;
import com.ferreirarubens.accesscontrol.common.model.enums.ProfileCategoryEnum;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface IUserService extends IService<User> {

	User findByLoginAndPassword(String login, String password);
	
	User findByLogin(String login);
	
	List<User> findByLoginContainsAndTypeProfile(String login, ProfileCategoryEnum type);
	
	List<User> findAllByOrderByNameAsc();
	
}
