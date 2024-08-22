/**
 * Contains repository interfaces for data access and
 * persistence in the backend
 * application.
 * <p>
 * This package includes interfaces that extend
 * {@link org.springframework.data.jpa.repository.JpaRepository}
 * to provide operations and custom queries for entities
 * in the application.Repositories act as an abstraction layer
 * between the application's business logic and the database,
 * facilitating data access operations.
 * </p>
 * <p>
 * For example, this package includes:
 * <ul>
 *     <li>{@link com.aidan.backend.repository.UserRepository} -
 *     Provides operations and data access methods for the
 *     {@link com.aidan.backend.entity.User} entity.</li>
 * </ul>
 * </p>
 * <p>
 * Additional repository interfaces for other entities and custom queries may be
 * added as the application grows.
 * </p>
 *
 * @since 1.0
 */
package com.aidan.backend.repository;
