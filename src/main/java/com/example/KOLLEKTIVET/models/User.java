package com.example.KOLLEKTIVET.models;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "app_user")
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private Long phone;
    private String study;
    private String work;
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "co_living_id")
    @JsonIgnoreProperties("users")
    private CoLiving coLiving;

    public User() {
    }

    public User(String pass, String email,
                String firstName, String lastName, Long phone,
                String study, String work, LocalDate birthday) {
        this.password = pass;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.study = study;
        this.work = work;
        this.birthday = birthday;
    }

    public Long getId() {return id;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public Long getPhone() {return phone;}
    public void setPhone(Long phone) {this.phone = phone;}

    public String getStudy() {return study;}
    public void setStudy(String study) {this.study = study;}

    public String getWork() {return work;}
    public void setWork(String work) {this.work = work;}

    public LocalDate getBirthday() {return birthday;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}

    public CoLiving getCoLiving() {return coLiving;}
    public void setCoLiving(CoLiving coLiving) {this.coLiving = coLiving;}

    @JsonProperty("coLivingId")
    public Integer getCoLivingId() {
        return coLiving != null ? coLiving.getId() : null;
    }
}
