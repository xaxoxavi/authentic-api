package com.esliceu.dwes.authenticapi.repository;

import com.esliceu.dwes.authenticapi.domain.User;

import java.util.Collection;

public interface UserRepository {

    void addUser(User user);

    Collection<User> findAll();

    User findUserById(String userId);

}
