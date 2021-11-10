package com.blackout.university.repository;

import com.blackout.university.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartRepo extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
