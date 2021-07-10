package com.example.backend.data.repository;

import com.example.backend.data.entities.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }
}
