package com.esliceu.dwes.authenticapi.repository;

import com.esliceu.dwes.authenticapi.domain.User;

import java.util.Set;

public interface UserRepository {

    void addUser(User user);

    Set<User> findAll();

    User findUserById(String userId);

}
