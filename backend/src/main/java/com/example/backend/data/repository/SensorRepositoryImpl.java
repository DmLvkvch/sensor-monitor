package com.example.backend.data.repository;

import com.example.backend.data.entities.Sensor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SensorRepositoryImpl implements SensorRepository {

    private final int pageSize = 4;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long getCount(String pattern) {
        if (pattern == null || pattern.equals("")) {
            String countQ = "Select count (f.id) from Sensor f";
            Query countQuery = getSession().createQuery(countQ);
            return (long) ((Long) countQuery.uniqueResult());
        }
        return getCountByFilter(pattern);
    }

    public long getCountByFilter(String pattern) {
        Query countQuery = getSession().createQuery("Select count (o.id) from Sensor o where o.type.name LIKE CONCAT('%',:pattern,'%')  " +
                "or o.unit.name LIKE CONCAT('%',:pattern,'%') or o.model LIKE CONCAT('%',:pattern,'%') " +
                "or o.location LIKE CONCAT('%',:pattern,'%') " +
                "or o.description LIKE CONCAT('%',:pattern,'%') " +
                "or o.name LIKE CONCAT('%',:pattern,'%') ");
        countQuery.setParameter("pattern", pattern);
        return (long) ((Long) countQuery.uniqueResult());
    }

    @Override
    public void save(Sensor sensor) {
        getSession().save(sensor);
    }

    @Override
    public void update(Sensor sensor) {
        getSession().merge(sensor);
    }


    @Override
    public List<Sensor> findAll(int page, String pattern) {
        if (pattern == null || pattern.equals("")) {
            List<Sensor> select_p_from_sensor_p = getSession().createQuery("select p from Sensor p", Sensor.class)
                    .setFirstResult((page - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
        }
        return findByFilter(page, pattern);
    }

    @Override
    public Sensor findById(Long id) {
        return getSession().createQuery(
                "from Sensor where id = :id", Sensor.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void deleteById(Long id) {
        getSession().createQuery("delete from Sensor where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Sensor> findByFilter(int page, String pattern) {
        Query<Sensor> q = getSession().createQuery("Select o from Sensor o where " +
                "o.type.name LIKE CONCAT('%',:pattern,'%')  " +
                "or o.unit.name LIKE CONCAT('%',:pattern,'%') " +
                "or o.model LIKE CONCAT('%',:pattern,'%') " +
                "or o.location LIKE CONCAT('%',:pattern,'%') " +
                "or o.description LIKE CONCAT('%',:pattern,'%') " +
                "or o.name LIKE CONCAT('%',:pattern,'%') ", Sensor.class);
        q.setParameter("pattern", pattern);
        return q.setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }
}
