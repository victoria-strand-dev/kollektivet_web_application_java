package com.example.KOLLEKTIVET.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class CoLiving {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    @Column(nullable = false, length = 100) 
    private String name;
    private String address;
    @Column(unique = true) 
    private String inviteCode;

    @OneToMany(mappedBy = "coLiving", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"coLiving", "password"})
    private List<User> users = new ArrayList<>();

    public CoLiving() {}

    public CoLiving(String name, String address, String inviteCode) {
        this.name = name;
        this.address = address;
        this.inviteCode = inviteCode;
    }

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
