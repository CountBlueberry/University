package com.blackout.university.service;


import com.blackout.university.constant.Degree;
import com.blackout.university.entity.Department;
import com.blackout.university.entity.Lector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private static final String WHO_IS_HEAD_OF_DEPARTMENT = "Head of %s department is %s";
    private static final String DEPARTMENT_STATISTIC_MESSAGE = "%s - %d";
    private static final String AVG_SALARY_MESSAGE = "The average salary of %s is %f";
    private static final String NUMBER_OF_EMPLOYEE = "%d employee work in %s department";
    private static final String INPUT_DEPARTMENT_MESSAGE = "Input department name:";
    private static final String INPUT_TEMPLATE_MESSAGE = "Input template:";

    private final DepartmentService departmentService;
    private final LectorService lectorService;
    private final Scanner scanner = new Scanner(System.in);

    public String getHeadOfDepart() {
        String departName = scanUserInput(INPUT_DEPARTMENT_MESSAGE);
        String headOfDepartmentName = departmentService.getHeadOfDepartment(departName).getName();
        return String.format(WHO_IS_HEAD_OF_DEPARTMENT, departName, headOfDepartmentName);
    }

    public String getDepartmentStatistic() {
        String departName = scanUserInput(INPUT_DEPARTMENT_MESSAGE);
        Set<Lector> lectors = departmentService.getLectorsOfDepartment(departName);
        Map<Degree, List<Lector>> degreeMap = lectorService.countLectorsInDepartmentByDegree(lectors);
        return degreeMap.entrySet()
                .stream()
                .map(entry -> {
                    return String
                            .format(DEPARTMENT_STATISTIC_MESSAGE, entry
                                    .getKey()
                                    .toString()
                                    .toLowerCase()
                                    .replace("_", " "), entry
                                    .getValue()
                                    .size());
                }).collect(Collectors.joining("\n"));
    }

    public String getAvgSalary() {
        String departName = scanUserInput(INPUT_DEPARTMENT_MESSAGE);
        Double avgSalary = lectorService.getAvgSalary(departmentService.getDepartmentByName(departName));
        return String.format(AVG_SALARY_MESSAGE, departName, avgSalary);
    }

    public String getNumberOfEmployee() {
        String departName = scanUserInput(INPUT_DEPARTMENT_MESSAGE);
        Department department = departmentService.getDepartmentByName(departName);
        Integer numberOfEmployee = department.getLectors().size();
        return String.format(NUMBER_OF_EMPLOYEE, numberOfEmployee, departName);
    }

    public String searchByTemplate() {
        String template = scanUserInput(INPUT_TEMPLATE_MESSAGE);
        return lectorService.searchByTemplate(template).stream().map(Lector::getName).collect(Collectors.joining(","));
    }

    private String scanUserInput(String messageBeforeScan) {
        System.out.println(messageBeforeScan);
        String departName = scanner.nextLine();
        return departName.replace("\n", "");
    }
}
