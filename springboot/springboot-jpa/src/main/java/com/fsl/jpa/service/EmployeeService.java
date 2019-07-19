package com.fsl.jpa.service;

import com.fsl.jpa.dto.Employee;

public interface EmployeeService {

    Employee getById(Long id);

    void saveEmployee(Employee employee);

    Employee get(Long id);

    void delete(Long id);

    void update(Employee employee);

    Employee findById(Long id);

    boolean existsById(Long id);
}
