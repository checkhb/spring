package com.fsl.springboothikari.mapper;


import com.fsl.springboothikari.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author 2019年5月9日16:31:09
 */
@Repository
public interface StudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int getCount();

    void batchInsert(List<Student> students);

    List<Student> selectAll();
}
