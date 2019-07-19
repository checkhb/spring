package com.fsl.springbootsingledruid.controller;


import cn.hutool.core.util.RandomUtil;
import com.fsl.springbootsingledruid.dto.Student;
import com.fsl.springbootsingledruid.service.StudentService;
import com.fsl.springbootsingledruid.util.ServiceResult;
import com.fsl.springbootsingledruid.util.SnowFlakeWorker;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 学生前端控制器
 * @author 2019年4月12日16:23:12
 */
@Controller
@RequestMapping("/student")
@Slf4j(topic = "StudentController log")
public class StudentController {

    @Autowired
    private SnowFlakeWorker snowFlakeWorker;

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/insert")
    public ServiceResult insert(){
        try {
            List<String> list = Stream.of("kobe","james","steve","wade","anthnoy","druant").collect(Collectors.toList());
            List<Student> students = Lists.newArrayList();
            for(int i=0;i<100;i++){
                Student student = new Student();
                student.setId(snowFlakeWorker.nextId());
                student.setName(RandomUtil.randomEle(list));
                student.setAge(18);
                student.setAddress("广东省广州市");
                student.setEmail("123456@qq.com");
                students.add(student);
            }
            studentService.batchInsert(students);
            return ServiceResult.success("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            log.info("批量插入用户系统异常");
            return ServiceResult.failure("400","批量插入用户系统异常");
        }
    }


    @ResponseBody
    @RequestMapping("/get/{page}/{pageSize}")
    public ServiceResult get(@PathVariable int page, @PathVariable int pageSize){
        return ServiceResult.success(studentService.pagingSelect(page,pageSize));
    }

    @ResponseBody
    @RequestMapping("/update/{id}")
    public ServiceResult update(@PathVariable Long id){
        Student student = new Student();
        student.setId(id);
        student.setName("刘德华");
        studentService.updateByPrimaryKey(student);
        return ServiceResult.success("更新成功");
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public ServiceResult delete(@PathVariable Long id){
        studentService.deleteByPrimaryKey(id);
        return ServiceResult.success("删除成功");
    }




}
