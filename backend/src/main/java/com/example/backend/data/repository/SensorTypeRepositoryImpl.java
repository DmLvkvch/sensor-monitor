package com.example.backend.data.repository;

import com.example.backend.data.entities.SensorType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SensorTypeRepositoryImpl implements SensorTypeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<SensorType> findAll() {
        return getSession().createQuery("select p from SensorType p", SensorType.class).list();
    }
}
