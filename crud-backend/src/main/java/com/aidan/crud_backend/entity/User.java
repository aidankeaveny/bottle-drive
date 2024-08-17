package com.aidan.crud_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a user in the application.
 * <p>
 * This class maps to the "users" table in the database and represents the data
 * associated with a user.
 * It uses JPA annotations to define the mapping between the class
 * and the database table.
 * </p>
 *
 * <p>
 * The {@link User} entity contains the following fields:
 * <ul>
 *     <li><b>id</b> - The unique identifier for the user,
 *     generated automatically.</li>
 *     <li><b>firstName</b> - The first name of the user.</li>
 *     <li><b>lastName</b> - The last name of the user.</li>
 *     <li><b>email</b> - The email address of the user, which is required
 *     and must be unique.</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class uses Lombok annotations to generate
 * boilerplate code such as getters, setters,
 * no-argument constructor, and all-argument constructor.
 * </p>
 *
 * <p>
 * The {@link Entity} annotation indicates that this class is a JPA entity.
 * The {@link Table} annotationspecifies the name of the table to which this
 * entity is mapped. The {@link Id} and {@link GeneratedValue}
 * annotations are used to define the primary key and its generation strategy.
 * </p>
 *
 * @see com.aidan.crud_backend.dto.UserDto
 * @see com.aidan.crud_backend.repository.UserRepository
 * @see com.aidan.crud_backend.service.UserService
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /**
     * The unique identifier for the user.
     * <p>
     * This is the primary key for the "users" table
     * and is automatically generated.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the user.
     * <p>
     * This field is mapped to the "first_name" column in the "users" table.
     * </p>
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the user.
     * <p>
     * This field is mapped to the "last_name" column in the "users" table.
     * </p>
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The email address of the user.
     * <p>
     * This field is mapped to the "email_id" column
     * in the "users" table. It is marked as non-nullable and must be
     * unique across all users.
     * </p>
     */
    @Column(name = "email_id", nullable = false, unique = true)
    private String email;
}