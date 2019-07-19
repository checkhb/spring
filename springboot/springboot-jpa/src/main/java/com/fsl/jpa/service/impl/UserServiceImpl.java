package com.fsl.jpa.service.impl;

import com.fsl.jpa.dao.UserDao;
import com.fsl.jpa.dto.UserDto;
import com.fsl.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(UserDto userDto) {
        userDao.save(userDto);
    }

    @Override
    public UserDto get(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void update(Long id) {
        UserDto userDto = userDao.findById(id).get();
        userDto.setName("刘德华");
        userDao.save(userDto);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
