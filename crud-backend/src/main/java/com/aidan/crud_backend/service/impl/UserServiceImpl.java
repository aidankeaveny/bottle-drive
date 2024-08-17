package com.aidan.crud_backend.service.impl;

import com.aidan.crud_backend.dto.UserDto;
import com.aidan.crud_backend.entity.User;
import com.aidan.crud_backend.exception.ResourceNotFoundException;
import com.aidan.crud_backend.mapper.UserMapper;
import com.aidan.crud_backend.repository.UserRepository;
import com.aidan.crud_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    private User findUserById(Long pUserId) {
        return userRepository.findById(pUserId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User with given id: "+ pUserId + "does not exist"));
    }

    @Override
    public UserDto getUserById(Long pUserId) {
        User user = findUserById(pUserId);
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long pUserId, UserDto pUserDto) {
        User user = findUserById(pUserId);
        user.setFirstName(pUserDto.getFirstName());
        user.setLastName(pUserDto.getLastName());
        user.setEmail(pUserDto.getEmail());
        User updatedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long pUserId) {
        User user = findUserById(pUserId);
        userRepository.delete(user);
    }

}
