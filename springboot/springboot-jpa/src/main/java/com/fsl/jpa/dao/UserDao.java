package com.fsl.jpa.dao;

import com.fsl.jpa.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserDto,Long> {
}
