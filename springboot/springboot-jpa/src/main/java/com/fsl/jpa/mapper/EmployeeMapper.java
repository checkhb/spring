package com.fsl.jpa.mapper;

import com.fsl.jpa.dto.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmployeeMapper {

    Long saveEmployee(Employee employee);

    Employee get(Long id);

    void delete(Long id);

    void update(Employee employee);
}
