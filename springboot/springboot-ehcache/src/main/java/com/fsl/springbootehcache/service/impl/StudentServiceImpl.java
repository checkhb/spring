package com.fsl.springbootehcache.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fsl.springbootehcache.entity.Student;
import com.fsl.springbootehcache.mapper.StudentMapper;
import com.fsl.springbootehcache.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
