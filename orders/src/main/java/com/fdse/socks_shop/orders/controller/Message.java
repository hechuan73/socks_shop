package com.fdse.socks_shop.orders.controller;

public class Message {

    private Object data;

    public Message(Object data) {
        this.data = data;
    }

    public Message() {}

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
