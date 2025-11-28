package com.example.myNewBackend.repositories;
import com.example.myNewBackend.models.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}