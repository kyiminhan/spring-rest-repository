package com.kyiminhan.mm.spring.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.mm.spring.repo.BaseRepository;
import com.kyiminhan.mm.spring.service.BaseService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends Serializable> implements BaseService<T> {

	private static final long serialVersionUID = 1L;

	@NonNull
	private final BaseRepository<T> repository;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void save(final T t) {
		this.repository.save(t);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void upate(final T t) {
		this.repository.save(t);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(final T t) {
		this.repository.delete(t);
	}

	@Transactional(readOnly = true)
	@Override
	public T findById(final String id) {
		return this.repository.findById(Long.valueOf(id)).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public T findByUuid(final String uuid) {
		return this.repository.findByUuid(uuid).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<T> findAll() {
		return this.repository.findAll();
	}
}