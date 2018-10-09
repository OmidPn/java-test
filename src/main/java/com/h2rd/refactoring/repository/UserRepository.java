package com.h2rd.refactoring.repository;

import com.j2rd.refactoring.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long>
{
    User findUserByName(final String name);
}