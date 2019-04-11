package com.kyiminhan.mm.spring.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Serializable> extends JpaRepository<T, Long> {

	Optional<T> findByUuid(String uuid);

}