package com.blackout.university.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "head_of_department_id")
    private Lector lector;
    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private Set<Lector> lectors = new HashSet<>();
}
