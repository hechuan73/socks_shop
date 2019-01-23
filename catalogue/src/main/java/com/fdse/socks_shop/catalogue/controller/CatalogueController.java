package com.fdse.socks_shop.catalogue.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogueController {

    @GetMapping(value = "/catalogue")
    public ResponseEntity<Message> getItems(@RequestHeader HttpHeaders headers, @RequestParam("page") String page,
                                           @RequestParam("size") String size, @RequestParam("tags") String tags) {
        return new ResponseEntity<>(new Message("Get items succeed!"), HttpStatus.OK);
    }
}
