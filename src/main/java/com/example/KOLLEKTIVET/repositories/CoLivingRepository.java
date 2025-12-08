package com.example.KOLLEKTIVET.repositories;
import com.example.KOLLEKTIVET.models.CoLiving;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoLivingRepository extends JpaRepository<CoLiving, Long> {
    CoLiving findByInviteCode(String inviteCode);
}
