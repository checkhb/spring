package com.fsl.jpa.controller;

import com.alibaba.fastjson.JSON;
import com.fsl.jpa.dto.Employee;
import com.fsl.jpa.service.EmployeeService;
import com.fsl.jpa.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Autowired() 自动装配bean,属于spring，默认按照type进行注入
     * @Resource()  自动装配bean,属于J2EE，默认按照name进行注入
     * @Qualifier() 配合@Autowired()一起使用，装配指定名称的bean
     */
    @Autowired()
    private EmployeeService employeeService;

    @RequestMapping("/save")
    public ServiceResult save(){
        Employee employee = new Employee();
        employee.setAge(18);
        employee.setDesignation("Java开发工程师");
        employee.setName("thales");
        employee.setSalary(10000L);
        employeeService.saveEmployee(employee);
        return ServiceResult.success(employee);
    }


    @RequestMapping("/update/{id}")
    public ServiceResult update(@PathVariable Long id){
        Employee employee = employeeService.get(id);
        employee.setDesignation("Java劝退师");
        employeeService.update(employee);
        return ServiceResult.success(employee);
    }


    @RequestMapping("/delete/{id}")
    public ServiceResult delete(@PathVariable Long id){
        employeeService.delete(id);
        return ServiceResult.success("删除成功");
    }

    @RequestMapping("/get/{id}")
    public ServiceResult get(@PathVariable Long id){
        return ServiceResult.success( employeeService.get(id));
    }

    @RequestMapping("/test")
    public ServiceResult test(){
        Employee employee = new Employee();
        employee.setAge(28);
        employee.setDesignation("Java架构师");
        employee.setName("thales");
        employee.setSalary(9999L);
        employeeService.saveEmployee(employee);
        logger.info("第一步："+ JSON.toJSONString(employee));
        Employee employee1 = employeeService.findById(employee.getId());
        logger.info("第二步："+ JSON.toJSONString(employee1));
        boolean b = employeeService.existsById(employee.getId());
        logger.info("第三步："+ JSON.toJSONString(b));
        return ServiceResult.success(employee1);
    }

}
