package com.fsl.jpa.service;

import com.fsl.jpa.dto.City;

public interface CityService {

    void save(City city);

    City get(Long id);

    void update(Long id);

    void delete(Long id);
}
