package com.fsl.springboothikari.service.impl;



import com.fsl.springboothikari.dao.StudentDao;
import com.fsl.springboothikari.dto.Student;
import com.fsl.springboothikari.mapper.StudentMapper;
import com.fsl.springboothikari.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Long id) {
        return studentDao.findById(id).get();
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        studentDao.deleteById(id);
        //抛异常就会回滚
        //int j = 10/0;
        return 1;
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
