package com.fsl.jpa.service.impl;

import com.fsl.jpa.dao.EmployeeDao;
import com.fsl.jpa.dto.Employee;
import com.fsl.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 通过JPA的方法进行调用
     * @param id
     * @return
     */
    @Override
    public Employee getById(Long id) {
        return employeeDao.findById(id).get();
    }


    /**
     * 通过mybatis的方式进行调用
     * @param employee
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeDao.get(id);
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeDao.findById(id).get();
    }

    @Override
    public boolean existsById(Long id) {
        return employeeDao.existsById(id);
    }
}
