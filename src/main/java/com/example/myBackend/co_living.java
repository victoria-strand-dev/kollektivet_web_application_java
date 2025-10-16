package com.example.myBackend;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_password;
    private String user_email;
    private String first_name;
    private String last_name;
