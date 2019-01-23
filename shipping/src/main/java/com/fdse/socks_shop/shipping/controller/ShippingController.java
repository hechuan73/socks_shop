package com.fdse.socks_shop.shipping.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

    @PostMapping("/shipping")
    public ResponseEntity<String> postShipping(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>("Ship order succeed!", HttpStatus.CREATED);
    }
}
