package com.example.olademo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "limits")
public class Limits {
    @Id
    @Column(name="uid", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID uid;
    private Integer sum;
    private String currency;
    private String date;
}
