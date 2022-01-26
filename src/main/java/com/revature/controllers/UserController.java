package com.revature.controllers;

import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
        return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.editUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.OK);
    }
}
