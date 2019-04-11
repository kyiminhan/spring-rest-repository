package com.kyiminhan.mm.spring.service;

import java.io.Serializable;
import java.util.Collection;

public interface BaseService<T extends Serializable> extends Serializable {

	void save(T t);

	void upate(T t);

	void delete(T t);

	T findById(String id);

	T findByUuid(String uuid);

	Collection<T> findAll();
}