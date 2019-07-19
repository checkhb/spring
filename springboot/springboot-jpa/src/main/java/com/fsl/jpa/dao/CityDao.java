package com.fsl.jpa.dao;

import com.fsl.jpa.dto.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City,Long> {
}
