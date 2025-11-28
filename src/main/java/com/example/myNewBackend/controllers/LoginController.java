package com.example.myNewBackend.controllers;

import com.example.myNewBackend.models.User;
import com.example.myNewBackend.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping({"/api/login_out"})
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")

public class LoginController {

    @Autowired
    private UserRepository userRepository;

    // 🔹 LOGIN
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null || !user.getPassword().equals(password)) {
            return "Feil e-post eller passord";
        }

        // lagrer brukerinfo i session (som $_SESSION[] i PHP)
        session.setAttribute("userId", user.getId());
        session.setAttribute("userEmail", user.getEmail());
        session.setAttribute("userFirstName", user.getFirstName());

        return "Innlogging vellykket for " + user.getFirstName();
    }

    // 🔹 HENT SESSION-INFO
    @GetMapping("/session")
    public Map<String, Object> getSessionInfo(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        map.put("userId", session.getAttribute("userId"));
        map.put("email", session.getAttribute("userEmail"));
        map.put("firstName", session.getAttribute("userFirstName"));

        return map;
    }

    // 🔹 LOGOUT
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // tilsvarer session_destroy()
        return "Bruker logget ut";
    }
}
