package ru.levandr.levandrSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levandr.levandrSpring.entity.UserEntity;
import ru.levandr.levandrSpring.repository.UserRepo;
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        //return ResponseEntity.ofNullable("");
        try {
            userRepo.save(user);
            return ResponseEntity.ok("User successfully saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("NO WORK!");
        }
    }

    @GetMapping
    public  ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Work!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("NO WORK!");

        }

    }
}


