package com.sof306.assignment.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sof306.assignment.entity.Order;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderData);

    Object findById(Long id);

    List<Order> findByCus(String name);
}
