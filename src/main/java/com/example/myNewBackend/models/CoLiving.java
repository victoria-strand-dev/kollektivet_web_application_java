package com.example.myNewBackend.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Tells the Spring Boot/Hibernate that this class is going to connect to a database table
public class CoLiving {
    @Id //Setting the primary key to id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //"autoincrement"
    //Defining the variables that are going
    //to be the columns for the User-table
    private Integer id;
    @Column(nullable = false, length = 100) //Setting to "not null" and length=100
    private String name;
    private String address;
    @Column(unique = true) //Setting "unique"
    private String inviteCode;

    @OneToMany(mappedBy = "coLiving", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"coLiving", "password"})
    private List<User> users = new ArrayList<>();

    public CoLiving() {}

    //Constructor
    public CoLiving(String name, String address, String inviteCode) {
        this.name = name;
        this.address = address;
        this.inviteCode = inviteCode;
    }

    //Setters and getters
    public int getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getInviteCode() {return inviteCode;}
    public void setInviteCode(String inviteCode) {this.inviteCode = inviteCode;}

    public List<User> getUsers() {return users;}
    public void setUsers(List<User> users) {this.users = users;}
}
