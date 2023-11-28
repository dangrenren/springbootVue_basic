package com.example.spring_basic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jpa_user")
public class JPAUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}

