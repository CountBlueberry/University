package com.blackout.university.entity;


import com.blackout.university.constant.Degree;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "lectors")
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lector_id")
    private Long lectorId;
    private String name;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private Degree degree;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "departments_lectors",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private Set<Department> departments = new HashSet<>();
}
