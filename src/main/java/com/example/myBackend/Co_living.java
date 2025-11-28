package com.example.myBackend;

import jakarta.persistence.*;

@Entity
public class Co_living {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String invite_code;

    //@OneToMany(mappedBy = "co_living", cascade = CascadeType.ALL)
    //private List<Room> rooms;

    public Co_living(String name, String address, String invite_code) {
        this.name = name;
        this.address = address;
        this.invite_code = invite_code;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
