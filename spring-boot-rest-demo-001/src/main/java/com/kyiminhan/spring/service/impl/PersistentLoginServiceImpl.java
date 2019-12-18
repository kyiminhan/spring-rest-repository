package com.kyiminhan.spring.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.kyiminhan.spring.entity.PersistentLogins;
import com.kyiminhan.spring.repository.PersistentLoginsRepository;
import com.kyiminhan.spring.service.PersistentLoginService;

import lombok.Setter;

@Lazy
@Service
@Setter(onMethod = @__(@Autowired))
public class PersistentLoginServiceImpl implements PersistentLoginService {

	private PersistentLoginsRepository repository;

	@Override
	public Collection<PersistentLogins> findAll() {
		return this.repository.findAll();
	}

}
