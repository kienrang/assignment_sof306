package com.sof306.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof306.assignment.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}