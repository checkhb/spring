package com.fsl.springboothikari.controller;

import com.fsl.springboothikari.dto.ServiceResult;
import com.fsl.springboothikari.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 学生前端控制器
 * @author 2019年6月25日09:27:05
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/listStudent")
    public ServiceResult listStudent(){
        return ServiceResult.success(studentService.selectByPrimaryKey(996018439061505L));
    }

}
