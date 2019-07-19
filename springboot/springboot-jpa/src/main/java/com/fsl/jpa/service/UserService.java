package com.fsl.jpa.service;

import com.fsl.jpa.dto.UserDto;

public interface UserService {

    void save(UserDto userDto);

    UserDto get(Long id);

    void update(Long id);

    void delete(Long id);
}
