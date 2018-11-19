package com.ferreirarubens.accesscontrol.services.interfaces;

import java.util.List;

import com.ferreirarubens.accesscontrol.model.GenericEntity;

/**
 * @author rubens_ferreira
 *
 */
public interface IService<T extends GenericEntity> {

	T save(T t);
	
	List<T> save(List<T> tList);

	boolean delete(T t);

	T findById(Integer id);

	void deleteAll();

	long count();

	List<T> findAll();

	boolean deleteById(Integer id);
}
