package com.kyiminhan.spring.service;

import java.util.Collection;

import com.kyiminhan.spring.entity.PersistentLogins;

public interface PersistentLoginService {

	Collection<PersistentLogins> findAll();
}