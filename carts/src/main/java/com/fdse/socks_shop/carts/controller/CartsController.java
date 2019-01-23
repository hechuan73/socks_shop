package com.fdse.socks_shop.carts.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class CartsController {

    @PostMapping("/cart")
    public ResponseEntity<Message> addToCart(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>(new Message("Add to cart succeed!"), HttpStatus.CREATED);
    }

    @GetMapping("/cart")
    public ResponseEntity<Message> get(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(new Message("Get cart items succeed!"), HttpStatus.OK);
    }

    @GetMapping("/carts/{customerId}/items")
    public ResponseEntity<Message> getItems(@RequestHeader HttpHeaders headers, @PathVariable String customerId) {
        return new ResponseEntity<>(new Message(Arrays.asList("Item1", "Item2")), HttpStatus.OK);
    }
}
