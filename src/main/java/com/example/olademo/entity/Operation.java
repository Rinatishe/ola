package com.example.olademo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "operation")
public class Operation {
    @Id
    @Column(name="uid", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID uid;
    private UUID operationCategoryUid;
    private UUID accountUid;
    private Integer sum;
    private Integer limitSum;
    private String currency;
    private Date date;
    private Boolean limitExceed;
}
