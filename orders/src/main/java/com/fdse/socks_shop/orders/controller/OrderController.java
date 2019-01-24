package com.fdse.socks_shop.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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

        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        // get user info
        getResource("http://user:8085/customer", headers, list1, futures);

        // get user cart items
        String customerId = UUID.randomUUID().toString();
        getDataList("http://carts:8080/carts/" + customerId + "/items", headers, list1, list2, futures);

        // pay the order
        postResource("http://payment:8083/pay", new Message(), headers, list2, list3, futures);

        // ship the order
        postResource2("http://shipping:8084/shipping", new Message(), headers, list1, list4, futures);

        futures.forEach(x -> x.join());

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

    private void getResource(String url, HttpHeaders httpHeaders, List<Object> list1, List<CompletableFuture<Void>> futures) {
        HttpEntity request = new HttpEntity<>(httpHeaders);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
            return responseEntity;
        }).thenAccept(list1::add);

        futures.add(future);
    }

    private void getDataList(String url, HttpHeaders httpHeaders, List<Object> list1, List<Object> list2, List<CompletableFuture<Void>> futures) {
        HttpEntity request = new HttpEntity<>(httpHeaders);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ResponseEntity<LinkedHashMap> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, LinkedHashMap.class);
            return responseEntity;
        }).thenAccept(list2::add);

        futures.add(future);
    }

    private void postResource(String url, Object requestBody, HttpHeaders httpHeaders, List<Object> list2, List<Object> list3, List<CompletableFuture<Void>> futures) {
        HttpEntity<Object> request = new HttpEntity<>(requestBody, httpHeaders);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
            System.out.println(list2.get(0));
            return responseEntity;
        }).thenAccept(list3::add);

        futures.add(future);
    }

    private void postResource2(String url, Object requestBody, HttpHeaders httpHeaders, List<Object> list1, List<Object> list4, List<CompletableFuture<Void>> futures) {
        HttpEntity<Object> request = new HttpEntity<>(requestBody, httpHeaders);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
            return responseEntity;
        }).thenAccept(list4::add);

        futures.add(future);
    }


//    @Async
//    public Future<Object> getResource(String url, HttpHeaders httpHeaders) {
//        HttpEntity request = new HttpEntity<>(httpHeaders);
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
//
//        return new AsyncResult<>(responseEntity.getBody());
//    }

}
