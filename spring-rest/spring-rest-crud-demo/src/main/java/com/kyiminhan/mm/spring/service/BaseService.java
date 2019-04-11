package com.kyiminhan.mm.spring.service;

import java.io.Serializable;
import java.util.Collection;

/**
 * The Interface BaseService.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @param <T> the generic type
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.service </BR>
 *        BaseService.java </BR>
 */
public interface BaseService<T extends Serializable> extends Serializable {

	/**
	 * Save.
	 *
	 * @param t the t
	 */
	void save(T t);

	/**
	 * Upate.
	 *
	 * @param t the t
	 */
	void upate(T t);

	/**
	 * Delete.
	 *
	 * @param t the t
	 */
	void delete(T t);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return T
	 */
	T findById(String id);

	/**
	 * Find by uuid.
	 *
	 * @param uuid the uuid
	 * @return T
	 */
	T findByUuid(String uuid);

	/**
	 * Find all.
	 *
	 * @return Collection
	 */
	Collection<T> findAll();
}