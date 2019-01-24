package com.fdse.socks_shop.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/orders")
    public ResponseEntity<Message> newOrder(@RequestHeader HttpHeaders headers) {

        // get user address
        // Object address = getResource("http://user:8085/address", headers);

        // get user card
        // Object card = getResource("http://user:8085/card", headers);

        // get user info
        Object customer = getResource("http://user:8085/customer", headers);

        // get user cart items
        String customerId = UUID.randomUUID().toString();
        List<Object> items = getDataList("http://carts:8080/carts/" + customerId + "/items", headers);

        // pay the order
        Object payment = postResource("http://payment:8083/pay", new Message(), headers);

        // ship the order
        Object shipment = postResource("http://shipping:8084/shipping", new Message(), headers);

        return new ResponseEntity<>(new Message("Add to cart succeed!"), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<Message> getOrders(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(new Message("Get cart items succeed!"), HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Message> getOrders(@RequestHeader HttpHeaders headers, @PathVariable String orderId) {
        return new ResponseEntity<>(new Message("Get cart items succeed!"), HttpStatus.OK);
    }

    private Object getResource(String url, HttpHeaders httpHeaders) {
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);

        return responseEntity.getBody();
    }

    private List<Object> getDataList(String url, HttpHeaders httpHeaders) {
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<LinkedHashMap> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, LinkedHashMap.class);

        return (List<Object>) responseEntity.getBody().get("data");

    }

    private Object postResource(String url, Object requestBody, HttpHeaders httpHeaders) {
        HttpEntity<Object> request = new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);

        return responseEntity.getBody();
    }

//    @Async
//    public Future<Object> getResource(String url, HttpHeaders httpHeaders) {
//        HttpEntity request = new HttpEntity<>(httpHeaders);
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
//
//        return new AsyncResult<>(responseEntity.getBody());
//    }

}
