package com.aidan.crud_backend.mapper;

import com.aidan.crud_backend.dto.UserDto;
import com.aidan.crud_backend.entity.User;

/**
 * Utility class for mapping between User and UserDto objects.
 * <p>
 * This class provides static methods to convert between entity
 * {@link User} and its corresponding Data Transfer Object (DTO)
 * {@link UserDto}.
 * </p>
 */
public class UserMapper {

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This constructor is intentionally private and throws an
     * {@link UnsupportedOperationException} to prevent instantiation
     * or subclassing.
     * </p>
     */
    protected UserMapper() {
        // prevents calls from subclass
    }

    /**
     * Converts a {@link User} entity to a {@link UserDto}.
     *
     * @param user the user entity to convert
     * @return the corresponding UserDto
     */
    public static UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    /**
     * Converts a {@link UserDto} to a {@link User} entity.
     *
     * @param userDto the user DTO to convert
     * @return the corresponding User entity
     */
    public static User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
