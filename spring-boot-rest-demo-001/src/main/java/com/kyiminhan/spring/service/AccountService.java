package com.kyiminhan.spring.service;

import java.util.Collection;

import com.kyiminhan.spring.entity.Account;

public interface AccountService {

	Account findById(Long id);

	Collection<Account> findAll();
}