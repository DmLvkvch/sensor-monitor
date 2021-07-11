package com.example.backend.data.repository;

import com.example.backend.data.entities.User;

public interface UserRepository {
    User findByUsername(String username);
}
