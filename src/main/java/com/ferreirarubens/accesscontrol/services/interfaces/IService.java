package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.common.model.GenericEntity;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface IService<T extends GenericEntity> {

	T save(T t);
	
	List<T> save(List<T> tList);

	boolean delete(T t);

	T findById(long id);

	void deleteAll();

	long count();

	List<T> findAll();

	boolean deleteById(long id);
}
