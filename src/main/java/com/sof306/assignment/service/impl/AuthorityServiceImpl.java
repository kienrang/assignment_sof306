package com.sof306.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sof306.assignment.dao.AccountRepository;
import com.sof306.assignment.dao.AuthorityRepository;
import com.sof306.assignment.entity.Account;
import com.sof306.assignment.entity.Authority;
import com.sof306.assignment.service.AuthorityService;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Authority> findAuthoritiesOfAdmin() {

        List<Account> accounts = accountRepository.getAdmin();
        return authorityRepository.authorities(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority create(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void delete(Integer id) {
        authorityRepository.deleteById(id);
    }
}
