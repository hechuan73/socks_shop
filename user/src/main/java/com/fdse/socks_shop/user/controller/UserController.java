package com.fdse.socks_shop.user.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>("Register succeed!", HttpStatus.CREATED);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<String> login(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>("Login succeed!", HttpStatus.OK);
    }

    @PostMapping("/addresses")
    public ResponseEntity<String> address(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>("Set address succeed!", HttpStatus.CREATED);
    }

    @GetMapping("/address")
    public ResponseEntity<String> address(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>("Get address succeed!", HttpStatus.OK);
    }

    @PostMapping("/cards")
    public ResponseEntity<String> card(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>("Set card succeed!", HttpStatus.CREATED);
    }

    @GetMapping("/card")
    public ResponseEntity<String> card(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>("Get card succeed!", HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<String> customer(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>("Get customer succeed!", HttpStatus.OK);
    }

}
