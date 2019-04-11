package com.kyiminhan.mm.spring.service;

import com.kyiminhan.mm.spring.entity.User;

/**
 * The Interface UserService.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.service </BR>
 *        UserService.java </BR>
 */
public interface UserService extends BaseService<User> {

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	boolean isEmpty();

	/**
	 * Inits the data insert.
	 */
	void initDataInsert();
}