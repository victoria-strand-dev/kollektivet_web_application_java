package com.example.myNewBackend.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity //Tells the Spring Boot/Hibernate that this class is going to connect to a database table
public class Room {
    @Id //Setting the primary key to id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //"autoincrement"
    //Defining the variables that are going
    //to be the columns for the User-table
    private Long id;
    @Column(nullable = false)
    private int roomNumber;


    @ManyToOne
    @JoinColumn(name = "coLiving", nullable = false)
    private CoLiving coLiving;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Room() {}

    //Constructor
    public Room(int roomNumber, String email,
                String firstName, String lastName, Long phone,
                String study, String work, LocalDate birthday) {
        this.roomNumber = roomNumber;
    }

    //Getters and setters
    public Long getId() {return id;}

    public int getRoomNumber() {return roomNumber;}
    public void setRoomNumber(int roomNumber) {this.roomNumber = roomNumber;}

    public CoLiving getCoLiving() {return coLiving;}
    public void setCoLiving(CoLiving coLiving) {this.coLiving = coLiving;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}
