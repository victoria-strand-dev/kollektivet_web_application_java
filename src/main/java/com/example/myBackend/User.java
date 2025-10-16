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
    private Long user_phone;
    private String user_study;
    private String user_work;
    private LocalDate user_birthday;

    //@ManyToOne
    //@JoinColumn(name_spm? = "co_living_id")
    //private Co_living co_living;


    public User() {}

    public User(String pass, String email,
                String first_name, String last_name, Long phone,
                String study, String work, LocalDate birthday) {
        this.user_password = pass;
        this.user_email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_phone = phone;
        this.user_study = study;
        this.user_work = work;
        this.user_birthday = birthday;
    }

    public Long getId() {
        return id;
    }


    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String user_email) {
        this.user_email = user_email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(Long user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_study() {
        return user_study;
    }

    public void setUser_study(String user_study) {
        this.user_study = user_study;
    }

    public String getUser_work() {
        return user_work;
    }

    public void setUser_work(String user_work) {
        this.user_work = user_work;
    }

    public LocalDate getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(LocalDate user_birthday) {
        this.user_birthday = user_birthday;
    }

}
