package com.fsl.springbootcacheredis.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fsl.springbootcacheredis.entity.Student;
import com.fsl.springbootcacheredis.mapper.StudentMapper;
import com.fsl.springbootcacheredis.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
