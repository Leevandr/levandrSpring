package ru.levandr.levandrSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levandr.levandrSpring.entity.UserEntity;
import ru.levandr.levandrSpring.exception.UserAlreadyExistException;
import ru.levandr.levandrSpring.exception.UserNotFoundException;
import ru.levandr.levandrSpring.repository.UserRepo;
import ru.levandr.levandrSpring.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        //return ResponseEntity.ofNullable("");
        try {
            userService.registration(user);
            return ResponseEntity.ok("User successfully saved");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("NO WORK!");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("NO WORK!");
        }
    }
}