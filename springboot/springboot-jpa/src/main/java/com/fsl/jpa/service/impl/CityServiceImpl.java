package com.fsl.jpa.service.impl;

import com.fsl.jpa.dao.CityDao;
import com.fsl.jpa.dto.City;
import com.fsl.jpa.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public void save(City city) {
        cityDao.save(city);
    }

    @Override
    public City get(Long id) {
        return cityDao.getOne(id);
    }

    @Override
    public void update(Long id) {
        City one = cityDao.getOne(id);
        one.setName("广东省广州市花都区");
        cityDao.save(one);
    }

    @Override
    public void delete(Long id) {
        cityDao.deleteById(id);
    }
}
