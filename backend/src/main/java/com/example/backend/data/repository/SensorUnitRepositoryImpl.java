package com.example.backend.data.repository;

import com.example.backend.data.entities.SensorUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SensorUnitRepositoryImpl implements SensorUnitRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<SensorUnit> findAll() {
        return getSession().createQuery("select p from SensorUnit p", SensorUnit.class).list();
    }
}
