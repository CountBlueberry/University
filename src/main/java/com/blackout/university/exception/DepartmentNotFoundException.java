package com.blackout.university.exception;

import com.blackout.university.service.AnswerService;
import lombok.RequiredArgsConstructor;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException(String massage) {
        System.out.println(massage);
    }
}
