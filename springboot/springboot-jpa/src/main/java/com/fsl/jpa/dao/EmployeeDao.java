package com.fsl.jpa.dao;

import com.fsl.jpa.dto.Employee;
import com.fsl.jpa.service.EmployeeMybatisService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee,Long>,EmployeeMybatisService {
}
