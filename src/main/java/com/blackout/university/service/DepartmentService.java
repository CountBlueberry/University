package com.blackout.university.service;

import com.blackout.university.entity.Department;
import com.blackout.university.entity.Lector;
import com.blackout.university.exception.DepartmentNotFoundException;
import com.blackout.university.repository.DepartRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private static final String DEPART_EXCEPTION_MASSAGE = "Department with this name not found: ";
    private final DepartRepo departRepo;

    public Set<Lector> getLectorsOfDepartment(String departName){
        Department department = getDepartmentByName(departName);
        return department.getLectors();
    }

    public Lector getHeadOfDepartment(String departName) {
        Department department = getDepartmentByName(departName);
        return department.getLector();
    }

    @SneakyThrows
    public Department getDepartmentByName(String departName) {
        return departRepo.findByName(departName)
                .orElseThrow(() -> new DepartmentNotFoundException(DEPART_EXCEPTION_MASSAGE + departName));
    }
}

