package com.aidan.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a requested resource is not found.
 * <p>
 * This exception is thrown to indicate that a resource, such as an entity
 * in the database, could not be found. It triggers a response with
 * the HTTP status code 404 (Not Found).
 * </p>
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constructs a new ResourceNotFoundException with the specified
     * detail message.
     *
     * @param message the detail message explaining the reason
     *                for the exception
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
