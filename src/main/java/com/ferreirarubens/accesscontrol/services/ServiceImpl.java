package com.ferreirarubens.accesscontrol.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferreirarubens.accesscontrol.model.GenericEntity;
import com.ferreirarubens.accesscontrol.services.interfaces.IService;

/**
 * @author rubens_ferreira
 *
 */
@Service
@Transactional
public abstract class ServiceImpl<T extends GenericEntity, IDao extends CrudRepository<T, Serializable>> implements IService<T> {

	@Autowired
	private IDao dao;

	@Override
	public T save(T t) {
		return dao.save(t);
	}
	
	@Override
	public List<T> save(List<T> tList) {
		return (List<T>) dao.saveAll(tList);
	}

	@Override
	public boolean delete(T t) {
		dao.delete(t);
		return dao.findById(t.getId()) == null ? true : false;
	}

	@Override
	public T findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public List<T> findAll() {
		return (List<T>) dao.findAll();
	}

	@Override
	public boolean deleteById(Integer id) {
		dao.deleteById(id);
		return dao.findById(id) == null ? true : false;
	}

}
