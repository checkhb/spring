package com.fsl.springbootcacheredis.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fsl.springbootcacheredis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 2019年5月9日16:31:09
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
