package com.aidan.crud_backend.service;

import com.aidan.crud_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto pUserDto);

    UserDto getUserById(Long pUserId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long pUserId, UserDto pUserDto);

    void deleteUser(Long pUserId);
}
