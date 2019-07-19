package com.fsl.springbootmoredruid.service;



import com.fsl.springbootmoredruid.dto.Student;

import java.util.List;

public interface StudentServiceB {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int getCount();

    void batchInsert(List<Student> students);

    List<Student> pagingSelect(int page, int pageSize);
}
