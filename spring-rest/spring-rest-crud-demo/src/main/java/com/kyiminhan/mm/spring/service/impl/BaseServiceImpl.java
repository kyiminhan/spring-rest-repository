package com.kyiminhan.mm.spring.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.mm.spring.repo.BaseRepository;
import com.kyiminhan.mm.spring.service.BaseService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Instantiates a new base service impl.
 *
 * @param repository the repository
 */
@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends Serializable> implements BaseService<T> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The repository. */
	@NonNull
	private final BaseRepository<T> repository;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.mm.spring.service.BaseService#save(java.io.Serializable)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void save(final T t) {
		this.repository.save(t);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.mm.spring.service.BaseService#upate(java.io.Serializable)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void upate(final T t) {
		this.repository.save(t);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.mm.spring.service.BaseService#delete(java.io.Serializable)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(final T t) {
		this.repository.delete(t);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.mm.spring.service.BaseService#findById(java.lang.String)
	 */
	@Transactional(readOnly = true)
	@Override
	public T findById(final String id) {
		return this.repository.findById(Long.valueOf(id)).orElse(null);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.mm.spring.service.BaseService#findByUuid(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public T findByUuid(final String uuid) {
		return this.repository.findByUuid(uuid).orElse(null);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.mm.spring.service.BaseService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public Collection<T> findAll() {
		return this.repository.findAll();
	}
}