package com.fdse.socks_shop.carts.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartsController {

    @PostMapping("/cart")
    public ResponseEntity<String> addToCart(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>("Add to cart succeed!", HttpStatus.CREATED);
    }

    @GetMapping("/cart")
    public ResponseEntity<String> get(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>("Get cart items succeed!", HttpStatus.OK);
    }

    @GetMapping("/carts/{customerId}/items")
    public ResponseEntity<List<Object>> getItems(@RequestHeader HttpHeaders headers, @PathVariable String customerId) {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }
}
