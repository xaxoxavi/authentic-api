package com.esliceu.dwes.authenticapi.repository;

import com.esliceu.dwes.authenticapi.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<String,User> userMap = new HashMap<>();


    @Override
    public void addUser(User user) {
        userMap.put(user.getUserId(),user);
    }

    @Override
    public Set<User> findAll() {
        return (Set<User>) userMap.values();
    }

    @Override
    public User findUserById(String userId) {
        return userMap.get(userId);
    }
}
