package com.sof306.assignment.service;

import java.util.List;

import com.sof306.assignment.entity.Account;

public interface AccountService {
    public Account findById(String username);

    List<Account> getAdmin();

    List<Account> findAll();
}
