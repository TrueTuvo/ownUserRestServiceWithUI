package com.severyn.zabara.spring.ownuserrestservicewithui.controller;

import com.severyn.zabara.spring.ownuserrestservicewithui.entity.UserEntity;
import com.severyn.zabara.spring.ownuserrestservicewithui.exceptions.UserAlreadyExistException;
import com.severyn.zabara.spring.ownuserrestservicewithui.exceptions.UserNotFoundException;
import com.severyn.zabara.spring.ownuserrestservicewithui.model.User;
import com.severyn.zabara.spring.ownuserrestservicewithui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(User.toModel(userService.getUser(id)));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(User.toModel(userService.createUser(user)));
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        try {
            userService.updateUser(id,user);
            return ResponseEntity.ok("User with id = " + id + " successfully updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User with id = " + id + " successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }


}
