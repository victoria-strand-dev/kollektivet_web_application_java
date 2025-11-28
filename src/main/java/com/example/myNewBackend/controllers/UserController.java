package com.example.myNewBackend.controllers;

import com.example.myNewBackend.repositories.UserRepository;
import com.example.myNewBackend.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users") // alle endepunkt starter med /api/users
@CrossOrigin(origins = "*") // lar deg hente data fra frontend uten CORS-feil
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll(); // sender JSON
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bruker ikke funnet"));

        if (updatedUser.getFirstName() != null && !updatedUser.getFirstName().isEmpty())
            existingUser.setFirstName(updatedUser.getFirstName());

        if (updatedUser.getLastName() != null && !updatedUser.getLastName().isEmpty())
            existingUser.setLastName(updatedUser.getLastName());

        if (updatedUser.getEmail() != null && !updatedUser.getEmail().isEmpty())
            existingUser.setEmail(updatedUser.getEmail());

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty())
            existingUser.setPassword(updatedUser.getPassword());

        if (updatedUser.getPhone() != null)
            existingUser.setPhone(updatedUser.getPhone());

        if (updatedUser.getStudy() != null && !updatedUser.getStudy().isEmpty())
            existingUser.setStudy(updatedUser.getStudy());

        if (updatedUser.getWork() != null && !updatedUser.getWork().isEmpty())
            existingUser.setWork(updatedUser.getWork());

        return userRepository.save(existingUser);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
