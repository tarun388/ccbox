package com.verma.tarun.ccbox.repository;

import org.springframework.data.repository.CrudRepository;

import com.verma.tarun.ccbox.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
