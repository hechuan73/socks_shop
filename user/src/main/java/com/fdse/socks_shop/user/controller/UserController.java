package com.fdse.socks_shop.user.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping(value = "/register")
    public ResponseEntity<Message> register(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>(new Message("Register succeed!"), HttpStatus.CREATED);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Message> login(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(new Message("Login succeed!"), HttpStatus.OK);
    }

    @PostMapping("/addresses")
    public ResponseEntity<Message> address(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>(new Message("Set address succeed!"), HttpStatus.CREATED);
    }

    @GetMapping("/address")
    public ResponseEntity<Message> address(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(new Message("Get address succeed!"), HttpStatus.OK);
    }

    @PostMapping("/cards")
    public ResponseEntity<Message> card(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>(new Message("Set card succeed!"), HttpStatus.CREATED);
    }

    @GetMapping("/card")
    public ResponseEntity<Message> card(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(new Message("Get card succeed!"), HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<Message> customer(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(new Message("Get customer succeed!"), HttpStatus.OK);
    }

}
