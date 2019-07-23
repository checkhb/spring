package com.fsl.springboothikari.service;



import com.fsl.springboothikari.dto.Student;

import java.util.List;

public interface StudentService {

    /**
     * 通过JPA的方法进行调用
     * @param id
     * @return
     */
    public Student getById(Long id);


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
