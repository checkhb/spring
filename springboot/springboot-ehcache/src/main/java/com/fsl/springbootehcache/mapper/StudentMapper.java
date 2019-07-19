package com.fsl.springbootehcache.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fsl.springbootehcache.entity.Student;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author sj2
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
