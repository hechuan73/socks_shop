package com.fdse.socks_shop.carts.controller;

public class Message {

    private Object data;

    public Message(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
