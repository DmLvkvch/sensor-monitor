package com.example.backend.data.repository;

import com.example.backend.data.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        getSession().save(user);
    }

    @Override
    public User findByUsername(String username) {
        return getSession().createQuery(
                "from USERS where username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();
    }
}
