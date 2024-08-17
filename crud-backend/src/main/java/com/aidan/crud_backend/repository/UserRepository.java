package com.aidan.crud_backend.repository;

import com.aidan.crud_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
