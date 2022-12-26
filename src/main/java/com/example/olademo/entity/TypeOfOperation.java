package com.example.olademo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "typeOfOperation")
public class TypeOfOperation {
    @Id
    @Column(name="uid", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID typeOfOperationUid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeOfOperationUid")
    private Set<Operation> operations = new HashSet<Operation>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeOfOperationUid")
    private Set<Limits> limits = new HashSet<Limits>();

    private String operationName;
    private String sum;
    private String peculiarities;
}

