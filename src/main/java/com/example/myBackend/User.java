package com.example.myBackend;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private Long phone;
    private String study;
    private String work;
    private LocalDate birthday;

    //@ManyToOne
    //@JoinColumn(name_spm? = "co_living_id")
    //private Co_living co_living;
    @OneToOne(mappedBy = "user")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User() {}

    public User(String pass, String email,
                String first_name, String last_name, Long phone,
                String study, String work, LocalDate birthday) {
        this.password = pass;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.study = study;
        this.work = work;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
