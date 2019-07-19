package com.fsl.jpa.service.impl;

import com.fsl.jpa.dto.Employee;
import com.fsl.jpa.mapper.EmployeeMapper;
import com.fsl.jpa.service.EmployeeMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employee_service1")
@Transactional
public class EmployeeMybatisServiceImpl implements EmployeeMybatisService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Long saveEmployee(Employee employee) {
        return employeeMapper.saveEmployee(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.get(id);
    }

    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

}
