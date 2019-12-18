package com.kyiminhan.spring.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.spring.entity.Account;
import com.kyiminhan.spring.repository.AccountRepository;
import com.kyiminhan.spring.service.AccountService;

import lombok.Setter;

@Lazy
@Service
@Setter(onMethod = @__(@Autowired))
public class AccountServiceImpl implements AccountService {

	private AccountRepository accRepo;

	@Transactional(readOnly = true)
	@Override
	public Account findById(final Long id) {
		return this.accRepo.findById(id).orElse(null);
	}

	@Override
	public Collection<Account> findAll() {
		return this.accRepo.findAll();
	}

}
