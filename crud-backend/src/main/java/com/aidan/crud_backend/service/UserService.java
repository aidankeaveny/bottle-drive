package com.aidan.crud_backend.service;

import com.aidan.crud_backend.dto.UserDto;

import java.util.List;

/**
 * Service interface for managing {@link UserDto} objects.
 * <p>
 * This interface defines methods for creating, retrieving, updating, and
 * deleting user data. Implementations of this interface are expected to
 * interact with data repositories and handle user-related operations.
 * </p>
 */
public interface UserService {
    /**
     * Creates a new user based on the provided {@link UserDto}.
     * <p>
     * The implementation should handle the mapping from the DTO to the
     * entity, persist it, and return the created user as a DTO.
     * </p>
     *
     * @param pUserDto the user data to create
     * @return the created {@link UserDto}
     */
    UserDto createUser(UserDto pUserDto);

    /**
     * Retrieves a user by its ID and maps it to a {@link UserDto}.
     * <p>
     * The implementation should fetch the user entity from the data source
     * and return it as a DTO.
     * </p>
     *
     * @param pUserId the ID of the user to retrieve
     * @return the {@link UserDto} of the retrieved user
     */
    UserDto getUserById(Long pUserId);

    /**
     * Retrieves all users and maps them to a list of {@link UserDto} objects.
     * <p>
     * The implementation should fetch all user entities from the data source
     * and return them as a list of DTOs.
     * </p>
     *
     * @return a list of {@link UserDto} representing all users
     */
    List<UserDto> getAllUsers();

    /**
     * Updates an existing user with the given ID using the
     * provided {@link UserDto}.
     * <p>
     * The implementation should fetch the user entity, update it with the
     * new data from the DTO, persist the changes, and return the updated
     * user as a DTO.
     * </p>
     *
     * @param pUserId the ID of the user to update
     * @param pUserDto the updated user details
     * @return the updated {@link UserDto}
     */
    UserDto updateUser(Long pUserId, UserDto pUserDto);

    /**
     * Deletes a user by its ID.
     * <p>
     * The implementation should find the user entity by its ID and
     * remove it from the data source.
     * </p>
     *
     * @param pUserId the ID of the user to delete
     */
    void deleteUser(Long pUserId);

    /**
     * Counts the number of users in the system.
     * <p>
     * The implementation should return the total number of users
     * currently stored in the data source.
     * </p>
     *
     * @return the total number of users
     */
    Integer countUsers();
}
