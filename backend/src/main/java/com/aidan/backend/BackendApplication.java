package com.aidan.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point for the CRUD backend application.
 * <p>
 * This class contains the {@code main} method which is used to launch the
 * Spring Boot application. It is annotated with {@link SpringBootApplication}
 * to enable auto-configuration, component scanning, and property support.
 * </p>
 * <p>
 * The constructor is protected and throws an
 * {@link UnsupportedOperationException}
 * to prevent instantiation or subclassing of this utility class.
 * </p>
 */
@SpringBootApplication
public class BackendApplication {

    /**
     * Protected constructor to prevent instantiation.
     * <p>
     * This constructor is protected to prevent
     * instantiation of this utility class.
     * It throws an {@link UnsupportedOperationException}
     * to indicate that the class
     * should not be instantiated or subclassed.
     * </p>
     *
     * @throws UnsupportedOperationException if
     * this class is instantiated or subclassed
     */
    public void foo() {
        throw new UnsupportedOperationException();
    }

    /**
     * The main method that serves as the entry point to the application.
     * <p>
     * This method uses {@link SpringApplication#run(Class, String...)}
     * to launch the Spring Boot application. It initializes the application
     * context and starts the embedded server.
     * </p>
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(final String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
