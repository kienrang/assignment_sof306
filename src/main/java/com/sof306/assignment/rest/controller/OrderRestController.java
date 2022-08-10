package com.sof306.assignment.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.sof306.assignment.entity.Order;
import com.sof306.assignment.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/rest/orders")
    public Order getOne(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }
}
