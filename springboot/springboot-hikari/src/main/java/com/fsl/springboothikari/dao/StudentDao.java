package com.fsl.springboothikari.dao;

import com.fsl.springboothikari.dto.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends CrudRepository<Student,Long> {
}
