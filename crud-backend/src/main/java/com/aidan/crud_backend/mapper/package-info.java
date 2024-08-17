/**
 * Contains mapper classes for transforming data between different
 * representations in the CRUD backend application.
 * <p>
 * This package includes classes responsible for converting entities
 * to data transfer objects (DTOs) and vice versa. Mappers help in the
 * separation of concerns by decoupling the internal data model
 * from the external data representations.
 * </p>
 * <p>
 * For example, this package includes:
 * <ul>
 *     <li>{@link com.aidan.crud_backend.mapper.UserMapper} - Provides
 *     methods for mapping {@link com.aidan.crud_backend.entity.User}
 *     entities to {@link com.aidan.crud_backend.dto.UserDto} objects
 *     and vice versa.</li>
 * </ul>
 * </p>
 * <p>
 * Additional mapper classes for other entities and DTOs may be added as
 * the application evolves.
 * </p>
 *
 * @since 1.0
 */
package com.aidan.crud_backend.mapper;
