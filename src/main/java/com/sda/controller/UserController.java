package com.sda.controller;


import com.sda.domain.User;
import com.sda.domain.UserAndCar;
import com.sda.dto.CarDto;
import com.sda.dto.CreateUserDto;
import com.sda.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {



    private final UserService service;


    public UserController(UserService userService) {
        this.service = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(
            @RequestBody @Valid CreateUserDto dto) {

        User user = service.create(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){

        List<User> allUsers = service.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("external/{id}")
    public User userDataForCarApp(@PathVariable Long id){

        User user = service.findUserById(id);
        return user;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAndCar> userAndCars(@PathVariable Long id){

        UserAndCar userAndCar = service.connectUserWithCarsById(id);

        return ResponseEntity.ok(userAndCar);

    }

}
