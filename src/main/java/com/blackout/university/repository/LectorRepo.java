package com.blackout.university.repository;

import com.blackout.university.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface LectorRepo extends JpaRepository<Lector, Long> {
    Set<Lector> findByNameLike(String template);

    @Query(value = "SELECT new AvgSalary(d.name, avg(l.salary)) " +
            "FROM Lector l, Department d WHERE ?1 MEMBER OF l.departments AND d = ?1 GROUP BY d")
    Optional<AvgSalary> findAvgSalary(Department department);
}
