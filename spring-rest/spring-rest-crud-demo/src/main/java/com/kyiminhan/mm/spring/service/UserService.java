package com.kyiminhan.mm.spring.service;

import com.kyiminhan.mm.spring.entity.User;

public interface UserService extends BaseService<User> {

	boolean isEmpty();

	void initDataInsert();

}
