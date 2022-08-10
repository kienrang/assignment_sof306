package com.sof306.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.assignment.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}