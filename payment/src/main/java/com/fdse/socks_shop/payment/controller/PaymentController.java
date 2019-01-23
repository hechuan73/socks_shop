package com.fdse.socks_shop.payment.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestHeader HttpHeaders headers, @RequestBody Object requestBody) {
        return new ResponseEntity<>("Pay order succeed!", HttpStatus.OK);
    }
}
