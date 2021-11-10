package com.blackout.university.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class AvgSalary {
    @Id
    private Integer id;
    private final String name;
    private final Double avgSalary;
}
