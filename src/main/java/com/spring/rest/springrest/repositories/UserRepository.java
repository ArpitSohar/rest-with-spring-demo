package com.spring.rest.springrest.repositories;

import com.spring.rest.springrest.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
