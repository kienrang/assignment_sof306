package com.sof306.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.assignment.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByAccount_Username(String username);
}