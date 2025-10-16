package com.example.myBackend;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String location;
    private String description;

    //@ManyToOne
    //@JoinColumn(name = "co_living_id")
    //private Co_living co_living;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Calendar(String title, LocalDate date, LocalTime startTime,
                    LocalTime endTime, String location, String description) {
        this.title = title;
        this.date = date;
        this.start_time = startTime;
        this.end_time = endTime;
        this.location = location;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
