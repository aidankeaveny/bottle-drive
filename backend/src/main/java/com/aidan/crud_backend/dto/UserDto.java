package com.aidan.crud_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for transferring user data between different
 * layers of the application.
 *
 * <p>
 * This class is used to encapsulate the data of a user
 * entity in a manner suitable for communication
 * between the service layer and the presentation layer.
 * It represents the user information in a way
 * that can be easily serialized and deserialized,
 * typically used in REST API requests and responses.
 * </p>
 *
 * <p>
 * The {@link UserDto} class contains the following fields:
 * <ul>
 *     <li><b>id</b> - The unique identifier for the user.</li>
 *     <li><b>firstName</b> - The first name of the user.</li>
 *     <li><b>lastName</b> - The last name of the user.</li>
 *     <li><b>email</b> - The email address of the user.</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class uses Lombok annotations to generate
 * boilerplate code such as getters, setters,
 * no-argument constructor, and all-argument constructor.
 * </p>
 *
 * @see com.aidan.crud_backend.entity.User
 * @see com.aidan.crud_backend.service.UserService
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    /**
     * The unique identifier for the user.
     */
    private Long id;
    /**
     * The first name of the user.
     */
    private String name;
    /**
     * The email address of the user.
     */
    private String email;
    /**
     * The number of bottles the user has donated.
     */
    private Integer numberOfBottles;
    /**
     * The address of the user.
     */
    private String address;
}
