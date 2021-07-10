package com.example.backend.data.repository;

import com.example.backend.data.entities.User;

public interface UserRepository {

    void save(User user);

    User findByUsername(String username);

}
