package com.blackout.university.service;

import com.blackout.university.constant.Degree;
import com.blackout.university.entity.Department;
import com.blackout.university.entity.Lector;
import com.blackout.university.exception.AvgSalaryException;
import com.blackout.university.repository.LectorRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectorService {
    private static final String AVERAGE_SALARY_EXCEPTION_MASSAGE = "Average salary cannot be found in department: ";
    private final LectorRepo lectorRepo;

    public Map<Degree, List<Lector>> countLectorsInDepartmentByDegree(Set<Lector> lectors) {
        return lectors.stream().collect(Collectors.groupingBy(Lector::getDegree));
    }

    @SneakyThrows
    public Double getAvgSalary(Department department) {
        return lectorRepo.findAvgSalary(department)
                .orElseThrow(() ->
                        new AvgSalaryException(AVERAGE_SALARY_EXCEPTION_MASSAGE + department.getName()))
                .getAvgSalary();
    }

    public Set<Lector> searchByTemplate(String template) {
        String sqlTemplate = "%" + template + "%";
        return lectorRepo.findByNameLike(sqlTemplate);
    }
}
