package com.aidan.backend.service.impl;

import com.aidan.backend.dto.UserDto;
import com.aidan.backend.entity.User;
import com.aidan.backend.exceptions.ResourceNotFoundException;
import com.aidan.backend.mapper.UserMapper;
import com.aidan.backend.repository.UserRepository;
import com.aidan.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link UserService} interface for managing User
 * entities.
 * <p>
 * This service provides methods for creating, retrieving, updating, and
 * deleting users. It interacts with the {@link UserRepository} for database
 * operations and uses {@link UserMapper} for mapping between entity and DTO
 * objects.
 * </p>
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    /**
     * Repository for performing CRUD operations on User entities.
     */
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto createUser(final UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    /**
     * Finds a User by ID.
     * <p>
     * This is a helper method that retrieves a User from the database by
     * their ID. If the User is not found, it throws a
     * {@link ResourceNotFoundException}.
     * </p>
     *
     * @param pUserId the ID of the User to retrieve
     * @return the User entity found by the given ID
     * @throws ResourceNotFoundException if no User with the given ID exists
     */
    private User findUserById(final Long pUserId) {
        return userRepository.findById(pUserId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User with given id: "
                                        + pUserId + "does not exist"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto getUserById(final Long pUserId) {
        User user = findUserById(pUserId);
        return UserMapper.mapToUserDto(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto updateUser(final Long pUserId, final UserDto pUserDto) {
        User user = findUserById(pUserId);
        user.setName(pUserDto.getName());
        user.setEmail(pUserDto.getEmail());
        user.setNumberOfBottles(pUserDto.getNumberOfBottles());
        user.setAddress(pUserDto.getAddress());
        User updatedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(final Long pUserId) {
        User user = findUserById(pUserId);
        userRepository.delete(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer countUsers() {
        // todo: check which users are dropped off and add it
        // todo: count number of bottles for each user
        return (int) userRepository.count();
    }

}
