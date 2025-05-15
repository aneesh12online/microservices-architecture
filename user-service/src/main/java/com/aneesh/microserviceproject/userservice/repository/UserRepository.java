package com.aneesh.microserviceproject.userservice.repository;

import com.aneesh.microserviceproject.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
