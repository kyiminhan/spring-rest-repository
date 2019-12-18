package com.kyiminhan.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyiminhan.spring.entity.PersistentLogins;

@Repository
public interface PersistentLoginsRepository extends JpaRepository<PersistentLogins, String> {

}