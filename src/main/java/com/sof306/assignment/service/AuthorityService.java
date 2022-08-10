package com.sof306.assignment.service;

import java.util.List;

import com.sof306.assignment.entity.Authority;

public interface AuthorityService {
    List<Authority> findAuthoritiesOfAdmin();

    List<Authority> findAll();

    Authority create(Authority authority);

    void delete(Integer id);
}
