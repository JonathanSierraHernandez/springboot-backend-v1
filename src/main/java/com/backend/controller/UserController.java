package com.backend.controller;

import com.backend.model.Usr;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    // standard constructors

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<Usr> getUsers() {
        return (List<Usr>) userRepository.findAll();
    }

    @GetMapping("/users/{email}")
    public Usr getUser(@PathVariable("email") String email) { return userRepository.findUserByStatus(email); }

    @PostMapping("/users")
    void addUser(@RequestBody Usr user) { userRepository.save(user); }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

}