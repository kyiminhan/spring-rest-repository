package com.kyiminhan.mm.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.mm.spring.entity.User;
import com.kyiminhan.mm.spring.repo.BaseRepository;
import com.kyiminhan.mm.spring.repo.UserRepository;
import com.kyiminhan.mm.spring.service.UserService;

@Service
@Qualifier(value = "userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	private static final long serialVersionUID = 1L;

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(final BaseRepository<User> repository) {
		super(repository);
		this.userRepository = (UserRepository) repository;
	}

	@Transactional(readOnly = true)
	@Override
	public boolean isEmpty() {
		return (0 < this.userRepository.count()) ? false : true;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void initDataInsert() {
		for (int i = 1; i <= 100; i++) {
			final String firstName = "Kyi Min ";
			final String lastName = "Han " + i;
			final String email = "kyiminhan" + i + "@gmail.com";
			final String phone = "1234567890";
			final String address = "Tokyo, Japan.";
			this.userRepository.saveAndFlush(User.builder().firstName(firstName).lastName(lastName).email(email)
					.phone(phone).address(address).build());
		}
	}
}