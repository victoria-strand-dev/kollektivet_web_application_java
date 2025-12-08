package com.example.KOLLEKTIVET.controllers;

import com.example.KOLLEKTIVET.models.User;
import com.example.KOLLEKTIVET.repositories.CoLivingRepository;
import com.example.KOLLEKTIVET.repositories.UserRepository;
import com.example.KOLLEKTIVET.models.CoLiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/coLivings")
@CrossOrigin(origins = "*") 
public class CoLivingController {

    @Autowired
    private CoLivingRepository coLivingRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<CoLiving> getAllCoLivings() {
        return coLivingRepository.findAll();
    }

    @PostMapping
    public CoLiving addCoLiving(@RequestBody CoLiving coLiving) {

        String generateInviteCode = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        coLiving.setInviteCode(generateInviteCode);

        return coLivingRepository.save(coLiving);
    }

    @PostMapping("/join")
    public String joinCoLiving(@RequestParam String inviteCode, @RequestParam Long userId) {
        
        CoLiving coLiving = coLivingRepository.findByInviteCode(inviteCode);
        if (coLiving == null) {
            return "Feil: Ugyldig invitasjonskode.";
        }

        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return "Feil: Bruker ikke funnet.";
        }

        user.setCoLiving(coLiving);
        userRepository.save(user);

        return "Bruker lagt til i kollektiv " + coLiving.getName();
    }

    @PostMapping("/joinByEmail")
    public String joinCoLivingByEmail(@RequestParam String inviteCode, @RequestParam String email) {
        CoLiving coLiving = coLivingRepository.findByInviteCode(inviteCode);
        if (coLiving == null) return "Feil: Ugyldig invitasjonskode.";

        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return "Feil: Bruker ikke funnet.";

        user.setCoLiving(coLiving);
        userRepository.save(user);
        return "Bruker lagt til i kollektiv " + coLiving.getName();
    }

}
