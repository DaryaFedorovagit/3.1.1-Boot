package com.example.vers.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Users2")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
}
