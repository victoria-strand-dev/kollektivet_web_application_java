package com.example.myNewBackend.repositories;
import com.example.myNewBackend.models.CoLiving;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoLivingRepository extends JpaRepository<CoLiving, Long> {
    CoLiving findByInviteCode(String inviteCode);
}
