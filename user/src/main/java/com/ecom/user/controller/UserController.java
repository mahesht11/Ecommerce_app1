package com.ecom.user.controller;


import com.ecom.user.dto.UserRequest;
import com.ecom.user.dto.UserResponse;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {


    private final UserService userService;

    @GetMapping("/check")
    public String test(){
        return "user is working in ecommerce!";
    }

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
       String s = userService.createUser(userRequest);
        return new ResponseEntity<>("s", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>>  getAllUser(){
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
        boolean value = userService.updateUser(id, userRequest);
        if(value){
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
