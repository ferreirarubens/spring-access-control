package com.ferreirarubens.accesscontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferreirarubens.accesscontrol.dao.IUserDAO;
import com.ferreirarubens.accesscontrol.model.User;
import com.ferreirarubens.accesscontrol.model.enums.ProfileCategoryEnum;
import com.ferreirarubens.accesscontrol.services.interfaces.IUserService;

/**
 * @author rubens_ferreira
 *
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<User, IUserDAO> implements IUserService {

	@Autowired
	private IUserDAO dao;
	
	@Override
	public User findByLoginAndPassword(String login, String password) {
		return dao.findByLoginAndPassword(login, password);
	}

	@Override
	public User findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Override
	public List<User> findByLoginContainsAndTypeProfile(String login, ProfileCategoryEnum type) {
		return dao.findByLoginContainsIgnoreCaseAndProfileProfileTypeCategory(login, type);
	}

	@Override
	public List<User> findAllByOrderByNameAsc(){
		return dao.findAllByOrderByNameAsc();
	}
	
}
