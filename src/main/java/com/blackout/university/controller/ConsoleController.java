package com.blackout.university.controller;

import com.blackout.university.constant.Commands;
import com.blackout.university.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

@Controller
@RequiredArgsConstructor
@SpringBootApplication
public class ConsoleController implements CommandLineRunner {
    private final static String COMMANDS_FOR_CHOICE = "Pick one of the commands:" +
            "\n(1)Who is head of department." +
            "\n(2)Show statistics." +
            "\n(3)Show the average salary for the department." +
            "\n(4)Show count of employee for." +
            "\n(5)Global search by template";
    private final static String INVALID_INPUT = "You must chose between 1,2,3,4,5";

    private final Map<Integer, Commands> commandsMap = new HashMap<>();
    private final AnswerService answerService;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args){
        fillCommandsMap();
        String answer = readUserChoice();
        System.out.println(answer);
        run();
    }

    private void fillCommandsMap() {
        commandsMap.put(1,Commands.WHO_HEAD_OF_DEPARTMENT);
        commandsMap.put(2,Commands.SHOW_STATISTICS);
        commandsMap.put(3,Commands.SHOW_AVG_SALARY_FOR_DEPARTMENT);
        commandsMap.put(4,Commands.SHOW_COUNT_OF_EMPLOYEE);
        commandsMap.put(5,Commands.GLOBAL_SEARCH);
    }

    private String readUserChoice(){
        System.out.println(COMMANDS_FOR_CHOICE);
        Optional<Commands> userChoiceOptional = Optional.ofNullable(commandsMap.get(scanner.nextInt()));
        if(userChoiceOptional.isPresent())
            return choseCommand(userChoiceOptional.get());
        else {
            return INVALID_INPUT;
        }
    }

    private String choseCommand(Commands commands) {
        switch (commands){
            case WHO_HEAD_OF_DEPARTMENT:
                return answerService.getHeadOfDepart();
            case SHOW_STATISTICS:
                return answerService.getDepartmentStatistic();
            case SHOW_AVG_SALARY_FOR_DEPARTMENT:
                return answerService.getAvgSalary();
            case SHOW_COUNT_OF_EMPLOYEE:
                return answerService.getNumberOfEmployee();
            case GLOBAL_SEARCH:
                return answerService.searchByTemplate();
            default:
                return INVALID_INPUT;
        }
    }
}
