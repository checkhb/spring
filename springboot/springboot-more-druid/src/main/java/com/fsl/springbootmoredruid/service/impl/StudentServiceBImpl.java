package com.fsl.springbootmoredruid.service.impl;



import com.fsl.springbootmoredruid.dto.Student;
import com.fsl.springbootmoredruid.mapper.slave.StudentMapperB;
import com.fsl.springbootmoredruid.service.StudentServiceB;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceBImpl implements StudentServiceB {

    @Autowired
    private StudentMapperB studentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int getCount() {
        return studentMapper.getCount();
    }

    @Override
    public void batchInsert(List<Student> students) {
        studentMapper.batchInsert(students);
    }

    @Override
    public List<Student> pagingSelect(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return studentMapper.selectAll();
    }
}
