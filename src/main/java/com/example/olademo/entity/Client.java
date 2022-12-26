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
@Table(name = "client")
public class Client {
    @Id
    @Column(name="uid", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID uid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientUid")
    private Set<Accounts> accounts = new HashSet<Accounts>();

    private String firstName;
    private String lastName;
    private String accountNumber;
    private String email;
    private String phone;
}
