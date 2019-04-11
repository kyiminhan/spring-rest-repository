package com.kyiminhan.mm.spring.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * The Interface BaseRepository.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @param <T> the generic type
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.repo </BR>
 *        BaseRepository.java </BR>
 */
@NoRepositoryBean
public interface BaseRepository<T extends Serializable> extends JpaRepository<T, Long> {

	/**
	 * Find by uuid.
	 *
	 * @param uuid the uuid
	 * @return Optional
	 */
	Optional<T> findByUuid(String uuid);
}