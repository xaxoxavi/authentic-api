package com.esliceu.dwes.authenticapi.repository;

import com.esliceu.dwes.authenticapi.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<String,User> userMap = new HashMap<>();


    @Override
    public void addUser(User user) {
        userMap.put(user.getUserId(),user);
    }

    @Override
    public Collection<User> findAll() {
        return  userMap.values();
    }

    @Override
    public User findUserById(String userId) {
        return userMap.get(userId);
    }
}
