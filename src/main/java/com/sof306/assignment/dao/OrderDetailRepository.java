package com.sof306.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.assignment.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}