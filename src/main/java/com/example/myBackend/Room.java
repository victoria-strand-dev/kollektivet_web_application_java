package com.example.myBackend;

import jakarta.persistence.*;

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String roomName;

    @ManyToOne
    @JoinColumn(name = "co_living_id")
    private Co_living co_living;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public Co_living getCo_living() {
        return co_living;
    }

    public void setCo_living(Co_living co_living) {
        this.co_living = co_living;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
