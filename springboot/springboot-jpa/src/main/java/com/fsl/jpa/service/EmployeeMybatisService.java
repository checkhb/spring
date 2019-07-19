package com.fsl.jpa.service;

import com.fsl.jpa.dto.Employee;

public interface EmployeeMybatisService {

    Long saveEmployee(Employee employee);

    Employee get(Long id);

    void delete(Long id);

    void update(Employee employee);
}
