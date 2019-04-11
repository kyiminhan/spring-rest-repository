package com.kyiminhan.mm.spring.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kyiminhan.mm.spring.entity.User;

@Repository
@Qualifier(value = "userRepository")
public interface UserRepository extends BaseRepository<User> {

}