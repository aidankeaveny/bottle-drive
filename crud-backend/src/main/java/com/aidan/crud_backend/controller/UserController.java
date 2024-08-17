package com.aidan.crud_backend.controller;

import com.aidan.crud_backend.dto.UserDto;
import com.aidan.crud_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * REST controller for managing User entities.
 * <p>
 * This controller provides endpoints for creating, retrieving, updating,
 * and deleting users in the system. It interacts with the UserService
 * to perform the necessary business logic.
 * </p>
 */
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    /**
     * Service layer for managing users.
     * <p>
     * The UserService provides the business logic required for managing
     * users, including operations such as creating, retrieving, updating,
     * and deleting users.
     * </p>
     */
    private final UserService userService;

    /**
     * Create a new User.
     * <p>
     * This endpoint handles HTTP POST requests to create a new User
     * in the system. It accepts a UserDto object in the request body
     * and returns the created UserDto with HTTP status 201 (Created).
     * </p>
     *
     * @param userDto the user to be added
     * @return the created UserDto with HTTP status 201
     */
    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody final UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Retrieve a User by ID.
     * <p>
     * This endpoint handles HTTP GET requests to retrieve a User by
     * their unique ID. If found, the UserDto is returned with HTTP status 200
     * (OK).
     * </p>
     *
     * @param userId the id of the user to be retrieved
     * @return the UserDto corresponding to the given ID with HTTP status 200
     */
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable("id") final Long userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    /**
     * Retrieve all Users.
     * <p>
     * This endpoint handles HTTP GET requests to retrieve all Users in the
     * system. It returns a list of UserDto objects with HTTP status 200 (OK).
     * </p>
     *
     * @return a list of UserDto objects with HTTP status 200
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Update an existing User.
     * <p>
     * This endpoint handles HTTP PUT requests to update an existing User
     * in the system. It accepts a UserDto object in the request body,
     * updates the User corresponding to the given ID, and returns the
     * updated UserDto with HTTP status 200 (OK).
     * </p>
     *
     * @param userId the id of the user to be updated
     * @param userDto the updated user data
     * @return the updated UserDto with HTTP status 200
     */
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable("id") final Long userId,
            @RequestBody final UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete a User by ID.
     * <p>
     * This endpoint handles HTTP DELETE requests to delete a User from the
     * system by their unique ID. Upon successful deletion, a confirmation
     * message is returned with HTTP status 200 (OK).
     * </p>
     *
     * @param userId the id of the user to be deleted
     * @return a confirmation message with HTTP status 200
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("id") final Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("user deleted successfully");
    }

}
