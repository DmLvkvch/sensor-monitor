package com.example.backend.services;

import com.example.backend.data.entities.Info;
import com.example.backend.data.entities.Sensor;
import com.example.backend.data.entities.SensorPage;
import com.example.backend.data.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    private final int pageSize = 4;

    @Override
    public SensorPage getDataByPage(int page, String pattern) {
        long count = sensorRepository.getCount(pattern);
        Info info = buildPageInfo(page, count);
        return new SensorPage(info, sensorRepository.findAll(page, pattern));
    }

    @Override
    public Sensor getDetails(Long id) {
        return sensorRepository.findById(id);
    }

    @Override
    public void update(Sensor sensor) {
        sensorRepository.update(sensor);
    }

    @Override
    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

    @Override
    public void add(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    private Info buildPageInfo(int page, long pageCount) {
        Info info = new Info();
        if (page == 1) {
            info.setPrev(null);
        } else {
            info.setPrev(String.valueOf(page - 1));
        }
        info.setCount(pageCount);
        long lastPage = (long) (Math.ceil((float) pageCount / pageSize));
        if (lastPage == page) {
            info.setNext(null);
        } else {
            info.setNext(String.valueOf(page + 1));
        }
        info.setPages(lastPage);
        return info;
    }
}
